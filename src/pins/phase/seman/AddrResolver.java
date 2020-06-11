package pins.phase.seman;

import pins.common.report.Report;
import pins.data.ast.tree.*;
import pins.data.ast.tree.decl.*;
import pins.data.ast.tree.expr.AstArrExpr;
import pins.data.ast.tree.expr.AstAtomExpr;
import pins.data.ast.tree.expr.AstCallExpr;
import pins.data.ast.tree.expr.AstExpr;
import pins.data.ast.tree.expr.AstNameExpr;
import pins.data.ast.tree.expr.AstSfxExpr;
import pins.data.ast.tree.expr.AstStmtExpr;
import pins.data.ast.tree.expr.AstWhereExpr;
import pins.data.ast.tree.stmt.AstAssignStmt;
import pins.data.ast.tree.stmt.AstIfStmt;
import pins.data.ast.tree.stmt.AstStmt;
import pins.data.ast.tree.stmt.AstWhileStmt;
import pins.data.ast.tree.type.AstNameType;
import pins.data.ast.visitor.*;
import pins.data.semtype.SemArray;
import pins.data.semtype.SemInteger;
import pins.data.semtype.SemType;

/**
 * Address resolver.
 * 
 * The address resolver finds out which expressions denote lvalues and leaves
 * the information in {@link SemAn#isAddr}.
 */
public class AddrResolver extends AstFullVisitor<Object, Object> {

	public enum Mode {
		HEAD, BODY
	}
	
	// TODO
	public Object visit(AstTrees<?> trees, Object object) {
		for (AstTree tree : trees)
			if (tree instanceof AstTypeDecl)
				tree.accept(this, Mode.HEAD);
		for (AstTree tree : trees)
			if (tree instanceof AstTypeDecl)
				tree.accept(this, Mode.BODY);
		for (AstTree tree : trees)
			if (tree instanceof AstVarDecl)
				tree.accept(this, object);
		for (AstTree tree : trees)
			if (tree instanceof AstFunDecl)
				tree.accept(this, Mode.HEAD);
		for (AstTree tree : trees)
			if (tree instanceof AstFunDecl)
				tree.accept(this, Mode.BODY);
		return null;
	}

	public Object visit(AstStmtExpr stmtExpr, Object mode){
		for(AstStmt stmt : stmtExpr.stmts()){
			stmt.accept(this, mode);
		}

		return null;
	}

	public Object visit(AstAssignStmt assignStmt, Object mode){
		assignStmt.src().accept(this, mode);
		assignStmt.dst().accept(this, mode);

		if(!SemAn.isAddr.get(assignStmt.dst()))
			throw new Report.Error(assignStmt, "Left side of assign stmt must be LVALUE!");

		//SemAn.isAddr.put(assignStmt.dst(), true);

		return null;
	}

	public Object visit(AstAtomExpr atomExpr, Object mode){
		SemAn.isAddr.put(atomExpr, false);
		return null;
	}

	public Object visit(AstNameExpr nameExpr, Object mode){
		SemAn.isAddr.put(nameExpr, true);
		return null;
	}

	public Object visit(AstSfxExpr sfxExpr, Object mode){
		if(sfxExpr.oper() == AstSfxExpr.Oper.PTR){
			SemAn.isAddr.put(sfxExpr, true);
		}
		return null;
	}

	public Object visit(AstArrExpr arrExpr, Object mode){
		arrExpr.arr().accept(this, mode);
		arrExpr.idx().accept(this, mode);

		SemType array = SemAn.ofType.get(arrExpr.arr());
		if(array instanceof SemArray){
			SemAn.isAddr.put(arrExpr, true);                                                                                  
		}

		return null;
	}

	public Object visit(AstWhereExpr whereExpr, Object mode){
		whereExpr.expr().accept(this, mode);
		
		for(AstDecl decl : whereExpr.decls()){
			decl.accept(this, mode);
		}

		return null;
	}

	public Object visit(AstCallExpr callExpr, Object mode){
		for(AstExpr expr : callExpr.args()){
			expr.accept(this, mode);
		}

		return null;
	}

	public Object visit(AstWhileStmt whileStmt, Object mode){
		whileStmt.cond().accept(this, mode);

		for(AstStmt stmt : whileStmt.bodyStmts()){
			stmt.accept(this, mode);	
		}

		return null;
	}

	public Object visit(AstIfStmt ifStmt, Object mode){
		ifStmt.cond().accept(this, mode);
		
		for(AstStmt stmt : ifStmt.thenStmts()){
			stmt.accept(this, mode);
		}

		for(AstStmt stmt : ifStmt.elseStmts()){
			stmt.accept(this, mode);
		}

		return null;
	}
}
