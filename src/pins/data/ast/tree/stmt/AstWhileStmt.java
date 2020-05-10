package pins.data.ast.tree.stmt;

import pins.data.ast.tree.*;
import pins.data.ast.tree.expr.*;
import pins.data.ast.visitor.*;
import pins.common.report.*;

/**
 * While statement.
 */
public class AstWhileStmt extends AstNode implements AstStmt {

	/** The condition. */
	private AstExpr cond;

	/** The body statement. */
	private AstTrees<AstStmt> bodyStmts;

	/**
	 * Constructs a while statement.
	 * 
	 * @param location  The location.
	 * @param cond      The condition.
	 * @param bodyStmts The body statements.
	 */
	public AstWhileStmt(Location location, AstExpr cond, AstTrees<AstStmt> bodyStmts) {
		super(location);
		this.cond = cond;
		this.bodyStmts = bodyStmts;
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
	 * Returns the body statements.
	 * 
	 * @return The body statements.
	 */
	public final AstTrees<AstStmt> bodyStmts() {
		return bodyStmts;
	}

	public AstWhileStmt clone() {
		AstWhileStmt ast = (AstWhileStmt) super.clone();
		this.cond = cond == null ? null : cond.clone();
		this.bodyStmts = bodyStmts == null ? null : bodyStmts.clone();
		return ast;
	}

	@Override
	public <Result, Arg> Result accept(AstVisitor<Result, Arg> visitor, Arg arg) {
		return visitor.visit(this, arg);
	}

}
