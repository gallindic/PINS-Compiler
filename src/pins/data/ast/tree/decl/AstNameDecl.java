package pins.data.ast.tree.decl;

import pins.data.ast.tree.*;
import pins.common.report.*;

/**
 * Abstract name declaration.
 */
public abstract class AstNameDecl extends AstNode implements AstDecl {

	/** The declared name. */
	private String name;

	/**
	 * Constructs an abstract declaration of a name.
	 * 
	 * @param location The location.
	 * @param name     The declared name.
	 */
	public AstNameDecl(Location location, String name) {
		super(location);
		this.name = name;
	}

	/**
	 * Returns the declared name.
	 * 
	 * @return The declared name.
	 */
	public final String name() {
		return name;
	}

	@Override
	public AstNameDecl clone() {
		AstNameDecl ast = (AstNameDecl) super.clone();
		return ast;
	}

}
