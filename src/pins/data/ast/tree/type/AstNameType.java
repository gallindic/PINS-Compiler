package pins.data.ast.tree.type;

import pins.data.ast.tree.*;
import pins.data.ast.visitor.*;
import pins.common.report.*;

/**
 * Type name.
 */
public class AstNameType extends AstNode implements AstType, AstName {

	/** The name. */
	private String name;

	/**
	 * Constructs a type name.
	 * 
	 * @param location the Location.
	 * @param name     The name.
	 */
	public AstNameType(Location location, String name) {
		super(location);
		this.name = name;
	}

	/**
	 * Return the name.
	 * 
	 * @return The name.
	 */
	public final String name() {
		return name;
	}

	@Override
	public AstNameType clone() {
		AstNameType ast = (AstNameType) super.clone();
		return ast;
	}

	@Override
	public <Result, Arg> Result accept(AstVisitor<Result, Arg> visitor, Arg arg) {
		return visitor.visit(this, arg);
	}

}
