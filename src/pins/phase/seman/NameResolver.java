package pins.phase.seman;

import pins.common.report.*;
import pins.data.ast.tree.*;
import pins.data.ast.tree.decl.*;
import pins.data.ast.tree.expr.*;
import pins.data.ast.tree.stmt.*;
import pins.data.ast.tree.type.*;
import pins.data.ast.visitor.*;

/**
 * Name resolver.
 * 
 * Name resolver connects each node of a abstract syntax tree where a name is
 * used with the node where it is declared. The only exceptions are a record
 * field names which are connected with its declarations by type resolver. The
 * results of the name resolver are stored in
 * {@link pins.phase.seman.SemAn#declaredAt}.
 */
public class NameResolver extends AstFullVisitor<Object, NameResolver.Mode> {

	public enum Mode {
		HEAD, BODY
	}

	private SymbTable symbTable = new SymbTable();

	public Object visit(AstTrees<?> trees, Mode mode){
		for(AstTree tree : trees)
			if(tree instanceof AstTypeDecl)
				tree.accept(this, Mode.HEAD);
		for(AstTree tree : trees)
			if(tree instanceof AstTypeDecl)
				tree.accept(this, Mode.BODY);
		for(AstTree tree : trees)
			if(tree instanceof AstVarDecl)
				tree.accept(this, Mode.BODY);
		for(AstTree tree : trees)
			if(tree instanceof AstFunDecl)
				tree.accept(this, Mode.HEAD);
		for(AstTree tree : trees)
			if(tree instanceof AstFunDecl)
				tree.accept(this, Mode.BODY);

		return null;
	}

	// Declarations

	public Object visit(AstTypeDecl typeDecl, Mode mode){
		if(mode.equals(Mode.HEAD)){
			try{
				symbTable.ins(typeDecl.name(), typeDecl);
			} catch (SymbTable.CannotInsNameException __){
				throw new Report.Error(typeDecl, "Cannot redefine'" + (typeDecl.name()) + "' as a variable.");
			}
		}
		else if(mode.equals(Mode.BODY)){
			typeDecl.type().accept(this, mode);
		}

		return null;
	}

	public Object visit(AstFunDecl funDecl, Mode mode){
		if(mode.equals(Mode.HEAD)){
			try{
				symbTable.ins(funDecl.name(), funDecl);

				for(AstParDecl decl : funDecl.pars()){
					decl.accept(this, mode);
				}

				funDecl.type().accept(this, mode);
			} catch (SymbTable.CannotInsNameException __){
				throw new Report.Error(funDecl, "Cannot redefine'" + (funDecl.name()) + "' as a function.");
			}
		}
		else if(mode.equals(Mode.BODY)){		
			symbTable.newScope();	

			for(AstParDecl decl : funDecl.pars()){
				decl.accept(this, mode);
			}

			funDecl.expr().accept(this, mode);
			symbTable.oldScope();
		}
		
		return null;
	}

	public Object visit(AstVarDecl varDecl, Mode mode){
		try{
			symbTable.ins(varDecl.name(), varDecl);
		} catch (SymbTable.CannotInsNameException __){
			throw new Report.Error(varDecl, "Cannot redefine'" + (varDecl.name()) + "' as a variable.");
		}

		varDecl.type().accept(this, mode);

		return null;
	}

	public Object visit(AstParDecl parDecl, Mode mode){
		if(mode.equals(Mode.BODY)){
			try{
				symbTable.ins(parDecl.name(), parDecl);
			} catch (SymbTable.CannotInsNameException __){
				throw new Report.Error(parDecl, "Cannot Insert'" + (parDecl.name()) + "' parameter");
			}
		}
		else if(mode.equals(Mode.HEAD)){
			parDecl.type().accept(this, mode);
		}

		return null;
	}


	// Expressions

	public Object visit(AstCallExpr callExpr, Mode mode){
		if(mode.equals(Mode.BODY)){
			try{
				SemAn.declaredAt.put(callExpr, symbTable.fnd(callExpr.name()));
				callExpr.args().accept(this, mode);
			} catch (SymbTable.CannotFndNameException __){
				throw new Report.Error(callExpr, "Cannot find '" + (callExpr.name()) + "' function.");
			}

			for(AstExpr args : callExpr.args()){
				args.accept(this, mode);
			}
		}

		return null;
	}

	public Object visit(AstStmtExpr stmtExpr, Mode mode){
		if(mode.equals(Mode.BODY)){

			for(AstStmt statement : stmtExpr.stmts()){
				statement.accept(this, mode);
			}
		}

		return null;
	}

	public Object visit(AstBinExpr binExpr, Mode mode){
		if(mode.equals(Mode.BODY)){
			binExpr.fstExpr().accept(this, mode);
			binExpr.sndExpr().accept(this, mode);
		}

		return null;
	}

	public Object visit(AstNameExpr nameExpr, Mode mode){
		if(mode.equals(Mode.BODY)){
			try{
				SemAn.declaredAt.put(nameExpr, symbTable.fnd(nameExpr.name()));
			} catch (SymbTable.CannotFndNameException __){
				throw new Report.Error(nameExpr, "Cannot find'" + (nameExpr.name()) + "' as a named type.");
			}

		}
		return null;
	}

	public Object visit(AstWhereExpr whereExpr, Mode mode){
		if(mode.equals(Mode.BODY)){
			symbTable.newScope();

			whereExpr.expr().accept(this, mode);

			for(AstDecl decl : whereExpr.decls()){
				if(decl instanceof AstVarDecl)
					continue;

				decl.accept(this, Mode.HEAD);
			}
			for(AstDecl decl : whereExpr.decls()){
				decl.accept(this, Mode.BODY);		
			}
			
			symbTable.oldScope();
		}
		return null;
	}


	// Type

	public Object visit(AstNameType nameType, Mode mode){
		try{
			SemAn.declaredAt.put(nameType, symbTable.fnd(nameType.name()));
		} catch (SymbTable.CannotFndNameException __){
			throw new Report.Error(nameType, "Cannot find'" + (nameType.name()) + "' as a named type.");
		}

		return null;
	}

	
	// Statements

	public Object visit(AstWhileStmt whileStmt, Mode mode){
		if(mode.equals(Mode.BODY)){
			whileStmt.cond().accept(this, mode);

			for(AstStmt stamtement : whileStmt.bodyStmts()){
				stamtement.accept(this, mode);
			}
		}

		return null;
	}

	public Object visit(AstAssignStmt assignStmt, Mode mode){
		if(mode.equals(Mode.BODY)){
			assignStmt.src().accept(this, mode);
			assignStmt.dst().accept(this, mode);
		}

		return null;
	}

	public Object visit(AstIfStmt ifStmt, Mode mode){
		if(mode.equals(Mode.BODY)){
			ifStmt.cond().accept(this, mode);

			for(AstStmt stamtement : ifStmt.thenStmts()){
				stamtement.accept(this, mode);
			}

			for(AstStmt stamtement : ifStmt.elseStmts()){
				stamtement.accept(this, mode);
			}
		}

		return null;
	}

	
}
