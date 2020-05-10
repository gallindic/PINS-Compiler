package pins.data.ast.tree.expr;

import pins.data.ast.tree.*;
import pins.data.ast.visitor.*;
import pins.common.report.*;

/**
 * Variable access.
 */
public class AstNameExpr extends AstNode implements AstExpr, AstName {

	/** The name. */
	private String name;

	/**
	 * Constructs a variable access.
	 * 
	 * @param location The location.
	 * @param name     The name.
	 */
	public AstNameExpr(Location location, String name) {
		super(location);
		this.name = name;
	}

	/**
	 * Returns the name.
	 * 
	 * @return The name.
	 */
	public final String name() {
		return name;
	}

	@Override
	public AstNameExpr clone() {
		AstNameExpr ast = (AstNameExpr) super.clone();
		return ast;
	}

	@Override
	public <Result, Arg> Result accept(AstVisitor<Result, Arg> visitor, Arg arg) {
		return visitor.visit(this, arg);
	}

}
