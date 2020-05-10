package pins.data.ast.tree;

import pins.data.ast.visitor.*;
import pins.common.report.*;

/**
 * Abstract syntax tree.
 */
public interface AstTree extends Cloneable, Locatable {

	/**
	 * Returns the unique id of this node.
	 * 
	 * @return The unique id of this node.
	 */
	public abstract int id();

	public abstract AstTree clone();

	public abstract <Result, Arg> Result accept(AstVisitor<Result, Arg> visitor, Arg arg);

}
