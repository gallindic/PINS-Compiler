package pins.data.ast.tree.type;

import pins.data.ast.tree.*;
import pins.data.ast.visitor.*;
import pins.common.report.*;

/**
 * Atom type.
 */
public class AstAtomType extends AstNode implements AstType {

	/** Types. */
	public enum Type {
		VOID, CHAR, INT
	};

	/** The type of a constant. */
	private Type type;

	/**
	 * Constructs an atom type.
	 * 
	 * @param location The location.
	 * @param type     The type.
	 */
	public AstAtomType(Location location, Type type) {
		super(location);
		this.type = type;
	}

	/**
	 * Returns the type.
	 * 
	 * @return The type.
	 */
	public final Type type() {
		return type;
	}

	@Override
	public AstAtomType clone() {
		AstAtomType ast = (AstAtomType) super.clone();
		return ast;
	}

	@Override
	public <Result, Arg> Result accept(AstVisitor<Result, Arg> visitor, Arg arg) {
		return visitor.visit(this, arg);
	}

}
