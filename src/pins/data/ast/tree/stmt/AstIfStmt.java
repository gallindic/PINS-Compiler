package pins.data.ast.tree.stmt;

import pins.data.ast.tree.*;
import pins.data.ast.tree.expr.*;
import pins.data.ast.visitor.*;
import pins.common.report.*;

/**
 * If statement.
 */
public class AstIfStmt extends AstNode implements AstStmt {

	/** The condition. */
	private AstExpr cond;

	/** The statements in the then branch. */
	private AstTrees<AstStmt> thenStmts;

	/** The statements in the else branch. */
	private AstTrees<AstStmt> elseStmts;

	/**
	 * Constructs an if statement.
	 * 
	 * @param location  The location.
	 * @param cond      The condition.
	 * @param thenStmts The statements in the then branch.
	 * @param elseStmts The statements in the else branch.
	 */
	public AstIfStmt(Location location, AstExpr cond, AstTrees<AstStmt> thenStmts, AstTrees<AstStmt> elseStmts) {
		super(location);
		this.cond = cond;
		this.thenStmts = thenStmts;
		this.elseStmts = elseStmts;
	}

	/**
	 * Returns the condition.
	 * 
	 * @return The condition.
	 */
	public final AstExpr cond() {
		return cond;
	}

	/**
	 * Returns the statements in the then branch.
	 * 
	 * @return The statements in the then branch.
	 */
	public final AstTrees<AstStmt> thenStmts() {
		return thenStmts;
	}

	/**
	 * Returns the statements in the else branch.
	 * 
	 * @return The statements in the else branch.
	 */
	public final AstTrees<AstStmt> elseStmts() {
		return elseStmts;
	}

	public AstIfStmt clone() {
		AstIfStmt ast = (AstIfStmt) super.clone();
		this.cond = cond == null ? null : cond.clone();
		this.thenStmts = thenStmts == null ? null : thenStmts.clone();
		this.elseStmts = elseStmts == null ? null : elseStmts.clone();
		return ast;
	}

	@Override
	public <Result, Arg> Result accept(AstVisitor<Result, Arg> visitor, Arg arg) {
		return visitor.visit(this, arg);
	}

}
