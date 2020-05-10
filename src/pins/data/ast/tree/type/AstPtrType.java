package pins.data.ast.tree.type;

import pins.data.ast.tree.*;
import pins.data.ast.visitor.*;
import pins.common.report.*;

/**
 * Pointer type.
 */
public class AstPtrType extends AstNode implements AstType {

	/** Base type. */
	private AstType baseType;

	/**
	 * Constructs a pointer type.
	 * 
	 * @param location The location.
	 * @param baseType The base type.
	 */
	public AstPtrType(Location location, AstType baseType) {
		super(location);
		this.baseType = baseType;
	}

	/**
	 * Returns The base type.
	 * 
	 * @return the base type.
	 */
	public final AstType baseType() {
		return baseType;
	}

	@Override
	public AstPtrType clone() {
		AstPtrType ast = (AstPtrType) super.clone();
		ast.baseType = baseType == null ? null : baseType.clone();
		return ast;
	}

	@Override
	public <Result, Arg> Result accept(AstVisitor<Result, Arg> visitor, Arg arg) {
		return visitor.visit(this, arg);
	}

}
