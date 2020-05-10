package pins.data.ast.tree.type;

import pins.data.ast.tree.*;

/**
 * Abstract type.
 */
public interface AstType extends AstTree {

	@Override
	public abstract AstType clone();

}
