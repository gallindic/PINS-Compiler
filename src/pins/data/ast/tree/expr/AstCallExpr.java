package pins.data.ast.tree.expr;

import pins.data.ast.tree.*;
import pins.data.ast.visitor.*;
import pins.common.report.*;

/**
 * Subprogram call.
 */
public class AstCallExpr extends AstNameExpr {

	/** The arguments. */
	private AstTrees<AstExpr> args;

	/**
	 * Constructs a function call.
	 * 
	 * @param location The location.
	 * @param name     The name.
	 * @param args     The arguments.
	 */
	public AstCallExpr(Location location, String name, AstTrees<AstExpr> args) {
		super(location, name);
		this.args = args;
	}

	/**
	 * Returns the arguments.
	 * 
	 * @return The arguments.
	 */
	public final AstTrees<AstExpr> args() {
		return args;
	}

	@Override
	public AstCallExpr clone() {
		AstCallExpr ast = (AstCallExpr) super.clone();
		ast.args = args == null ? null : args.clone();
		return ast;
	}

	@Override
	public <Result, Arg> Result accept(AstVisitor<Result, Arg> visitor, Arg arg) {
		return visitor.visit(this, arg);
	}

}
