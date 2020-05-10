package pins.data.ast.tree.type;

import pins.data.ast.tree.*;
import pins.data.ast.tree.decl.*;
import pins.data.ast.visitor.*;
import pins.common.report.*;

/**
 * Record type.
 */
public class AstRecType extends AstNode implements AstType {

	/** Components. */
	private AstTrees<AstCompDecl> comps;

	/**
	 * Constructs a record type.
	 * 
	 * @param location The location.
	 * @param comps    The components.
	 */
	public AstRecType(Location location, AstTrees<AstCompDecl> comps) {
		super(location);
		this.comps = comps;
	}

	/**
	 * Returns the components.
	 * 
	 * @return The components.
	 */
	public final AstTrees<AstCompDecl> comps() {
		return comps;
	}

	@Override
	public AstRecType clone() {
		AstRecType ast = (AstRecType) super.clone();
		ast.comps = comps == null ? null : comps.clone();
		return ast;
	}

	@Override
	public <Result, Arg> Result accept(AstVisitor<Result, Arg> visitor, Arg arg) {
		return visitor.visit(this, arg);
	}

}
