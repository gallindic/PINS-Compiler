package pins.data.ast.tree.decl;

import pins.data.ast.tree.type.*;
import pins.data.ast.visitor.*;
import pins.common.report.*;

/**
 * Variable declaration.
 */
public class AstVarDecl extends AstMemDecl implements AstDecl {

	/**
	 * Constructs a variable declaration.
	 * 
	 * @param location The location.
	 * @param name     The name of this variable.
	 * @param type     The type of this variable.
	 */
	public AstVarDecl(Location location, String name, AstType type) {
		super(location, name, type);
	}

	@Override
	public AstVarDecl clone() {
		AstVarDecl ast = (AstVarDecl) super.clone();
		return ast;
	}
	
	@Override
	public <Result, Arg> Result accept(AstVisitor<Result, Arg> visitor, Arg arg) {
		return visitor.visit(this, arg);
	}

}
