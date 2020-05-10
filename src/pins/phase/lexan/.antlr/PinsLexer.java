// Generated from /Users/gallindic/Downloads/pins20/src/pins/phase/lexan/PinsLexer.g4 by ANTLR 4.7.1

	package pins.phase.lexan;
	import pins.common.report.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PinsLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WHITESPACE=1, LINE_COMMENT=2, NESTED_COMMENT=3, CHAR=4, DEL=5, DO=6, ELSE=7, 
		END=8, FUN=9, IF=10, INT=11, NEW=12, THEN=13, TYP=14, VAR=15, VOID=16, 
		WHERE=17, WHILE=18, NONE=19, NULL=20, INTEGER=21, CHARCONST=22, ID=23, 
		LP=24, RP=25, LB=26, RB=27, LBR=28, RBR=29, DOT=30, COMMA=31, COLON=32, 
		SEMICOLON=33, AND=34, OR=35, NEG=36, EQ=37, NEQ=38, LT=39, GT=40, LE=41, 
		GE=42, MUL=43, DIVIDE=44, MOD=45, ADD=46, MINUS=47, CARET=48, ASSIGN=49, 
		ERROR=50;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"WHITESPACE", "LINE_COMMENT", "NESTED_COMMENT", "CHAR", "DEL", "DO", "ELSE", 
		"END", "FUN", "IF", "INT", "NEW", "THEN", "TYP", "VAR", "VOID", "WHERE", 
		"WHILE", "NONE", "NULL", "INTEGER", "CHARCONST", "ID", "LP", "RP", "LB", 
		"RB", "LBR", "RBR", "DOT", "COMMA", "COLON", "SEMICOLON", "AND", "OR", 
		"NEG", "EQ", "NEQ", "LT", "GT", "LE", "GE", "MUL", "DIVIDE", "MOD", "ADD", 
		"MINUS", "CARET", "ASSIGN", "ERROR", "TEXT", "DIGIT", "ALL_USABLE_ASCII", 
		"CHARCONST_USABLE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, "'char'", "'del'", "'do'", "'else'", "'end'", 
		"'fun'", "'if'", "'int'", "'new'", "'then'", "'typ'", "'var'", "'void'", 
		"'where'", "'while'", "'none'", "'nil'", null, null, null, "'('", "')'", 
		"'['", "']'", "'{'", "'}'", "'.'", "','", "':'", "';'", "'&'", "'|'", 
		"'!'", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'*'", "'/'", "'%'", 
		"'+'", "'-'", "'^'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WHITESPACE", "LINE_COMMENT", "NESTED_COMMENT", "CHAR", "DEL", "DO", 
		"ELSE", "END", "FUN", "IF", "INT", "NEW", "THEN", "TYP", "VAR", "VOID", 
		"WHERE", "WHILE", "NONE", "NULL", "INTEGER", "CHARCONST", "ID", "LP", 
		"RP", "LB", "RB", "LBR", "RBR", "DOT", "COMMA", "COLON", "SEMICOLON", 
		"AND", "OR", "NEG", "EQ", "NEQ", "LT", "GT", "LE", "GE", "MUL", "DIVIDE", 
		"MOD", "ADD", "MINUS", "CARET", "ASSIGN", "ERROR"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	    @Override
		public LexAn.PrevToken nextToken() {
			return (LexAn.PrevToken) super.nextToken();
		}

		public void customError(String errorLexeme){
			System.out.println("Comment missing closing tag at the end of file: " + errorLexeme);
			System.exit(1);
		}

		public void customError(){
			System.out.println("[" + getLine() + "." + getCharPositionInLine() + " - " + getLine() + "." +  (getCharPositionInLine() + (getText().length() - 1)) + "] lexeme at which the error occured: " + getText());
			System.exit(1);
		}

		int nestedCommentCount = 0;


	public PinsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PinsLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 0:
			WHITESPACE_action((RuleContext)_localctx, actionIndex);
			break;
		case 2:
			NESTED_COMMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 49:
			ERROR_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void WHITESPACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 if(getText().contains("\t")) setCharPositionInLine(getCharPositionInLine() + 8 - (getCharPositionInLine() % 8)); 
			break;
		}
	}
	private void NESTED_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:

				int count = 0, fromIndex = 0;
				String comment = getText();
				while ((fromIndex = comment.indexOf("#{", fromIndex)) != -1 ){
					count++;
					fromIndex++;
				}

				fromIndex = 0;

				while ((fromIndex = comment.indexOf("}#", fromIndex)) != -1 ){
					count--;
					fromIndex++;
				}

				if(count != 0){
					customError("}#");
				}


			break;
		}
	}
	private void ERROR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			 customError(); 
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\64\u0136\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\3\2\6\2q\n\2\r\2\16\2r\3\2\3\2\3\2"+
		"\3\2\3\3\3\3\7\3{\n\3\f\3\16\3~\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\7\4\u0087"+
		"\n\4\f\4\16\4\u008a\13\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\6\26\u00df\n\26\r\26"+
		"\16\26\u00e0\3\27\3\27\3\27\3\27\3\30\3\30\3\30\7\30\u00ea\n\30\f\30\16"+
		"\30\u00ed\13\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36"+
		"\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3&\3\'\3\'"+
		"\3\'\3(\3(\3)\3)\3*\3*\3*\3+\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3"+
		"\61\3\61\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3"+
		"\67\3\67\3\67\3\67\5\67\u0135\n\67\3\u0088\28\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S"+
		"+U,W-Y.[/]\60_\61a\62c\63e\64g\2i\2k\2m\2\3\2\t\5\2\13\f\17\17\"\"\4\2"+
		"\f\f\17\17\3\2\62;\3\2))\5\2C\\aac|\3\2\"\u0080\5\2\"(*]_\u0080\2\u013a"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2e\3\2\2\2\3p\3\2\2\2\5x\3\2\2\2\7\u0081\3\2\2\2\t\u0092"+
		"\3\2\2\2\13\u0097\3\2\2\2\r\u009b\3\2\2\2\17\u009e\3\2\2\2\21\u00a3\3"+
		"\2\2\2\23\u00a7\3\2\2\2\25\u00ab\3\2\2\2\27\u00ae\3\2\2\2\31\u00b2\3\2"+
		"\2\2\33\u00b6\3\2\2\2\35\u00bb\3\2\2\2\37\u00bf\3\2\2\2!\u00c3\3\2\2\2"+
		"#\u00c8\3\2\2\2%\u00ce\3\2\2\2\'\u00d4\3\2\2\2)\u00d9\3\2\2\2+\u00de\3"+
		"\2\2\2-\u00e2\3\2\2\2/\u00e6\3\2\2\2\61\u00ee\3\2\2\2\63\u00f0\3\2\2\2"+
		"\65\u00f2\3\2\2\2\67\u00f4\3\2\2\29\u00f6\3\2\2\2;\u00f8\3\2\2\2=\u00fa"+
		"\3\2\2\2?\u00fc\3\2\2\2A\u00fe\3\2\2\2C\u0100\3\2\2\2E\u0102\3\2\2\2G"+
		"\u0104\3\2\2\2I\u0106\3\2\2\2K\u0108\3\2\2\2M\u010b\3\2\2\2O\u010e\3\2"+
		"\2\2Q\u0110\3\2\2\2S\u0112\3\2\2\2U\u0115\3\2\2\2W\u0118\3\2\2\2Y\u011a"+
		"\3\2\2\2[\u011c\3\2\2\2]\u011e\3\2\2\2_\u0120\3\2\2\2a\u0122\3\2\2\2c"+
		"\u0124\3\2\2\2e\u0126\3\2\2\2g\u0129\3\2\2\2i\u012b\3\2\2\2k\u012d\3\2"+
		"\2\2m\u0134\3\2\2\2oq\t\2\2\2po\3\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3\2\2\2"+
		"st\3\2\2\2tu\b\2\2\2uv\3\2\2\2vw\b\2\3\2w\4\3\2\2\2x|\7%\2\2y{\n\3\2\2"+
		"zy\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\177\3\2\2\2~|\3\2\2\2\177\u0080"+
		"\b\3\3\2\u0080\6\3\2\2\2\u0081\u0082\7%\2\2\u0082\u0083\7}\2\2\u0083\u0088"+
		"\3\2\2\2\u0084\u0087\5\7\4\2\u0085\u0087\13\2\2\2\u0086\u0084\3\2\2\2"+
		"\u0086\u0085\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0089\3\2\2\2\u0088\u0086"+
		"\3\2\2\2\u0089\u008b\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008c\7\177\2\2"+
		"\u008c\u008d\7%\2\2\u008d\u008e\3\2\2\2\u008e\u008f\b\4\4\2\u008f\u0090"+
		"\3\2\2\2\u0090\u0091\b\4\3\2\u0091\b\3\2\2\2\u0092\u0093\7e\2\2\u0093"+
		"\u0094\7j\2\2\u0094\u0095\7c\2\2\u0095\u0096\7t\2\2\u0096\n\3\2\2\2\u0097"+
		"\u0098\7f\2\2\u0098\u0099\7g\2\2\u0099\u009a\7n\2\2\u009a\f\3\2\2\2\u009b"+
		"\u009c\7f\2\2\u009c\u009d\7q\2\2\u009d\16\3\2\2\2\u009e\u009f\7g\2\2\u009f"+
		"\u00a0\7n\2\2\u00a0\u00a1\7u\2\2\u00a1\u00a2\7g\2\2\u00a2\20\3\2\2\2\u00a3"+
		"\u00a4\7g\2\2\u00a4\u00a5\7p\2\2\u00a5\u00a6\7f\2\2\u00a6\22\3\2\2\2\u00a7"+
		"\u00a8\7h\2\2\u00a8\u00a9\7w\2\2\u00a9\u00aa\7p\2\2\u00aa\24\3\2\2\2\u00ab"+
		"\u00ac\7k\2\2\u00ac\u00ad\7h\2\2\u00ad\26\3\2\2\2\u00ae\u00af\7k\2\2\u00af"+
		"\u00b0\7p\2\2\u00b0\u00b1\7v\2\2\u00b1\30\3\2\2\2\u00b2\u00b3\7p\2\2\u00b3"+
		"\u00b4\7g\2\2\u00b4\u00b5\7y\2\2\u00b5\32\3\2\2\2\u00b6\u00b7\7v\2\2\u00b7"+
		"\u00b8\7j\2\2\u00b8\u00b9\7g\2\2\u00b9\u00ba\7p\2\2\u00ba\34\3\2\2\2\u00bb"+
		"\u00bc\7v\2\2\u00bc\u00bd\7{\2\2\u00bd\u00be\7r\2\2\u00be\36\3\2\2\2\u00bf"+
		"\u00c0\7x\2\2\u00c0\u00c1\7c\2\2\u00c1\u00c2\7t\2\2\u00c2 \3\2\2\2\u00c3"+
		"\u00c4\7x\2\2\u00c4\u00c5\7q\2\2\u00c5\u00c6\7k\2\2\u00c6\u00c7\7f\2\2"+
		"\u00c7\"\3\2\2\2\u00c8\u00c9\7y\2\2\u00c9\u00ca\7j\2\2\u00ca\u00cb\7g"+
		"\2\2\u00cb\u00cc\7t\2\2\u00cc\u00cd\7g\2\2\u00cd$\3\2\2\2\u00ce\u00cf"+
		"\7y\2\2\u00cf\u00d0\7j\2\2\u00d0\u00d1\7k\2\2\u00d1\u00d2\7n\2\2\u00d2"+
		"\u00d3\7g\2\2\u00d3&\3\2\2\2\u00d4\u00d5\7p\2\2\u00d5\u00d6\7q\2\2\u00d6"+
		"\u00d7\7p\2\2\u00d7\u00d8\7g\2\2\u00d8(\3\2\2\2\u00d9\u00da\7p\2\2\u00da"+
		"\u00db\7k\2\2\u00db\u00dc\7n\2\2\u00dc*\3\2\2\2\u00dd\u00df\t\4\2\2\u00de"+
		"\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2"+
		"\2\2\u00e1,\3\2\2\2\u00e2\u00e3\t\5\2\2\u00e3\u00e4\5m\67\2\u00e4\u00e5"+
		"\t\5\2\2\u00e5.\3\2\2\2\u00e6\u00eb\5g\64\2\u00e7\u00ea\5g\64\2\u00e8"+
		"\u00ea\5i\65\2\u00e9\u00e7\3\2\2\2\u00e9\u00e8\3\2\2\2\u00ea\u00ed\3\2"+
		"\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\60\3\2\2\2\u00ed\u00eb"+
		"\3\2\2\2\u00ee\u00ef\7*\2\2\u00ef\62\3\2\2\2\u00f0\u00f1\7+\2\2\u00f1"+
		"\64\3\2\2\2\u00f2\u00f3\7]\2\2\u00f3\66\3\2\2\2\u00f4\u00f5\7_\2\2\u00f5"+
		"8\3\2\2\2\u00f6\u00f7\7}\2\2\u00f7:\3\2\2\2\u00f8\u00f9\7\177\2\2\u00f9"+
		"<\3\2\2\2\u00fa\u00fb\7\60\2\2\u00fb>\3\2\2\2\u00fc\u00fd\7.\2\2\u00fd"+
		"@\3\2\2\2\u00fe\u00ff\7<\2\2\u00ffB\3\2\2\2\u0100\u0101\7=\2\2\u0101D"+
		"\3\2\2\2\u0102\u0103\7(\2\2\u0103F\3\2\2\2\u0104\u0105\7~\2\2\u0105H\3"+
		"\2\2\2\u0106\u0107\7#\2\2\u0107J\3\2\2\2\u0108\u0109\7?\2\2\u0109\u010a"+
		"\7?\2\2\u010aL\3\2\2\2\u010b\u010c\7#\2\2\u010c\u010d\7?\2\2\u010dN\3"+
		"\2\2\2\u010e\u010f\7>\2\2\u010fP\3\2\2\2\u0110\u0111\7@\2\2\u0111R\3\2"+
		"\2\2\u0112\u0113\7>\2\2\u0113\u0114\7?\2\2\u0114T\3\2\2\2\u0115\u0116"+
		"\7@\2\2\u0116\u0117\7?\2\2\u0117V\3\2\2\2\u0118\u0119\7,\2\2\u0119X\3"+
		"\2\2\2\u011a\u011b\7\61\2\2\u011bZ\3\2\2\2\u011c\u011d\7\'\2\2\u011d\\"+
		"\3\2\2\2\u011e\u011f\7-\2\2\u011f^\3\2\2\2\u0120\u0121\7/\2\2\u0121`\3"+
		"\2\2\2\u0122\u0123\7`\2\2\u0123b\3\2\2\2\u0124\u0125\7?\2\2\u0125d\3\2"+
		"\2\2\u0126\u0127\13\2\2\2\u0127\u0128\b\63\5\2\u0128f\3\2\2\2\u0129\u012a"+
		"\t\6\2\2\u012ah\3\2\2\2\u012b\u012c\t\4\2\2\u012cj\3\2\2\2\u012d\u012e"+
		"\t\7\2\2\u012el\3\2\2\2\u012f\u0135\t\b\2\2\u0130\u0131\7^\2\2\u0131\u0135"+
		"\7^\2\2\u0132\u0133\7^\2\2\u0133\u0135\7)\2\2\u0134\u012f\3\2\2\2\u0134"+
		"\u0130\3\2\2\2\u0134\u0132\3\2\2\2\u0135n\3\2\2\2\13\2r|\u0086\u0088\u00e0"+
		"\u00e9\u00eb\u0134\6\3\2\2\b\2\2\3\4\3\3\63\4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}