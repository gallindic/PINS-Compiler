package pins.phase.synan;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import pins.common.report.*;
import pins.phase.*;
import pins.phase.lexan.*;

/**
 * Syntax analysis phase.
 */
public class SynAn extends Phase {
	
	// === STATIC ===

	/** The parse tree. */
	public static PinsParser.SourceContext tree;
	
	// ==============
	
	/** The ANTLR parser that actually performs syntax analysis. */
	public final PinsParser parser;

	/**
	 * Phase construction: sets up logging and the ANTLR lexer and parser.
	 */
	public SynAn(LexAn lexan) {
		super("synan");
		parser = new PinsParser(new CommonTokenStream(lexan.lexer));
		parser.removeErrorListeners();
		parser.addErrorListener(new BaseErrorListener() {
			public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
					int charPositionInLine, String msg, RecognitionException e) {
				throw new Report.Error(new Location(line, charPositionInLine),
						"Unexpected symbol '" + ((Token) offendingSymbol).getText() + "'.");
			}
		});
	}

	/**
	 * Logs a parse tree.
	 * 
	 * @param tree Parse tree to be logged.
	 */
	public void log(ParseTree tree) {
		if (logger == null)
			return;
		if (tree instanceof TerminalNodeImpl) {
			TerminalNodeImpl node = (TerminalNodeImpl) tree;
			LexAn.PrevToken token = (LexAn.PrevToken) (node.getPayload());
			token.log(logger);
		}
		if (tree instanceof ParserRuleContext) {
			ParserRuleContext node = (ParserRuleContext) tree;
			logger.begElement("nont");
			logger.addAttribute("label", PinsParser.ruleNames[node.getRuleIndex()]);
			int numChildren = node.getChildCount();
			for (int i = 0; i < numChildren; i++)
				log(node.getChild(i));
			logger.endElement();
		}
	}

}
