package pins.data.imc.code;

import pins.data.imc.visitor.*;
import pins.common.logger.*;

/**
 * Intermediate code instruction.
 */
public abstract class ImcInstr implements Loggable {

	public abstract <Result, Arg> Result accept(ImcVisitor<Result, Arg> visitor, Arg accArg);

}
