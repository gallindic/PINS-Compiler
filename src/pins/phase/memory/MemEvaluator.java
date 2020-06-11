package pins.phase.memory;

import pins.data.ast.tree.*;
import pins.data.ast.tree.decl.*;
import pins.data.ast.tree.expr.*;
import pins.data.ast.tree.stmt.AstIfStmt;
import pins.data.ast.tree.stmt.AstStmt;
import pins.data.ast.tree.stmt.AstWhileStmt;
import pins.data.ast.visitor.*;
import pins.data.semtype.*;
import pins.data.mem.*;
import pins.phase.seman.*;

/**
 * Computing memory layout: frames and accesses.
 */
public class MemEvaluator extends AstFullVisitor<Object, MemEvaluator.FunContext> {

	/**
	 * Functional context, i.e., used when traversing function and building a new
	 * frame, parameter acceses and variable acceses.
	 */
	protected class FunContext {
		public int depth = 0;
		public long locsSize = 0;
		public long argsSize = 0;
		public long parsSize = new SemPointer(new SemVoid()).size();
	}

	// GENERAL PURPOSE

	@Override
	public Object visit(AstTrees<? extends AstTree> trees, MemEvaluator.FunContext ctx) {
		if (ctx == null)
			ctx = new FunContext();

		for (AstTree t : trees){
			if (t != null)
				t.accept(this, ctx);
	}
		return null;
	}

	public Object visit(AstFunDecl funDecl, FunContext ctx){
		FunContext fun = new FunContext();
		fun.depth = ctx.depth + 1;

		MemLabel label = fun.depth > 1 ? new MemLabel() : new MemLabel(funDecl.name());

		for(AstParDecl params : funDecl.pars()){	
			params.accept(this, fun);

			fun.parsSize += 8;
		}

		funDecl.expr().accept(this, fun);
		
		Memory.frames.put(funDecl, new MemFrame(label, fun.depth, fun.locsSize, fun.argsSize));
		return null;
	}

	public Object visit(AstParDecl parDecl, FunContext ctx){
		parDecl.type().accept(this, ctx);

		long size = SemAn.isType.get(parDecl.type()).size();
		Memory.accesses.put(parDecl, new MemRelAccess(size, ctx.parsSize, ctx.depth));

		return null;
	}

	public Object visit(AstVarDecl varDecl, FunContext ctx){
		varDecl.type().accept(this, ctx);

		if(ctx.depth > 0){
			ctx.locsSize = ctx.locsSize + SemAn.isType.get(varDecl.type()).size();
			Memory.accesses.put(varDecl, new MemRelAccess(SemAn.isType.get(varDecl.type()).size(), -ctx.locsSize, ctx.depth));
		}
		else{
			Memory.accesses.put(varDecl, new MemAbsAccess(SemAn.isType.get(varDecl.type()).size(), new MemLabel(varDecl.name())));
		}
		

		return null;
	}

	public Object visit(AstStmtExpr stmtExpr, FunContext ctx){
		for(AstStmt stmt : stmtExpr.stmts()){
			stmt.accept(this, ctx);
		}

		return null;
	}

	public Object visit(AstWhereExpr whereExpr, FunContext ctx){
		for(AstDecl decl : whereExpr.decls()){
				decl.accept(this, ctx);
		}

		whereExpr.expr().accept(this, ctx);
		return null;
	}

	public Object visit(AstCallExpr callExpr, FunContext ctx){
		int newArgs = 8;

		for(AstExpr expr : callExpr.args()){
			newArgs += 8;
			expr.accept(this, ctx);
		}

		if(newArgs > ctx.argsSize)
			ctx.argsSize = newArgs;

		return null;
	}

	public Object visit(AstIfStmt ifStmt, FunContext ctx){
		ifStmt.cond().accept(this, ctx);
		
		ifStmt.thenStmts().accept(this, ctx);
		ifStmt.elseStmts().accept(this, ctx);

		return null;
	}

	public Object visit(AstWhileStmt whileStmt, FunContext ctx){
		whileStmt.cond().accept(this, ctx);

		whileStmt.bodyStmts().accept(this, ctx);

		return null;
	}
}
