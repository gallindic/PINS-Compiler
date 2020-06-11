package pins.phase.imcgen;

import java.util.*;

import pins.data.ast.tree.*;
import pins.data.ast.tree.decl.*;
import pins.data.ast.tree.expr.*;
import pins.data.ast.tree.stmt.AstStmt;
import pins.data.ast.visitor.*;
import pins.data.mem.*;
import pins.data.imc.code.expr.*;
import pins.data.imc.code.expr.ImcBINOP.Oper;
import pins.data.imc.code.stmt.ImcESTMT;
import pins.data.imc.code.stmt.ImcSTMTS;
import pins.data.imc.code.stmt.ImcStmt;
import pins.phase.seman.*;
import pins.phase.memory.*;

public class ExprGenerator implements AstVisitor<ImcExpr, Stack<MemFrame>> {

	// TODO
	public ImcExpr visit(AstTrees<?> trees, Stack<MemFrame> frame) {
		for (AstTree tree : trees)
			if (tree instanceof AstTypeDecl)
				tree.accept(this, frame);
		for (AstTree tree : trees)
			if (tree instanceof AstVarDecl)
				tree.accept(this, frame);
		for (AstTree tree : trees)
			if (tree instanceof AstFunDecl)
				tree.accept(this, frame);
				
		return null;
	}

	// AstDecl

	public ImcExpr visit(AstFunDecl funDecl, Stack<MemFrame> frame) {
		frame.push(Memory.frames.get(funDecl));

		funDecl.expr().accept(this, frame);
		frame.pop();

		return null;
	}

	public ImcExpr visit(AstParDecl parDecl, Stack<MemFrame> frame) {

		

		return null;
	}

	public ImcExpr visit(AstVarDecl varDecl, Stack<MemFrame> frame) {
		
		
		return null;
	}

	public ImcExpr visit(AstTypeDecl typeDecl, Stack<MemFrame> frame) {

		return null;
	}



	//Expr

	public ImcExpr visit(AstBinExpr binExpr, Stack<MemFrame> frame) {
		binExpr.fstExpr().accept(this, frame);
		binExpr.sndExpr().accept(this, frame);

		Oper op = null;

		if(binExpr.oper() == AstBinExpr.Oper.ADD)
			op = Oper.ADD;
		else if(binExpr.oper() == AstBinExpr.Oper.SUB)
			op = Oper.SUB;
		else if(binExpr.oper() == AstBinExpr.Oper.DIV)
			op = Oper.DIV;
		else if(binExpr.oper() == AstBinExpr.Oper.MUL)
			op = Oper.MUL;
		else if(binExpr.oper() == AstBinExpr.Oper.MOD)
			op = Oper.MOD;
		else if(binExpr.oper() == AstBinExpr.Oper.LTH)
			op = Oper.LTH;
		else if(binExpr.oper() == AstBinExpr.Oper.GTH)
			op = Oper.GTH;
		else if(binExpr.oper() == AstBinExpr.Oper.EQU)
			op = Oper.EQU;
		else if(binExpr.oper() == AstBinExpr.Oper.NEQ)
			op = Oper.NEQ;
		else if(binExpr.oper() == AstBinExpr.Oper.GEQ)
			op = Oper.GEQ;
		else if(binExpr.oper() == AstBinExpr.Oper.LEQ)
			op = Oper.LEQ;

		ImcGen.exprImc.put(binExpr, new ImcBINOP(op, ImcGen.exprImc.get(binExpr.fstExpr()), ImcGen.exprImc.get(binExpr.sndExpr())));

		return null;
	}

	public ImcExpr visit(AstAtomExpr atomExpr, Stack<MemFrame> frame) {
		if(atomExpr.type() == AstAtomExpr.Type.INT){
			ImcExpr c = new ImcCONST(Long.parseLong(atomExpr.value()));
			ImcGen.exprImc.put(atomExpr, c);
		}
		else if(atomExpr.type() == AstAtomExpr.Type.CHAR){
			ImcExpr c;
			if(atomExpr.value().charAt(1) == '\\'){
				c = new ImcCONST(atomExpr.value().charAt(2));
			}
			else{
				c = new ImcCONST(atomExpr.value().charAt(1));
			}
			
			ImcGen.exprImc.put(atomExpr, c);
		}

		return null;
	}

	public ImcExpr visit(AstArrExpr arrExpr, Stack<MemFrame> frame) {
		arrExpr.arr().accept(this, frame);
		arrExpr.idx().accept(this, frame);

		MemAccess memAccess = Memory.accesses.get((AstVarDecl)SemAn.declaredAt.get((AstNameExpr)arrExpr.arr()));
		ImcExpr name;

		if(memAccess instanceof MemRelAccess){
			name = new ImcMEM(new ImcBINOP(Oper.ADD, new ImcTEMP(frame.peek().FP), new ImcCONST(((MemRelAccess)memAccess).offset)));
		}
		else{
			name  = new ImcNAME(((MemAbsAccess) memAccess).label);
		}

		ImcBINOP index = new ImcBINOP(Oper.MUL, new ImcCONST(8), ImcGen.exprImc.get(arrExpr.idx()));
		ImcMEM array = new ImcMEM(new ImcBINOP(Oper.ADD, name, index));

		ImcGen.exprImc.put(arrExpr, array);

		return null;
	}

	public ImcExpr visit(AstNameExpr nameExpr, Stack<MemFrame> frame) {
		ImcExpr mem = null;
		
		if(SemAn.declaredAt.get(nameExpr) instanceof AstVarDecl){	//Lokalne spr. dostop
			MemAccess ac = Memory.accesses.get((AstVarDecl)SemAn.declaredAt.get(nameExpr));

			if(ac instanceof MemRelAccess){
				mem = new ImcMEM(new ImcBINOP(Oper.ADD, new ImcTEMP(frame.peek().FP), new ImcCONST(((MemRelAccess)ac).offset)));
			}
			else{
				ImcExpr name = new ImcNAME(((MemAbsAccess) ac).label);
				mem = new ImcMEM(name);
			}	
		}
		else if(SemAn.declaredAt.get(nameExpr) instanceof AstParDecl){	//Parametri dostop
			MemAccess ac = Memory.accesses.get((AstParDecl)SemAn.declaredAt.get(nameExpr));
			mem = new ImcMEM(new ImcBINOP(Oper.ADD, new ImcTEMP(frame.peek().FP), new ImcCONST(((MemRelAccess)ac).offset)));
		}

		ImcGen.exprImc.put(nameExpr, mem);

		return null;
	}

	public ImcExpr visit(AstPfxExpr pfxExpr, Stack<MemFrame> frame) {
		if(pfxExpr.oper() == AstPfxExpr.Oper.SUB){
			pfxExpr.expr().accept(this, frame);

			ImcExpr unop = new ImcUNOP(ImcUNOP.Oper.NEG, ImcGen.exprImc.get(pfxExpr.expr()));
			ImcGen.exprImc.put(pfxExpr, unop);
		}

		return null;
	}

	public ImcExpr visit(AstCallExpr callExpr, Stack<MemFrame> frame) {
		Vector<ImcExpr> imcExprs = new Vector<>();
		Vector<Long> offset = new Vector<>();

		imcExprs.add(new ImcCONST(0));
		offset.add((long)0);

		for(AstExpr expr : callExpr.args()){
			expr.accept(this, frame);

			imcExprs.add(ImcGen.exprImc.get(expr));
			offset.add((long) 8);
		}

		AstFunDecl fDecl = (AstFunDecl) SemAn.declaredAt.get(callExpr);
		MemLabel fLabel = Memory.frames.get(fDecl).label;

		ImcGen.exprImc.put(callExpr, new ImcCALL(fLabel, offset, imcExprs));

		return null;
	}

	public ImcExpr visit(AstWhereExpr whereExpr, Stack<MemFrame> frame) {
		whereExpr.decls().accept(this, frame);
		whereExpr.expr().accept(this, frame);

		ImcGen.exprImc.put(whereExpr, ImcGen.exprImc.get(whereExpr.expr()));
		return null;
	}

	public ImcExpr visit(AstCastExpr castExpr, Stack<MemFrame> frame) {
		castExpr.expr().accept(this, frame);
		
		ImcGen.exprImc.put(castExpr, ImcGen.exprImc.get(castExpr.expr()));

		return null;
	}

	//STMT

	public ImcExpr visit(AstStmtExpr stmtExpr, Stack<MemFrame> frame) {
		Vector<ImcStmt> imcStmts = new Vector<>();
		StmtGenerator stmtGenerator = new StmtGenerator();

		for(AstStmt stmt : stmtExpr.stmts()){
			ImcStmt statement = stmt.accept(stmtGenerator, frame);
			imcStmts.add(statement);
		}

		ImcSTMTS imcSt = new ImcSTMTS(imcStmts);
		ImcSEXPR sexpr;

		if(imcStmts.lastElement() instanceof ImcESTMT){
			sexpr = new ImcSEXPR(imcSt, ((ImcESTMT)imcStmts.lastElement()).expr);
		}
		else{
			sexpr = new ImcSEXPR(imcSt, new ImcCONST(0));
		}

		ImcGen.exprImc.put(stmtExpr, sexpr);

		return sexpr;
	}
}
