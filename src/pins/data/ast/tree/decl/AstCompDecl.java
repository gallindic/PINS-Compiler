package pins.data.ast.tree.decl;

import pins.data.ast.tree.type.*;
import pins.data.ast.visitor.*;
import pins.common.report.*;

/**
 * Component declaration.
 */
public class AstCompDecl extends AstMemDecl {

	/**
	 * Constructs a component declaration.
	 * 
	 * @param location The location.
	 * @param name     The name of this component.
	 * @param type     The type of this component.
	 */
	public AstCompDecl(Location location, String name, AstType type) {
		super(location, name, type);
	}
	
	@Override
	public AstCompDecl clone() {
		AstCompDecl ast = (AstCompDecl) super.clone();
		return ast;
	}

	@Override
	public <Result, Arg> Result accept(AstVisitor<Result, Arg> visitor, Arg arg) {
		return visitor.visit(this, arg);
	}

}
