package pins.data.ast.tree.decl;

import pins.data.ast.tree.type.*;
import pins.data.ast.visitor.*;
import pins.common.report.*;

/**
 * Type declaration.
 */
public class AstTypeDecl extends AstNameDecl {

	/** The representation of this type. */
	private AstType type;

	/**
	 * Constructs a type declaration.
	 * 
	 * @param location The location.
	 * @param name     The name of this type.
	 * @param type     The representation of this type.
	 */
	public AstTypeDecl(Location location, String name, AstType type) {
		super(location, name);
		this.type = type;
	}

	/**
	 * Returns the representation of this type.
	 * 
	 * @return The representation of this type.
	 */
	public final AstType type() {
		return type;
	}

	@Override
	public AstTypeDecl clone() {
		AstTypeDecl ast = (AstTypeDecl) super.clone();
		ast.type = type == null ? null : type.clone();
		return ast;
	}

	@Override
	public <Result, Arg> Result accept(AstVisitor<Result, Arg> visitor, Arg arg) {
		return visitor.visit(this, arg);
	}

}
