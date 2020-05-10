// Generated from synan/PinsParser.g4 by ANTLR 4.8


	package pins.phase.synan;
	
	import java.util.*;
	
	import pins.common.report.*;
	import pins.phase.lexan.*;
  import pins.data.ast.tree.*;
  import pins.data.ast.tree.decl.*;
  import pins.data.ast.tree.type.*;
  import pins.data.ast.tree.expr.*;
	import pins.data.ast.tree.stmt.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PinsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

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
	public static final int
		RULE_source = 0, RULE_decl = 1, RULE_param = 2, RULE_type = 3, RULE_arr = 4, 
		RULE_atomic = 5, RULE_expr = 6, RULE_statement = 7, RULE_disjunctive = 8, 
		RULE_conjunctive = 9, RULE_relation = 10, RULE_additive = 11, RULE_add_sec = 12, 
		RULE_multiplicative = 13, RULE_prefix = 14, RULE_postfix = 15, RULE_postfix_sec = 16, 
		RULE_variable = 17, RULE_function = 18, RULE_enclosed = 19, RULE_stmt = 20, 
		RULE_expression = 21, RULE_loop = 22, RULE_conditional = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"source", "decl", "param", "type", "arr", "atomic", "expr", "statement", 
			"disjunctive", "conjunctive", "relation", "additive", "add_sec", "multiplicative", 
			"prefix", "postfix", "postfix_sec", "variable", "function", "enclosed", 
			"stmt", "expression", "loop", "conditional"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'char'", "'del'", "'do'", "'else'", "'end'", 
			"'fun'", "'if'", "'int'", "'new'", "'then'", "'typ'", "'var'", "'void'", 
			"'where'", "'while'", "'none'", "'nil'", null, null, null, "'('", "')'", 
			"'['", "']'", "'{'", "'}'", "'.'", "','", "':'", "';'", "'&'", "'|'", 
			"'!'", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'*'", "'/'", "'%'", 
			"'+'", "'-'", "'^'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WHITESPACE", "LINE_COMMENT", "NESTED_COMMENT", "CHAR", "DEL", 
			"DO", "ELSE", "END", "FUN", "IF", "INT", "NEW", "THEN", "TYP", "VAR", 
			"VOID", "WHERE", "WHILE", "NONE", "NULL", "INTEGER", "CHARCONST", "ID", 
			"LP", "RP", "LB", "RB", "LBR", "RBR", "DOT", "COMMA", "COLON", "SEMICOLON", 
			"AND", "OR", "NEG", "EQ", "NEQ", "LT", "GT", "LE", "GE", "MUL", "DIVIDE", 
			"MOD", "ADD", "MINUS", "CARET", "ASSIGN", "ERROR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "PinsParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }




	public PinsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SourceContext extends ParserRuleContext {
		public AstTrees<AstDecl> ast;
		public DeclContext decl;
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public SourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_source; }
	}

	public final SourceContext source() throws RecognitionException {
		SourceContext _localctx = new SourceContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_source);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 Vector decls = new Vector(); 
			setState(52); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(49);
				((SourceContext)_localctx).decl = decl();
				 decls.add(((SourceContext)_localctx).decl.ast); 
				}
				}
				setState(54); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FUN) | (1L << TYP) | (1L << VAR))) != 0) );
			 ((SourceContext)_localctx).ast =  new AstTrees(decls); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public AstDecl ast;
		public Token t;
		public Token ID;
		public TypeContext type;
		public Token s;
		public Token v;
		public Token f;
		public ParamContext param;
		public ExprContext expr;
		public TerminalNode ID() { return getToken(PinsParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(PinsParser.ASSIGN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode TYP() { return getToken(PinsParser.TYP, 0); }
		public TerminalNode SEMICOLON() { return getToken(PinsParser.SEMICOLON, 0); }
		public TerminalNode COLON() { return getToken(PinsParser.COLON, 0); }
		public TerminalNode VAR() { return getToken(PinsParser.VAR, 0); }
		public TerminalNode LP() { return getToken(PinsParser.LP, 0); }
		public TerminalNode RP() { return getToken(PinsParser.RP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FUN() { return getToken(PinsParser.FUN, 0); }
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PinsParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PinsParser.COMMA, i);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		int _la;
		try {
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYP:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				((DeclContext)_localctx).t = match(TYP);
				setState(59);
				((DeclContext)_localctx).ID = match(ID);
				setState(60);
				match(ASSIGN);
				setState(61);
				((DeclContext)_localctx).type = type();
				setState(62);
				((DeclContext)_localctx).s = match(SEMICOLON);
				 ((DeclContext)_localctx).ast =  new AstTypeDecl(new Location(((DeclContext)_localctx).t.getLine(),((DeclContext)_localctx).t.getCharPositionInLine(),((DeclContext)_localctx).s.getLine(),
				    ((DeclContext)_localctx).s.getCharPositionInLine()+(((DeclContext)_localctx).s!=null?((DeclContext)_localctx).s.getText():null).length() - 1), (((DeclContext)_localctx).ID!=null?((DeclContext)_localctx).ID.getText():null), ((DeclContext)_localctx).type.ast); 
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				((DeclContext)_localctx).v = match(VAR);
				setState(66);
				((DeclContext)_localctx).ID = match(ID);
				setState(67);
				match(COLON);
				setState(68);
				((DeclContext)_localctx).type = type();
				setState(69);
				((DeclContext)_localctx).s = match(SEMICOLON);
				 ((DeclContext)_localctx).ast =  new AstVarDecl(new Location(((DeclContext)_localctx).v.getLine(),((DeclContext)_localctx).v.getCharPositionInLine(),((DeclContext)_localctx).s.getLine(),((DeclContext)_localctx).s.getCharPositionInLine()+(((DeclContext)_localctx).s!=null?((DeclContext)_localctx).s.getText():null).length() - 1),
				      (((DeclContext)_localctx).ID!=null?((DeclContext)_localctx).ID.getText():null), ((DeclContext)_localctx).type.ast); 
				}
				break;
			case FUN:
				enterOuterAlt(_localctx, 3);
				{
				 Vector vector = new Vector(); 
				setState(73);
				((DeclContext)_localctx).f = match(FUN);
				setState(74);
				((DeclContext)_localctx).ID = match(ID);
				setState(75);
				match(LP);
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					{
					setState(76);
					((DeclContext)_localctx).param = param();
					 vector.add(((DeclContext)_localctx).param.ast); 
					}
					setState(85);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(79);
						match(COMMA);
						setState(80);
						((DeclContext)_localctx).param = param();
						 vector.add(((DeclContext)_localctx).param.ast); 
						}
						}
						setState(87);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(90);
				match(RP);
				setState(91);
				match(COLON);
				setState(92);
				((DeclContext)_localctx).type = type();
				setState(93);
				match(ASSIGN);
				setState(94);
				((DeclContext)_localctx).expr = expr();
				setState(95);
				((DeclContext)_localctx).s = match(SEMICOLON);
				 AstTrees<AstParDecl> params = new AstTrees(vector); 
				 ((DeclContext)_localctx).ast =  new AstFunDecl(new Location(((DeclContext)_localctx).f.getLine(),((DeclContext)_localctx).f.getCharPositionInLine(),((DeclContext)_localctx).s.getLine(),((DeclContext)_localctx).s.getCharPositionInLine()+(((DeclContext)_localctx).s!=null?((DeclContext)_localctx).s.getText():null).length() - 1), (((DeclContext)_localctx).ID!=null?((DeclContext)_localctx).ID.getText():null),
				      params, ((DeclContext)_localctx).type.ast, ((DeclContext)_localctx).expr.ast); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public AstParDecl ast;
		public Token i;
		public TypeContext j;
		public TerminalNode COLON() { return getToken(PinsParser.COLON, 0); }
		public TerminalNode ID() { return getToken(PinsParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			((ParamContext)_localctx).i = match(ID);
			setState(102);
			match(COLON);
			setState(103);
			((ParamContext)_localctx).j = type();
			 ((ParamContext)_localctx).ast =  new AstParDecl(new Location(((ParamContext)_localctx).i.getLine(), ((ParamContext)_localctx).i.getCharPositionInLine(), ((ParamContext)_localctx).j.ast.location().getEndLine(), ((ParamContext)_localctx).j.ast.location().getEndColumn()), (((ParamContext)_localctx).i!=null?((ParamContext)_localctx).i.getText():null), ((ParamContext)_localctx).j.ast); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public AstType ast;
		public Token i;
		public TypeContext type;
		public ArrContext arr;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode CARET() { return getToken(PinsParser.CARET, 0); }
		public ArrContext arr() {
			return getRuleContext(ArrContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		try {
			setState(113);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CARET:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				((TypeContext)_localctx).i = match(CARET);
				setState(107);
				((TypeContext)_localctx).type = type();
				 ((TypeContext)_localctx).ast =  new AstPtrType(new Location(((TypeContext)_localctx).i.getLine(),((TypeContext)_localctx).i.getCharPositionInLine(),((TypeContext)_localctx).i.getLine(),((TypeContext)_localctx).i.getCharPositionInLine()+(((TypeContext)_localctx).i!=null?((TypeContext)_localctx).i.getText():null).length() - 1), ((TypeContext)_localctx).type.ast );
				}
				break;
			case CHAR:
			case INT:
			case VOID:
			case ID:
			case LP:
			case LB:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				((TypeContext)_localctx).arr = arr();
				 ((TypeContext)_localctx).ast =  ((TypeContext)_localctx).arr.ast; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrContext extends ParserRuleContext {
		public AstType ast;
		public AtomicContext atomic;
		public Token i;
		public ExprContext expr;
		public TypeContext type;
		public AtomicContext atomic() {
			return getRuleContext(AtomicContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RB() { return getToken(PinsParser.RB, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode LB() { return getToken(PinsParser.LB, 0); }
		public ArrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arr; }
	}

	public final ArrContext arr() throws RecognitionException {
		ArrContext _localctx = new ArrContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_arr);
		try {
			setState(124);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CHAR:
			case INT:
			case VOID:
			case ID:
			case LP:
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				((ArrContext)_localctx).atomic = atomic();
				 ((ArrContext)_localctx).ast =  ((ArrContext)_localctx).atomic.ast; 
				}
				break;
			case LB:
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				((ArrContext)_localctx).i = match(LB);
				setState(119);
				((ArrContext)_localctx).expr = expr();
				setState(120);
				match(RB);
				setState(121);
				((ArrContext)_localctx).type = type();
				 ((ArrContext)_localctx).ast =  new AstArrType(new Location(((ArrContext)_localctx).i.getLine(), ((ArrContext)_localctx).i.getCharPositionInLine(), ((ArrContext)_localctx).type.ast.location().getEndLine(), ((ArrContext)_localctx).type.ast.location().getEndColumn()), ((ArrContext)_localctx).type.ast, ((ArrContext)_localctx).expr.ast ) ;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomicContext extends ParserRuleContext {
		public AstType ast;
		public Token i;
		public TypeContext type;
		public Token j;
		public TerminalNode VOID() { return getToken(PinsParser.VOID, 0); }
		public TerminalNode CHAR() { return getToken(PinsParser.CHAR, 0); }
		public TerminalNode INT() { return getToken(PinsParser.INT, 0); }
		public TerminalNode ID() { return getToken(PinsParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode LP() { return getToken(PinsParser.LP, 0); }
		public TerminalNode RP() { return getToken(PinsParser.RP, 0); }
		public AtomicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomic; }
	}

	public final AtomicContext atomic() throws RecognitionException {
		AtomicContext _localctx = new AtomicContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_atomic);
		try {
			setState(140);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				((AtomicContext)_localctx).i = match(VOID);
				 ((AtomicContext)_localctx).ast =  new AstAtomType(new Location(((AtomicContext)_localctx).i.getLine(),((AtomicContext)_localctx).i.getCharPositionInLine(),((AtomicContext)_localctx).i.getLine(),((AtomicContext)_localctx).i.getCharPositionInLine()+(((AtomicContext)_localctx).i!=null?((AtomicContext)_localctx).i.getText():null).length() - 1), AstAtomType.Type.VOID );
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				((AtomicContext)_localctx).i = match(CHAR);
				 ((AtomicContext)_localctx).ast =  new AstAtomType(new Location(((AtomicContext)_localctx).i.getLine(),((AtomicContext)_localctx).i.getCharPositionInLine(),((AtomicContext)_localctx).i.getLine(),((AtomicContext)_localctx).i.getCharPositionInLine()+(((AtomicContext)_localctx).i!=null?((AtomicContext)_localctx).i.getText():null).length() - 1), AstAtomType.Type.CHAR );
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 3);
				{
				setState(130);
				((AtomicContext)_localctx).i = match(INT);
				 ((AtomicContext)_localctx).ast =  new AstAtomType(new Location(((AtomicContext)_localctx).i.getLine(),((AtomicContext)_localctx).i.getCharPositionInLine(),((AtomicContext)_localctx).i.getLine(),((AtomicContext)_localctx).i.getCharPositionInLine()+(((AtomicContext)_localctx).i!=null?((AtomicContext)_localctx).i.getText():null).length() - 1), AstAtomType.Type.INT );
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(132);
				((AtomicContext)_localctx).i = match(ID);
				 ((AtomicContext)_localctx).ast =  new AstNameType(new Location(((AtomicContext)_localctx).i.getLine(),((AtomicContext)_localctx).i.getCharPositionInLine(),((AtomicContext)_localctx).i.getLine(),((AtomicContext)_localctx).i.getCharPositionInLine()+(((AtomicContext)_localctx).i!=null?((AtomicContext)_localctx).i.getText():null).length() - 1), (((AtomicContext)_localctx).i!=null?((AtomicContext)_localctx).i.getText():null) );
				}
				break;
			case LP:
				enterOuterAlt(_localctx, 5);
				{
				setState(134);
				((AtomicContext)_localctx).i = match(LP);
				setState(135);
				((AtomicContext)_localctx).type = type();
				setState(136);
				((AtomicContext)_localctx).j = match(RP);
				 ((AtomicContext)_localctx).type.ast.relocate(new Location(((AtomicContext)_localctx).i.getLine(), ((AtomicContext)_localctx).i.getCharPositionInLine(), ((AtomicContext)_localctx).j.getLine(),((AtomicContext)_localctx).j.getCharPositionInLine()+(((AtomicContext)_localctx).j!=null?((AtomicContext)_localctx).j.getText():null).length() - 1));
				 ((AtomicContext)_localctx).ast =  ((AtomicContext)_localctx).type.ast; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public AstExpr ast;
		public DisjunctiveContext disjunctive;
		public StatementContext statement;
		public DisjunctiveContext disjunctive() {
			return getRuleContext(DisjunctiveContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_expr);
		try {
			setState(148);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DEL:
			case NEW:
			case NONE:
			case NULL:
			case INTEGER:
			case CHARCONST:
			case ID:
			case LP:
			case NEG:
			case ADD:
			case MINUS:
			case CARET:
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				((ExprContext)_localctx).disjunctive = disjunctive();
				 ((ExprContext)_localctx).ast =  ((ExprContext)_localctx).disjunctive.ast; 
				}
				break;
			case LBR:
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				((ExprContext)_localctx).statement = statement();
				 ((ExprContext)_localctx).ast =  ((ExprContext)_localctx).statement.ast; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public AstExpr ast;
		public Token i;
		public StmtContext stmt;
		public Token j;
		public TerminalNode LBR() { return getToken(PinsParser.LBR, 0); }
		public TerminalNode RBR() { return getToken(PinsParser.RBR, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 Vector vector = new Vector(); 
			setState(151);
			((StatementContext)_localctx).i = match(LBR);
			setState(155); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(152);
				((StatementContext)_localctx).stmt = stmt();
				 vector.add(((StatementContext)_localctx).stmt.ast); 
				}
				}
				setState(157); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEL) | (1L << IF) | (1L << NEW) | (1L << WHILE) | (1L << NONE) | (1L << NULL) | (1L << INTEGER) | (1L << CHARCONST) | (1L << ID) | (1L << LP) | (1L << LBR) | (1L << NEG) | (1L << ADD) | (1L << MINUS) | (1L << CARET))) != 0) );
			setState(159);
			((StatementContext)_localctx).j = match(RBR);
			 AstTrees<AstStmt> statements = new AstTrees(vector); 
			 ((StatementContext)_localctx).ast =  new AstStmtExpr(new Location(((StatementContext)_localctx).i.getLine(),((StatementContext)_localctx).i.getCharPositionInLine(),((StatementContext)_localctx).j.getLine(),
			      ((StatementContext)_localctx).j.getCharPositionInLine()+(((StatementContext)_localctx).j!=null?((StatementContext)_localctx).j.getText():null).length() - 1), statements); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DisjunctiveContext extends ParserRuleContext {
		public AstExpr ast;
		public ConjunctiveContext i;
		public DisjunctiveContext j;
		public ConjunctiveContext conjunctive;
		public TerminalNode OR() { return getToken(PinsParser.OR, 0); }
		public ConjunctiveContext conjunctive() {
			return getRuleContext(ConjunctiveContext.class,0);
		}
		public DisjunctiveContext disjunctive() {
			return getRuleContext(DisjunctiveContext.class,0);
		}
		public DisjunctiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disjunctive; }
	}

	public final DisjunctiveContext disjunctive() throws RecognitionException {
		DisjunctiveContext _localctx = new DisjunctiveContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_disjunctive);
		try {
			setState(171);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				((DisjunctiveContext)_localctx).i = conjunctive();
				setState(164);
				match(OR);
				setState(165);
				((DisjunctiveContext)_localctx).j = disjunctive();
				 ((DisjunctiveContext)_localctx).ast =  new AstBinExpr(new Location(((DisjunctiveContext)_localctx).i.ast.location().getStartLine(), ((DisjunctiveContext)_localctx).i.ast.location().getStartColumn(), 
				      ((DisjunctiveContext)_localctx).j.ast.location().getEndLine(), ((DisjunctiveContext)_localctx).j.ast.location().getEndColumn()), AstBinExpr.Oper.OR, ((DisjunctiveContext)_localctx).i.ast, ((DisjunctiveContext)_localctx).j.ast); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				((DisjunctiveContext)_localctx).conjunctive = conjunctive();
				 ((DisjunctiveContext)_localctx).ast =  ((DisjunctiveContext)_localctx).conjunctive.ast; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConjunctiveContext extends ParserRuleContext {
		public AstExpr ast;
		public RelationContext i;
		public ConjunctiveContext j;
		public RelationContext relation;
		public TerminalNode AND() { return getToken(PinsParser.AND, 0); }
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
		}
		public ConjunctiveContext conjunctive() {
			return getRuleContext(ConjunctiveContext.class,0);
		}
		public ConjunctiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjunctive; }
	}

	public final ConjunctiveContext conjunctive() throws RecognitionException {
		ConjunctiveContext _localctx = new ConjunctiveContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_conjunctive);
		try {
			setState(181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				((ConjunctiveContext)_localctx).i = relation();
				setState(174);
				match(AND);
				setState(175);
				((ConjunctiveContext)_localctx).j = conjunctive();
				 ((ConjunctiveContext)_localctx).ast =  new AstBinExpr(new Location(((ConjunctiveContext)_localctx).i.ast.location().getStartLine(), ((ConjunctiveContext)_localctx).i.ast.location().getStartColumn(),
				     ((ConjunctiveContext)_localctx).j.ast.location().getEndLine(),
				     ((ConjunctiveContext)_localctx).j.ast.location().getEndColumn()), AstBinExpr.Oper.AND, ((ConjunctiveContext)_localctx).i.ast, ((ConjunctiveContext)_localctx).j.ast); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				((ConjunctiveContext)_localctx).relation = relation();
				 ((ConjunctiveContext)_localctx).ast =  ((ConjunctiveContext)_localctx).relation.ast; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationContext extends ParserRuleContext {
		public AstExpr ast;
		public AdditiveContext additive;
		public AdditiveContext i;
		public RelationContext j;
		public AdditiveContext additive() {
			return getRuleContext(AdditiveContext.class,0);
		}
		public TerminalNode EQ() { return getToken(PinsParser.EQ, 0); }
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
		}
		public TerminalNode NEQ() { return getToken(PinsParser.NEQ, 0); }
		public TerminalNode LT() { return getToken(PinsParser.LT, 0); }
		public TerminalNode GT() { return getToken(PinsParser.GT, 0); }
		public TerminalNode LE() { return getToken(PinsParser.LE, 0); }
		public TerminalNode GE() { return getToken(PinsParser.GE, 0); }
		public RelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation; }
	}

	public final RelationContext relation() throws RecognitionException {
		RelationContext _localctx = new RelationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_relation);
		try {
			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				((RelationContext)_localctx).additive = additive();
				 ((RelationContext)_localctx).ast =  ((RelationContext)_localctx).additive.ast; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				((RelationContext)_localctx).i = additive();
				setState(187);
				match(EQ);
				setState(188);
				((RelationContext)_localctx).j = relation();
				 ((RelationContext)_localctx).ast =  new AstBinExpr(new Location(((RelationContext)_localctx).i.ast.location().getStartLine(), ((RelationContext)_localctx).i.ast.location().getStartColumn(), ((RelationContext)_localctx).j.ast.location().getEndLine(), ((RelationContext)_localctx).j.ast.location().getEndColumn()), AstBinExpr.Oper.EQU, ((RelationContext)_localctx).i.ast, ((RelationContext)_localctx).j.ast); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(191);
				((RelationContext)_localctx).i = additive();
				setState(192);
				match(NEQ);
				setState(193);
				((RelationContext)_localctx).j = relation();
				 ((RelationContext)_localctx).ast =  new AstBinExpr(new Location(((RelationContext)_localctx).i.ast.location().getStartLine(), ((RelationContext)_localctx).i.ast.location().getStartColumn(), ((RelationContext)_localctx).j.ast.location().getEndLine(), ((RelationContext)_localctx).j.ast.location().getEndColumn()), AstBinExpr.Oper.NEQ, ((RelationContext)_localctx).i.ast, ((RelationContext)_localctx).j.ast); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(196);
				((RelationContext)_localctx).i = additive();
				setState(197);
				match(LT);
				setState(198);
				((RelationContext)_localctx).j = relation();
				 ((RelationContext)_localctx).ast =  new AstBinExpr(new Location(((RelationContext)_localctx).i.ast.location().getStartLine(), ((RelationContext)_localctx).i.ast.location().getStartColumn(), ((RelationContext)_localctx).j.ast.location().getEndLine(), ((RelationContext)_localctx).j.ast.location().getEndColumn()), AstBinExpr.Oper.LTH, ((RelationContext)_localctx).i.ast, ((RelationContext)_localctx).j.ast); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(201);
				((RelationContext)_localctx).i = additive();
				setState(202);
				match(GT);
				setState(203);
				((RelationContext)_localctx).j = relation();
				 ((RelationContext)_localctx).ast =  new AstBinExpr(new Location(((RelationContext)_localctx).i.ast.location().getStartLine(), ((RelationContext)_localctx).i.ast.location().getStartColumn(), ((RelationContext)_localctx).j.ast.location().getEndLine(), ((RelationContext)_localctx).j.ast.location().getEndColumn()), AstBinExpr.Oper.GTH, ((RelationContext)_localctx).i.ast, ((RelationContext)_localctx).j.ast); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(206);
				((RelationContext)_localctx).i = additive();
				setState(207);
				match(LE);
				setState(208);
				((RelationContext)_localctx).j = relation();
				 ((RelationContext)_localctx).ast =  new AstBinExpr(new Location(((RelationContext)_localctx).i.ast.location().getStartLine(), ((RelationContext)_localctx).i.ast.location().getStartColumn(), ((RelationContext)_localctx).j.ast.location().getEndLine(), ((RelationContext)_localctx).j.ast.location().getEndColumn()), AstBinExpr.Oper.LEQ, ((RelationContext)_localctx).i.ast, ((RelationContext)_localctx).j.ast); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(211);
				((RelationContext)_localctx).i = additive();
				setState(212);
				match(GE);
				setState(213);
				((RelationContext)_localctx).j = relation();
				 ((RelationContext)_localctx).ast =  new AstBinExpr(new Location(((RelationContext)_localctx).i.ast.location().getStartLine(), ((RelationContext)_localctx).i.ast.location().getStartColumn(), ((RelationContext)_localctx).j.ast.location().getEndLine(), ((RelationContext)_localctx).j.ast.location().getEndColumn()), AstBinExpr.Oper.GEQ, ((RelationContext)_localctx).i.ast, ((RelationContext)_localctx).j.ast); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AdditiveContext extends ParserRuleContext {
		public AstExpr ast;
		public MultiplicativeContext multiplicative;
		public Add_secContext add_sec;
		public MultiplicativeContext multiplicative() {
			return getRuleContext(MultiplicativeContext.class,0);
		}
		public Add_secContext add_sec() {
			return getRuleContext(Add_secContext.class,0);
		}
		public AdditiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additive; }
	}

	public final AdditiveContext additive() throws RecognitionException {
		AdditiveContext _localctx = new AdditiveContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_additive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			((AdditiveContext)_localctx).multiplicative = multiplicative();
			setState(219);
			((AdditiveContext)_localctx).add_sec = add_sec(((AdditiveContext)_localctx).multiplicative.ast);
			((AdditiveContext)_localctx).ast =  ((AdditiveContext)_localctx).add_sec.ast;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Add_secContext extends ParserRuleContext {
		public AstExpr missing_ast;
		public AstExpr ast;
		public MultiplicativeContext multiplicative;
		public Add_secContext add_sec;
		public TerminalNode ADD() { return getToken(PinsParser.ADD, 0); }
		public MultiplicativeContext multiplicative() {
			return getRuleContext(MultiplicativeContext.class,0);
		}
		public Add_secContext add_sec() {
			return getRuleContext(Add_secContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(PinsParser.MINUS, 0); }
		public Add_secContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Add_secContext(ParserRuleContext parent, int invokingState, AstExpr missing_ast) {
			super(parent, invokingState);
			this.missing_ast = missing_ast;
		}
		@Override public int getRuleIndex() { return RULE_add_sec; }
	}

	public final Add_secContext add_sec(AstExpr missing_ast) throws RecognitionException {
		Add_secContext _localctx = new Add_secContext(_ctx, getState(), missing_ast);
		enterRule(_localctx, 24, RULE_add_sec);
		try {
			setState(233);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				match(ADD);
				setState(223);
				((Add_secContext)_localctx).multiplicative = multiplicative();
				setState(224);
				((Add_secContext)_localctx).add_sec = add_sec(new AstBinExpr(new Location(_localctx.missing_ast.location(), ((Add_secContext)_localctx).multiplicative.ast.location()), AstBinExpr.Oper.ADD, _localctx.missing_ast, ((Add_secContext)_localctx).multiplicative.ast));
				 ((Add_secContext)_localctx).ast =  ((Add_secContext)_localctx).add_sec.ast; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(227);
				match(MINUS);
				setState(228);
				((Add_secContext)_localctx).multiplicative = multiplicative();
				setState(229);
				((Add_secContext)_localctx).add_sec = add_sec(new AstBinExpr(new Location(_localctx.missing_ast.location(), ((Add_secContext)_localctx).multiplicative.ast.location()), AstBinExpr.Oper.SUB, _localctx.missing_ast, ((Add_secContext)_localctx).multiplicative.ast));
				 ((Add_secContext)_localctx).ast =  ((Add_secContext)_localctx).add_sec.ast; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				 ((Add_secContext)_localctx).ast =  _localctx.missing_ast; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplicativeContext extends ParserRuleContext {
		public AstExpr ast;
		public PrefixContext prefix;
		public PrefixContext i;
		public MultiplicativeContext j;
		public PrefixContext prefix() {
			return getRuleContext(PrefixContext.class,0);
		}
		public TerminalNode MUL() { return getToken(PinsParser.MUL, 0); }
		public MultiplicativeContext multiplicative() {
			return getRuleContext(MultiplicativeContext.class,0);
		}
		public TerminalNode DIVIDE() { return getToken(PinsParser.DIVIDE, 0); }
		public TerminalNode MOD() { return getToken(PinsParser.MOD, 0); }
		public MultiplicativeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicative; }
	}

	public final MultiplicativeContext multiplicative() throws RecognitionException {
		MultiplicativeContext _localctx = new MultiplicativeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_multiplicative);
		try {
			setState(253);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(235);
				((MultiplicativeContext)_localctx).prefix = prefix();
				 ((MultiplicativeContext)_localctx).ast =  ((MultiplicativeContext)_localctx).prefix.ast; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(238);
				((MultiplicativeContext)_localctx).i = prefix();
				setState(239);
				match(MUL);
				setState(240);
				((MultiplicativeContext)_localctx).j = multiplicative();
				 ((MultiplicativeContext)_localctx).ast =  new AstBinExpr(new Location(((MultiplicativeContext)_localctx).i.ast.location().getStartLine(), ((MultiplicativeContext)_localctx).i.ast.location().getStartColumn(), ((MultiplicativeContext)_localctx).j.ast.location().getEndLine(), ((MultiplicativeContext)_localctx).j.ast.location().getEndColumn()), AstBinExpr.Oper.MUL, ((MultiplicativeContext)_localctx).i.ast, ((MultiplicativeContext)_localctx).j.ast); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(243);
				((MultiplicativeContext)_localctx).i = prefix();
				setState(244);
				match(DIVIDE);
				setState(245);
				((MultiplicativeContext)_localctx).j = multiplicative();
				 ((MultiplicativeContext)_localctx).ast =  new AstBinExpr(new Location(((MultiplicativeContext)_localctx).i.ast.location().getStartLine(), ((MultiplicativeContext)_localctx).i.ast.location().getStartColumn(), ((MultiplicativeContext)_localctx).j.ast.location().getEndLine(), ((MultiplicativeContext)_localctx).j.ast.location().getEndColumn()), AstBinExpr.Oper.DIV, ((MultiplicativeContext)_localctx).i.ast, ((MultiplicativeContext)_localctx).j.ast); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(248);
				((MultiplicativeContext)_localctx).i = prefix();
				setState(249);
				match(MOD);
				setState(250);
				((MultiplicativeContext)_localctx).j = multiplicative();
				 ((MultiplicativeContext)_localctx).ast =  new AstBinExpr(new Location(((MultiplicativeContext)_localctx).i.ast.location().getStartLine(), ((MultiplicativeContext)_localctx).i.ast.location().getStartColumn(), ((MultiplicativeContext)_localctx).j.ast.location().getEndLine(), ((MultiplicativeContext)_localctx).j.ast.location().getEndColumn()), AstBinExpr.Oper.MOD, ((MultiplicativeContext)_localctx).i.ast, ((MultiplicativeContext)_localctx).j.ast); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrefixContext extends ParserRuleContext {
		public AstExpr ast;
		public PostfixContext postfix;
		public Token i;
		public ExprContext k;
		public PrefixContext j;
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public TerminalNode NEW() { return getToken(PinsParser.NEW, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DEL() { return getToken(PinsParser.DEL, 0); }
		public TerminalNode ADD() { return getToken(PinsParser.ADD, 0); }
		public PrefixContext prefix() {
			return getRuleContext(PrefixContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(PinsParser.MINUS, 0); }
		public TerminalNode NEG() { return getToken(PinsParser.NEG, 0); }
		public TerminalNode CARET() { return getToken(PinsParser.CARET, 0); }
		public PrefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefix; }
	}

	public final PrefixContext prefix() throws RecognitionException {
		PrefixContext _localctx = new PrefixContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_prefix);
		try {
			setState(282);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NONE:
			case NULL:
			case INTEGER:
			case CHARCONST:
			case ID:
			case LP:
				enterOuterAlt(_localctx, 1);
				{
				setState(255);
				((PrefixContext)_localctx).postfix = postfix();
				 ((PrefixContext)_localctx).ast =  ((PrefixContext)_localctx).postfix.ast; 
				}
				break;
			case NEW:
				enterOuterAlt(_localctx, 2);
				{
				setState(258);
				((PrefixContext)_localctx).i = match(NEW);
				setState(259);
				((PrefixContext)_localctx).k = expr();
				 ((PrefixContext)_localctx).ast =  new AstPfxExpr(new Location(((PrefixContext)_localctx).i.getLine(),((PrefixContext)_localctx).i.getCharPositionInLine(), ((PrefixContext)_localctx).k.ast.location().getEndLine(), ((PrefixContext)_localctx).k.ast.location().getEndColumn()), AstPfxExpr.Oper.NEW, ((PrefixContext)_localctx).k.ast); 
				}
				break;
			case DEL:
				enterOuterAlt(_localctx, 3);
				{
				setState(262);
				((PrefixContext)_localctx).i = match(DEL);
				setState(263);
				((PrefixContext)_localctx).k = expr();
				 ((PrefixContext)_localctx).ast =  new AstPfxExpr(new Location(((PrefixContext)_localctx).i.getLine(),((PrefixContext)_localctx).i.getCharPositionInLine(), ((PrefixContext)_localctx).k.ast.location().getEndLine(), ((PrefixContext)_localctx).k.ast.location().getEndColumn()), AstPfxExpr.Oper.DEL, ((PrefixContext)_localctx).k.ast); 
				}
				break;
			case ADD:
				enterOuterAlt(_localctx, 4);
				{
				setState(266);
				((PrefixContext)_localctx).i = match(ADD);
				setState(267);
				((PrefixContext)_localctx).j = prefix();
				 ((PrefixContext)_localctx).ast =  new AstPfxExpr(new Location(((PrefixContext)_localctx).i.getLine(),((PrefixContext)_localctx).i.getCharPositionInLine(), ((PrefixContext)_localctx).j.ast.location().getEndLine(), ((PrefixContext)_localctx).j.ast.location().getEndColumn()), AstPfxExpr.Oper.ADD, ((PrefixContext)_localctx).j.ast); 
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 5);
				{
				setState(270);
				((PrefixContext)_localctx).i = match(MINUS);
				setState(271);
				((PrefixContext)_localctx).j = prefix();
				 ((PrefixContext)_localctx).ast =  new AstPfxExpr(new Location(((PrefixContext)_localctx).i.getLine(),((PrefixContext)_localctx).i.getCharPositionInLine(), ((PrefixContext)_localctx).j.ast.location().getEndLine(), ((PrefixContext)_localctx).j.ast.location().getEndColumn()), AstPfxExpr.Oper.SUB, ((PrefixContext)_localctx).j.ast); 
				}
				break;
			case NEG:
				enterOuterAlt(_localctx, 6);
				{
				setState(274);
				((PrefixContext)_localctx).i = match(NEG);
				setState(275);
				((PrefixContext)_localctx).j = prefix();
				 ((PrefixContext)_localctx).ast =  new AstPfxExpr(new Location(((PrefixContext)_localctx).i.getLine(),((PrefixContext)_localctx).i.getCharPositionInLine(), ((PrefixContext)_localctx).j.ast.location().getEndLine(), ((PrefixContext)_localctx).j.ast.location().getEndColumn()), AstPfxExpr.Oper.NOT, ((PrefixContext)_localctx).j.ast); 
				}
				break;
			case CARET:
				enterOuterAlt(_localctx, 7);
				{
				setState(278);
				((PrefixContext)_localctx).i = match(CARET);
				setState(279);
				((PrefixContext)_localctx).j = prefix();
				 ((PrefixContext)_localctx).ast =  new AstPfxExpr(new Location(((PrefixContext)_localctx).i.getLine(),((PrefixContext)_localctx).i.getCharPositionInLine(), ((PrefixContext)_localctx).j.ast.location().getEndLine(), ((PrefixContext)_localctx).j.ast.location().getEndColumn()), AstPfxExpr.Oper.PTR, ((PrefixContext)_localctx).j.ast); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostfixContext extends ParserRuleContext {
		public AstExpr ast;
		public VariableContext variable;
		public Postfix_secContext postfix_sec;
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public Postfix_secContext postfix_sec() {
			return getRuleContext(Postfix_secContext.class,0);
		}
		public PostfixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix; }
	}

	public final PostfixContext postfix() throws RecognitionException {
		PostfixContext _localctx = new PostfixContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_postfix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			((PostfixContext)_localctx).variable = variable();
			setState(285);
			((PostfixContext)_localctx).postfix_sec = postfix_sec(((PostfixContext)_localctx).variable.ast);
			 ((PostfixContext)_localctx).ast =  ((PostfixContext)_localctx).postfix_sec.ast; 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Postfix_secContext extends ParserRuleContext {
		public AstExpr missing_ast;
		public AstExpr ast;
		public ExprContext expr;
		public Token t;
		public Postfix_secContext postfix_sec;
		public Token i;
		public TerminalNode LB() { return getToken(PinsParser.LB, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Postfix_secContext postfix_sec() {
			return getRuleContext(Postfix_secContext.class,0);
		}
		public TerminalNode RB() { return getToken(PinsParser.RB, 0); }
		public TerminalNode CARET() { return getToken(PinsParser.CARET, 0); }
		public Postfix_secContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Postfix_secContext(ParserRuleContext parent, int invokingState, AstExpr missing_ast) {
			super(parent, invokingState);
			this.missing_ast = missing_ast;
		}
		@Override public int getRuleIndex() { return RULE_postfix_sec; }
	}

	public final Postfix_secContext postfix_sec(AstExpr missing_ast) throws RecognitionException {
		Postfix_secContext _localctx = new Postfix_secContext(_ctx, getState(), missing_ast);
		enterRule(_localctx, 32, RULE_postfix_sec);
		try {
			setState(299);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LB:
				enterOuterAlt(_localctx, 1);
				{
				setState(288);
				match(LB);
				setState(289);
				((Postfix_secContext)_localctx).expr = expr();
				setState(290);
				((Postfix_secContext)_localctx).t = match(RB);
				setState(291);
				((Postfix_secContext)_localctx).postfix_sec = postfix_sec(new AstArrExpr(new Location(_localctx.missing_ast.location(), (LexAn.PrevToken)((Postfix_secContext)_localctx).t), _localctx.missing_ast, ((Postfix_secContext)_localctx).expr.ast));
				 ((Postfix_secContext)_localctx).ast =  ((Postfix_secContext)_localctx).postfix_sec.ast; 
				}
				break;
			case CARET:
				enterOuterAlt(_localctx, 2);
				{
				setState(294);
				((Postfix_secContext)_localctx).i = match(CARET);
				setState(295);
				((Postfix_secContext)_localctx).postfix_sec = postfix_sec(new AstSfxExpr(new Location(_localctx.missing_ast.location(), (LexAn.PrevToken)((Postfix_secContext)_localctx).i),  AstSfxExpr.Oper.PTR, _localctx.missing_ast));
				 ((Postfix_secContext)_localctx).ast =  ((Postfix_secContext)_localctx).postfix_sec.ast; 
				}
				break;
			case DO:
			case THEN:
			case WHERE:
			case RP:
			case RB:
			case COMMA:
			case COLON:
			case SEMICOLON:
			case AND:
			case OR:
			case EQ:
			case NEQ:
			case LT:
			case GT:
			case LE:
			case GE:
			case MUL:
			case DIVIDE:
			case MOD:
			case ADD:
			case MINUS:
			case ASSIGN:
				enterOuterAlt(_localctx, 3);
				{
				 ((Postfix_secContext)_localctx).ast =  _localctx.missing_ast; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public AstExpr ast;
		public Token i;
		public FunctionContext function;
		public EnclosedContext enclosed;
		public TerminalNode ID() { return getToken(PinsParser.ID, 0); }
		public TerminalNode NONE() { return getToken(PinsParser.NONE, 0); }
		public TerminalNode INTEGER() { return getToken(PinsParser.INTEGER, 0); }
		public TerminalNode CHARCONST() { return getToken(PinsParser.CHARCONST, 0); }
		public TerminalNode NULL() { return getToken(PinsParser.NULL, 0); }
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public EnclosedContext enclosed() {
			return getRuleContext(EnclosedContext.class,0);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_variable);
		try {
			setState(317);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(301);
				((VariableContext)_localctx).i = match(ID);
				 ((VariableContext)_localctx).ast =  new AstNameExpr(new Location(((VariableContext)_localctx).i.getLine(),((VariableContext)_localctx).i.getCharPositionInLine(),((VariableContext)_localctx).i.getLine(),((VariableContext)_localctx).i.getCharPositionInLine()+(((VariableContext)_localctx).i!=null?((VariableContext)_localctx).i.getText():null).length() - 1), (((VariableContext)_localctx).i!=null?((VariableContext)_localctx).i.getText():null) );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(303);
				((VariableContext)_localctx).i = match(NONE);
				 ((VariableContext)_localctx).ast =  new AstAtomExpr(new Location(((VariableContext)_localctx).i.getLine(),((VariableContext)_localctx).i.getCharPositionInLine(),((VariableContext)_localctx).i.getLine(),((VariableContext)_localctx).i.getCharPositionInLine()+(((VariableContext)_localctx).i!=null?((VariableContext)_localctx).i.getText():null).length() - 1), AstAtomExpr.Type.VOID, (((VariableContext)_localctx).i!=null?((VariableContext)_localctx).i.getText():null) );
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(305);
				((VariableContext)_localctx).i = match(INTEGER);
				 ((VariableContext)_localctx).ast =  new AstAtomExpr(new Location(((VariableContext)_localctx).i.getLine(),((VariableContext)_localctx).i.getCharPositionInLine(),((VariableContext)_localctx).i.getLine(),((VariableContext)_localctx).i.getCharPositionInLine()+(((VariableContext)_localctx).i!=null?((VariableContext)_localctx).i.getText():null).length() - 1), AstAtomExpr.Type.INT, (((VariableContext)_localctx).i!=null?((VariableContext)_localctx).i.getText():null) );
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(307);
				((VariableContext)_localctx).i = match(CHARCONST);
				 ((VariableContext)_localctx).ast =  new AstAtomExpr(new Location(((VariableContext)_localctx).i.getLine(),((VariableContext)_localctx).i.getCharPositionInLine(),((VariableContext)_localctx).i.getLine(),((VariableContext)_localctx).i.getCharPositionInLine()+(((VariableContext)_localctx).i!=null?((VariableContext)_localctx).i.getText():null).length() - 1), AstAtomExpr.Type.CHAR, (((VariableContext)_localctx).i!=null?((VariableContext)_localctx).i.getText():null) );
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(309);
				((VariableContext)_localctx).i = match(NULL);
				 ((VariableContext)_localctx).ast =  new AstAtomExpr(new Location(((VariableContext)_localctx).i.getLine(),((VariableContext)_localctx).i.getCharPositionInLine(),((VariableContext)_localctx).i.getLine(),((VariableContext)_localctx).i.getCharPositionInLine()+(((VariableContext)_localctx).i!=null?((VariableContext)_localctx).i.getText():null).length() - 1), AstAtomExpr.Type.POINTER, (((VariableContext)_localctx).i!=null?((VariableContext)_localctx).i.getText():null) );
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(311);
				((VariableContext)_localctx).function = function();
				 ((VariableContext)_localctx).ast =  ((VariableContext)_localctx).function.ast; 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(314);
				((VariableContext)_localctx).enclosed = enclosed();
				 ((VariableContext)_localctx).ast =  ((VariableContext)_localctx).enclosed.ast; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public AstExpr ast;
		public Token i;
		public Token j;
		public ExprContext expr;
		public TerminalNode LP() { return getToken(PinsParser.LP, 0); }
		public TerminalNode ID() { return getToken(PinsParser.ID, 0); }
		public TerminalNode RP() { return getToken(PinsParser.RP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PinsParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PinsParser.COMMA, i);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_function);
		int _la;
		try {
			setState(345);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				 Vector vector = new Vector(); 
				setState(320);
				((FunctionContext)_localctx).i = match(ID);
				setState(321);
				match(LP);
				setState(322);
				((FunctionContext)_localctx).j = match(RP);
				 AstTrees<AstExpr> args = new AstTrees(vector); 
				 ((FunctionContext)_localctx).ast =  new AstCallExpr(new Location(((FunctionContext)_localctx).i.getLine(),((FunctionContext)_localctx).i.getCharPositionInLine(),((FunctionContext)_localctx).j.getLine(),((FunctionContext)_localctx).j.getCharPositionInLine()+(((FunctionContext)_localctx).j!=null?((FunctionContext)_localctx).j.getText():null).length() - 1), (((FunctionContext)_localctx).i!=null?((FunctionContext)_localctx).i.getText():null), args); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				 Vector vector = new Vector(); 
				setState(326);
				((FunctionContext)_localctx).i = match(ID);
				setState(327);
				match(LP);
				{
				setState(328);
				((FunctionContext)_localctx).expr = expr();
				 vector.add(((FunctionContext)_localctx).expr.ast); 
				}
				setState(338);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					{
					setState(331);
					match(COMMA);
					setState(332);
					((FunctionContext)_localctx).expr = expr();
					}
					 vector.add(((FunctionContext)_localctx).expr.ast); 
					}
					}
					setState(340);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(341);
				((FunctionContext)_localctx).j = match(RP);
				 AstTrees<AstExpr> args = new AstTrees(vector); 
				 ((FunctionContext)_localctx).ast =  new AstCallExpr(new Location(((FunctionContext)_localctx).i.getLine(),((FunctionContext)_localctx).i.getCharPositionInLine(),((FunctionContext)_localctx).j.getLine(),((FunctionContext)_localctx).j.getCharPositionInLine()+(((FunctionContext)_localctx).j!=null?((FunctionContext)_localctx).j.getText():null).length() - 1), (((FunctionContext)_localctx).i!=null?((FunctionContext)_localctx).i.getText():null), args); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnclosedContext extends ParserRuleContext {
		public AstExpr ast;
		public Token i;
		public ExprContext expr;
		public Token j;
		public TypeContext type;
		public SourceContext source;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LP() { return getToken(PinsParser.LP, 0); }
		public TerminalNode RP() { return getToken(PinsParser.RP, 0); }
		public TerminalNode COLON() { return getToken(PinsParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(PinsParser.WHERE, 0); }
		public SourceContext source() {
			return getRuleContext(SourceContext.class,0);
		}
		public EnclosedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enclosed; }
	}

	public final EnclosedContext enclosed() throws RecognitionException {
		EnclosedContext _localctx = new EnclosedContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_enclosed);
		try {
			setState(367);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(347);
				((EnclosedContext)_localctx).i = match(LP);
				setState(348);
				((EnclosedContext)_localctx).expr = expr();
				setState(349);
				((EnclosedContext)_localctx).j = match(RP);
				 ((EnclosedContext)_localctx).expr.ast.relocate(new Location(new Location(((EnclosedContext)_localctx).i.getLine(), ((EnclosedContext)_localctx).i.getCharPositionInLine(), ((EnclosedContext)_localctx).j.getLine(),((EnclosedContext)_localctx).j.getCharPositionInLine()+(((EnclosedContext)_localctx).j!=null?((EnclosedContext)_localctx).j.getText():null).length() - 1))); 
				 ((EnclosedContext)_localctx).ast =  ((EnclosedContext)_localctx).expr.ast; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(353);
				((EnclosedContext)_localctx).i = match(LP);
				setState(354);
				((EnclosedContext)_localctx).expr = expr();
				setState(355);
				match(COLON);
				setState(356);
				((EnclosedContext)_localctx).type = type();
				setState(357);
				((EnclosedContext)_localctx).j = match(RP);
				 ((EnclosedContext)_localctx).ast =  new AstCastExpr(new Location(((EnclosedContext)_localctx).i.getLine(),((EnclosedContext)_localctx).i.getCharPositionInLine(),((EnclosedContext)_localctx).j.getLine(),((EnclosedContext)_localctx).j.getCharPositionInLine()+(((EnclosedContext)_localctx).j!=null?((EnclosedContext)_localctx).j.getText():null).length() - 1), ((EnclosedContext)_localctx).expr.ast, ((EnclosedContext)_localctx).type.ast); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(360);
				((EnclosedContext)_localctx).i = match(LP);
				setState(361);
				((EnclosedContext)_localctx).expr = expr();
				setState(362);
				match(WHERE);
				setState(363);
				((EnclosedContext)_localctx).source = source();
				setState(364);
				((EnclosedContext)_localctx).j = match(RP);
				 ((EnclosedContext)_localctx).ast =  new AstWhereExpr(new Location(((EnclosedContext)_localctx).i.getLine(),((EnclosedContext)_localctx).i.getCharPositionInLine(),((EnclosedContext)_localctx).j.getLine(),((EnclosedContext)_localctx).j.getCharPositionInLine()+(((EnclosedContext)_localctx).j!=null?((EnclosedContext)_localctx).j.getText():null).length() - 1), ((EnclosedContext)_localctx).expr.ast, ((EnclosedContext)_localctx).source.ast); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public AstStmt ast;
		public ExpressionContext expression;
		public LoopContext loop;
		public ConditionalContext conditional;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public ConditionalContext conditional() {
			return getRuleContext(ConditionalContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_stmt);
		try {
			setState(378);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DEL:
			case NEW:
			case NONE:
			case NULL:
			case INTEGER:
			case CHARCONST:
			case ID:
			case LP:
			case LBR:
			case NEG:
			case ADD:
			case MINUS:
			case CARET:
				enterOuterAlt(_localctx, 1);
				{
				setState(369);
				((StmtContext)_localctx).expression = expression();
				 ((StmtContext)_localctx).ast =  ((StmtContext)_localctx).expression.ast; 
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(372);
				((StmtContext)_localctx).loop = loop();
				 ((StmtContext)_localctx).ast =  ((StmtContext)_localctx).loop.ast; 
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(375);
				((StmtContext)_localctx).conditional = conditional();
				 ((StmtContext)_localctx).ast =  ((StmtContext)_localctx).conditional.ast; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public AstStmt ast;
		public ExprContext expr;
		public Token j;
		public ExprContext i;
		public ExprContext k;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(PinsParser.SEMICOLON, 0); }
		public TerminalNode ASSIGN() { return getToken(PinsParser.ASSIGN, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_expression);
		try {
			setState(390);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(380);
				((ExpressionContext)_localctx).expr = expr();
				setState(381);
				((ExpressionContext)_localctx).j = match(SEMICOLON);
				 ((ExpressionContext)_localctx).ast =  new AstExprStmt(new Location(((ExpressionContext)_localctx).expr.ast.location().getStartLine(), ((ExpressionContext)_localctx).expr.ast.location().getStartColumn(),((ExpressionContext)_localctx).j.getLine(), ((ExpressionContext)_localctx).j.getCharPositionInLine()+(((ExpressionContext)_localctx).j!=null?((ExpressionContext)_localctx).j.getText():null).length() - 1), ((ExpressionContext)_localctx).expr.ast); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(384);
				((ExpressionContext)_localctx).i = expr();
				setState(385);
				match(ASSIGN);
				setState(386);
				((ExpressionContext)_localctx).k = expr();
				setState(387);
				((ExpressionContext)_localctx).j = match(SEMICOLON);
				 ((ExpressionContext)_localctx).ast =  new AstAssignStmt(new Location(((ExpressionContext)_localctx).i.ast.location().getStartLine(), ((ExpressionContext)_localctx).i.ast.location().getStartColumn(), ((ExpressionContext)_localctx).j.getLine(), ((ExpressionContext)_localctx).j.getCharPositionInLine()+(((ExpressionContext)_localctx).j!=null?((ExpressionContext)_localctx).j.getText():null).length() - 1), ((ExpressionContext)_localctx).i.ast, ((ExpressionContext)_localctx).k.ast); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoopContext extends ParserRuleContext {
		public AstStmt ast;
		public Token i;
		public ExprContext expr;
		public StmtContext stmt;
		public Token j;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DO() { return getToken(PinsParser.DO, 0); }
		public TerminalNode END() { return getToken(PinsParser.END, 0); }
		public TerminalNode WHILE() { return getToken(PinsParser.WHILE, 0); }
		public TerminalNode SEMICOLON() { return getToken(PinsParser.SEMICOLON, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_loop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 Vector vector = new Vector(); 
			setState(393);
			((LoopContext)_localctx).i = match(WHILE);
			setState(394);
			((LoopContext)_localctx).expr = expr();
			setState(395);
			match(DO);
			setState(399); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(396);
				((LoopContext)_localctx).stmt = stmt();
				 vector.add(((LoopContext)_localctx).stmt.ast); 
				}
				}
				setState(401); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEL) | (1L << IF) | (1L << NEW) | (1L << WHILE) | (1L << NONE) | (1L << NULL) | (1L << INTEGER) | (1L << CHARCONST) | (1L << ID) | (1L << LP) | (1L << LBR) | (1L << NEG) | (1L << ADD) | (1L << MINUS) | (1L << CARET))) != 0) );
			setState(403);
			match(END);
			setState(404);
			((LoopContext)_localctx).j = match(SEMICOLON);
			 AstTrees<AstStmt> statements = new AstTrees(vector); 
			 ((LoopContext)_localctx).ast =  new AstWhileStmt(new Location(((LoopContext)_localctx).i.getLine(),((LoopContext)_localctx).i.getCharPositionInLine(),((LoopContext)_localctx).j.getLine(),((LoopContext)_localctx).j.getCharPositionInLine()+(((LoopContext)_localctx).j!=null?((LoopContext)_localctx).j.getText():null).length() - 1), ((LoopContext)_localctx).expr.ast, statements); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionalContext extends ParserRuleContext {
		public AstStmt ast;
		public Token i;
		public ExprContext expr;
		public StmtContext stmt;
		public Token j;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode THEN() { return getToken(PinsParser.THEN, 0); }
		public TerminalNode END() { return getToken(PinsParser.END, 0); }
		public TerminalNode IF() { return getToken(PinsParser.IF, 0); }
		public TerminalNode SEMICOLON() { return getToken(PinsParser.SEMICOLON, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(PinsParser.ELSE, 0); }
		public ConditionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional; }
	}

	public final ConditionalContext conditional() throws RecognitionException {
		ConditionalContext _localctx = new ConditionalContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_conditional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 Vector vector = new Vector(); 
			 Vector vector2 = new Vector(); 
			setState(410);
			((ConditionalContext)_localctx).i = match(IF);
			setState(411);
			((ConditionalContext)_localctx).expr = expr();
			setState(412);
			match(THEN);
			setState(416); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(413);
				((ConditionalContext)_localctx).stmt = stmt();
				 vector.add(((ConditionalContext)_localctx).stmt.ast); 
				}
				}
				setState(418); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEL) | (1L << IF) | (1L << NEW) | (1L << WHILE) | (1L << NONE) | (1L << NULL) | (1L << INTEGER) | (1L << CHARCONST) | (1L << ID) | (1L << LP) | (1L << LBR) | (1L << NEG) | (1L << ADD) | (1L << MINUS) | (1L << CARET))) != 0) );
			setState(428);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(420);
				match(ELSE);
				setState(424); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(421);
					((ConditionalContext)_localctx).stmt = stmt();
					 vector2.add(((ConditionalContext)_localctx).stmt.ast); 
					}
					}
					setState(426); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEL) | (1L << IF) | (1L << NEW) | (1L << WHILE) | (1L << NONE) | (1L << NULL) | (1L << INTEGER) | (1L << CHARCONST) | (1L << ID) | (1L << LP) | (1L << LBR) | (1L << NEG) | (1L << ADD) | (1L << MINUS) | (1L << CARET))) != 0) );
				}
			}

			setState(430);
			match(END);
			setState(431);
			((ConditionalContext)_localctx).j = match(SEMICOLON);
			 AstTrees<AstStmt> thenStatements = new AstTrees(vector); 
			 AstTrees<AstStmt> elseStatements = new AstTrees(vector2); 
			 ((ConditionalContext)_localctx).ast =  new AstIfStmt(new Location(((ConditionalContext)_localctx).i.getLine(),((ConditionalContext)_localctx).i.getCharPositionInLine(),((ConditionalContext)_localctx).j.getLine(),((ConditionalContext)_localctx).j.getCharPositionInLine()+(((ConditionalContext)_localctx).j!=null?((ConditionalContext)_localctx).j.getText():null).length() - 1), ((ConditionalContext)_localctx).expr.ast, thenStatements, elseStatements); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\64\u01b7\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\3\2\3\2\3\2\6\2\67\n\2\r\2\16\28\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\7\3V\n\3\f\3\16\3Y\13\3\5\3[\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\5\3f\n\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5t\n"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\177\n\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u008f\n\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\5\b\u0097\n\b\3\t\3\t\3\t\3\t\3\t\6\t\u009e\n\t\r\t\16\t\u009f\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00ae\n\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00b8\n\13\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00db\n\f\3\r\3\r\3\r\3\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00ec\n\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\5\17\u0100\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u011d\n\20\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u012e\n\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\5\23\u0140\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u0153\n\24\f\24\16\24\u0156\13"+
		"\24\3\24\3\24\3\24\3\24\5\24\u015c\n\24\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\5\25\u0172\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u017d"+
		"\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u0189\n\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\6\30\u0192\n\30\r\30\16\30\u0193\3"+
		"\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\6\31\u01a3"+
		"\n\31\r\31\16\31\u01a4\3\31\3\31\3\31\3\31\6\31\u01ab\n\31\r\31\16\31"+
		"\u01ac\5\31\u01af\n\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\2\2\32\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\2\2\2\u01d1\2\62\3\2\2\2"+
		"\4e\3\2\2\2\6g\3\2\2\2\bs\3\2\2\2\n~\3\2\2\2\f\u008e\3\2\2\2\16\u0096"+
		"\3\2\2\2\20\u0098\3\2\2\2\22\u00ad\3\2\2\2\24\u00b7\3\2\2\2\26\u00da\3"+
		"\2\2\2\30\u00dc\3\2\2\2\32\u00eb\3\2\2\2\34\u00ff\3\2\2\2\36\u011c\3\2"+
		"\2\2 \u011e\3\2\2\2\"\u012d\3\2\2\2$\u013f\3\2\2\2&\u015b\3\2\2\2(\u0171"+
		"\3\2\2\2*\u017c\3\2\2\2,\u0188\3\2\2\2.\u018a\3\2\2\2\60\u019a\3\2\2\2"+
		"\62\66\b\2\1\2\63\64\5\4\3\2\64\65\b\2\1\2\65\67\3\2\2\2\66\63\3\2\2\2"+
		"\678\3\2\2\28\66\3\2\2\289\3\2\2\29:\3\2\2\2:;\b\2\1\2;\3\3\2\2\2<=\7"+
		"\20\2\2=>\7\31\2\2>?\7\63\2\2?@\5\b\5\2@A\7#\2\2AB\b\3\1\2Bf\3\2\2\2C"+
		"D\7\21\2\2DE\7\31\2\2EF\7\"\2\2FG\5\b\5\2GH\7#\2\2HI\b\3\1\2If\3\2\2\2"+
		"JK\b\3\1\2KL\7\13\2\2LM\7\31\2\2MZ\7\32\2\2NO\5\6\4\2OP\b\3\1\2PW\3\2"+
		"\2\2QR\7!\2\2RS\5\6\4\2ST\b\3\1\2TV\3\2\2\2UQ\3\2\2\2VY\3\2\2\2WU\3\2"+
		"\2\2WX\3\2\2\2X[\3\2\2\2YW\3\2\2\2ZN\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\]\7"+
		"\33\2\2]^\7\"\2\2^_\5\b\5\2_`\7\63\2\2`a\5\16\b\2ab\7#\2\2bc\b\3\1\2c"+
		"d\b\3\1\2df\3\2\2\2e<\3\2\2\2eC\3\2\2\2eJ\3\2\2\2f\5\3\2\2\2gh\7\31\2"+
		"\2hi\7\"\2\2ij\5\b\5\2jk\b\4\1\2k\7\3\2\2\2lm\7\62\2\2mn\5\b\5\2no\b\5"+
		"\1\2ot\3\2\2\2pq\5\n\6\2qr\b\5\1\2rt\3\2\2\2sl\3\2\2\2sp\3\2\2\2t\t\3"+
		"\2\2\2uv\5\f\7\2vw\b\6\1\2w\177\3\2\2\2xy\7\34\2\2yz\5\16\b\2z{\7\35\2"+
		"\2{|\5\b\5\2|}\b\6\1\2}\177\3\2\2\2~u\3\2\2\2~x\3\2\2\2\177\13\3\2\2\2"+
		"\u0080\u0081\7\22\2\2\u0081\u008f\b\7\1\2\u0082\u0083\7\6\2\2\u0083\u008f"+
		"\b\7\1\2\u0084\u0085\7\r\2\2\u0085\u008f\b\7\1\2\u0086\u0087\7\31\2\2"+
		"\u0087\u008f\b\7\1\2\u0088\u0089\7\32\2\2\u0089\u008a\5\b\5\2\u008a\u008b"+
		"\7\33\2\2\u008b\u008c\b\7\1\2\u008c\u008d\b\7\1\2\u008d\u008f\3\2\2\2"+
		"\u008e\u0080\3\2\2\2\u008e\u0082\3\2\2\2\u008e\u0084\3\2\2\2\u008e\u0086"+
		"\3\2\2\2\u008e\u0088\3\2\2\2\u008f\r\3\2\2\2\u0090\u0091\5\22\n\2\u0091"+
		"\u0092\b\b\1\2\u0092\u0097\3\2\2\2\u0093\u0094\5\20\t\2\u0094\u0095\b"+
		"\b\1\2\u0095\u0097\3\2\2\2\u0096\u0090\3\2\2\2\u0096\u0093\3\2\2\2\u0097"+
		"\17\3\2\2\2\u0098\u0099\b\t\1\2\u0099\u009d\7\36\2\2\u009a\u009b\5*\26"+
		"\2\u009b\u009c\b\t\1\2\u009c\u009e\3\2\2\2\u009d\u009a\3\2\2\2\u009e\u009f"+
		"\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1"+
		"\u00a2\7\37\2\2\u00a2\u00a3\b\t\1\2\u00a3\u00a4\b\t\1\2\u00a4\21\3\2\2"+
		"\2\u00a5\u00a6\5\24\13\2\u00a6\u00a7\7%\2\2\u00a7\u00a8\5\22\n\2\u00a8"+
		"\u00a9\b\n\1\2\u00a9\u00ae\3\2\2\2\u00aa\u00ab\5\24\13\2\u00ab\u00ac\b"+
		"\n\1\2\u00ac\u00ae\3\2\2\2\u00ad\u00a5\3\2\2\2\u00ad\u00aa\3\2\2\2\u00ae"+
		"\23\3\2\2\2\u00af\u00b0\5\26\f\2\u00b0\u00b1\7$\2\2\u00b1\u00b2\5\24\13"+
		"\2\u00b2\u00b3\b\13\1\2\u00b3\u00b8\3\2\2\2\u00b4\u00b5\5\26\f\2\u00b5"+
		"\u00b6\b\13\1\2\u00b6\u00b8\3\2\2\2\u00b7\u00af\3\2\2\2\u00b7\u00b4\3"+
		"\2\2\2\u00b8\25\3\2\2\2\u00b9\u00ba\5\30\r\2\u00ba\u00bb\b\f\1\2\u00bb"+
		"\u00db\3\2\2\2\u00bc\u00bd\5\30\r\2\u00bd\u00be\7\'\2\2\u00be\u00bf\5"+
		"\26\f\2\u00bf\u00c0\b\f\1\2\u00c0\u00db\3\2\2\2\u00c1\u00c2\5\30\r\2\u00c2"+
		"\u00c3\7(\2\2\u00c3\u00c4\5\26\f\2\u00c4\u00c5\b\f\1\2\u00c5\u00db\3\2"+
		"\2\2\u00c6\u00c7\5\30\r\2\u00c7\u00c8\7)\2\2\u00c8\u00c9\5\26\f\2\u00c9"+
		"\u00ca\b\f\1\2\u00ca\u00db\3\2\2\2\u00cb\u00cc\5\30\r\2\u00cc\u00cd\7"+
		"*\2\2\u00cd\u00ce\5\26\f\2\u00ce\u00cf\b\f\1\2\u00cf\u00db\3\2\2\2\u00d0"+
		"\u00d1\5\30\r\2\u00d1\u00d2\7+\2\2\u00d2\u00d3\5\26\f\2\u00d3\u00d4\b"+
		"\f\1\2\u00d4\u00db\3\2\2\2\u00d5\u00d6\5\30\r\2\u00d6\u00d7\7,\2\2\u00d7"+
		"\u00d8\5\26\f\2\u00d8\u00d9\b\f\1\2\u00d9\u00db\3\2\2\2\u00da\u00b9\3"+
		"\2\2\2\u00da\u00bc\3\2\2\2\u00da\u00c1\3\2\2\2\u00da\u00c6\3\2\2\2\u00da"+
		"\u00cb\3\2\2\2\u00da\u00d0\3\2\2\2\u00da\u00d5\3\2\2\2\u00db\27\3\2\2"+
		"\2\u00dc\u00dd\5\34\17\2\u00dd\u00de\5\32\16\2\u00de\u00df\b\r\1\2\u00df"+
		"\31\3\2\2\2\u00e0\u00e1\7\60\2\2\u00e1\u00e2\5\34\17\2\u00e2\u00e3\5\32"+
		"\16\2\u00e3\u00e4\b\16\1\2\u00e4\u00ec\3\2\2\2\u00e5\u00e6\7\61\2\2\u00e6"+
		"\u00e7\5\34\17\2\u00e7\u00e8\5\32\16\2\u00e8\u00e9\b\16\1\2\u00e9\u00ec"+
		"\3\2\2\2\u00ea\u00ec\b\16\1\2\u00eb\u00e0\3\2\2\2\u00eb\u00e5\3\2\2\2"+
		"\u00eb\u00ea\3\2\2\2\u00ec\33\3\2\2\2\u00ed\u00ee\5\36\20\2\u00ee\u00ef"+
		"\b\17\1\2\u00ef\u0100\3\2\2\2\u00f0\u00f1\5\36\20\2\u00f1\u00f2\7-\2\2"+
		"\u00f2\u00f3\5\34\17\2\u00f3\u00f4\b\17\1\2\u00f4\u0100\3\2\2\2\u00f5"+
		"\u00f6\5\36\20\2\u00f6\u00f7\7.\2\2\u00f7\u00f8\5\34\17\2\u00f8\u00f9"+
		"\b\17\1\2\u00f9\u0100\3\2\2\2\u00fa\u00fb\5\36\20\2\u00fb\u00fc\7/\2\2"+
		"\u00fc\u00fd\5\34\17\2\u00fd\u00fe\b\17\1\2\u00fe\u0100\3\2\2\2\u00ff"+
		"\u00ed\3\2\2\2\u00ff\u00f0\3\2\2\2\u00ff\u00f5\3\2\2\2\u00ff\u00fa\3\2"+
		"\2\2\u0100\35\3\2\2\2\u0101\u0102\5 \21\2\u0102\u0103\b\20\1\2\u0103\u011d"+
		"\3\2\2\2\u0104\u0105\7\16\2\2\u0105\u0106\5\16\b\2\u0106\u0107\b\20\1"+
		"\2\u0107\u011d\3\2\2\2\u0108\u0109\7\7\2\2\u0109\u010a\5\16\b\2\u010a"+
		"\u010b\b\20\1\2\u010b\u011d\3\2\2\2\u010c\u010d\7\60\2\2\u010d\u010e\5"+
		"\36\20\2\u010e\u010f\b\20\1\2\u010f\u011d\3\2\2\2\u0110\u0111\7\61\2\2"+
		"\u0111\u0112\5\36\20\2\u0112\u0113\b\20\1\2\u0113\u011d\3\2\2\2\u0114"+
		"\u0115\7&\2\2\u0115\u0116\5\36\20\2\u0116\u0117\b\20\1\2\u0117\u011d\3"+
		"\2\2\2\u0118\u0119\7\62\2\2\u0119\u011a\5\36\20\2\u011a\u011b\b\20\1\2"+
		"\u011b\u011d\3\2\2\2\u011c\u0101\3\2\2\2\u011c\u0104\3\2\2\2\u011c\u0108"+
		"\3\2\2\2\u011c\u010c\3\2\2\2\u011c\u0110\3\2\2\2\u011c\u0114\3\2\2\2\u011c"+
		"\u0118\3\2\2\2\u011d\37\3\2\2\2\u011e\u011f\5$\23\2\u011f\u0120\5\"\22"+
		"\2\u0120\u0121\b\21\1\2\u0121!\3\2\2\2\u0122\u0123\7\34\2\2\u0123\u0124"+
		"\5\16\b\2\u0124\u0125\7\35\2\2\u0125\u0126\5\"\22\2\u0126\u0127\b\22\1"+
		"\2\u0127\u012e\3\2\2\2\u0128\u0129\7\62\2\2\u0129\u012a\5\"\22\2\u012a"+
		"\u012b\b\22\1\2\u012b\u012e\3\2\2\2\u012c\u012e\b\22\1\2\u012d\u0122\3"+
		"\2\2\2\u012d\u0128\3\2\2\2\u012d\u012c\3\2\2\2\u012e#\3\2\2\2\u012f\u0130"+
		"\7\31\2\2\u0130\u0140\b\23\1\2\u0131\u0132\7\25\2\2\u0132\u0140\b\23\1"+
		"\2\u0133\u0134\7\27\2\2\u0134\u0140\b\23\1\2\u0135\u0136\7\30\2\2\u0136"+
		"\u0140\b\23\1\2\u0137\u0138\7\26\2\2\u0138\u0140\b\23\1\2\u0139\u013a"+
		"\5&\24\2\u013a\u013b\b\23\1\2\u013b\u0140\3\2\2\2\u013c\u013d\5(\25\2"+
		"\u013d\u013e\b\23\1\2\u013e\u0140\3\2\2\2\u013f\u012f\3\2\2\2\u013f\u0131"+
		"\3\2\2\2\u013f\u0133\3\2\2\2\u013f\u0135\3\2\2\2\u013f\u0137\3\2\2\2\u013f"+
		"\u0139\3\2\2\2\u013f\u013c\3\2\2\2\u0140%\3\2\2\2\u0141\u0142\b\24\1\2"+
		"\u0142\u0143\7\31\2\2\u0143\u0144\7\32\2\2\u0144\u0145\7\33\2\2\u0145"+
		"\u0146\b\24\1\2\u0146\u015c\b\24\1\2\u0147\u0148\b\24\1\2\u0148\u0149"+
		"\7\31\2\2\u0149\u014a\7\32\2\2\u014a\u014b\5\16\b\2\u014b\u014c\b\24\1"+
		"\2\u014c\u0154\3\2\2\2\u014d\u014e\7!\2\2\u014e\u014f\5\16\b\2\u014f\u0150"+
		"\3\2\2\2\u0150\u0151\b\24\1\2\u0151\u0153\3\2\2\2\u0152\u014d\3\2\2\2"+
		"\u0153\u0156\3\2\2\2\u0154\u0152\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0157"+
		"\3\2\2\2\u0156\u0154\3\2\2\2\u0157\u0158\7\33\2\2\u0158\u0159\b\24\1\2"+
		"\u0159\u015a\b\24\1\2\u015a\u015c\3\2\2\2\u015b\u0141\3\2\2\2\u015b\u0147"+
		"\3\2\2\2\u015c\'\3\2\2\2\u015d\u015e\7\32\2\2\u015e\u015f\5\16\b\2\u015f"+
		"\u0160\7\33\2\2\u0160\u0161\b\25\1\2\u0161\u0162\b\25\1\2\u0162\u0172"+
		"\3\2\2\2\u0163\u0164\7\32\2\2\u0164\u0165\5\16\b\2\u0165\u0166\7\"\2\2"+
		"\u0166\u0167\5\b\5\2\u0167\u0168\7\33\2\2\u0168\u0169\b\25\1\2\u0169\u0172"+
		"\3\2\2\2\u016a\u016b\7\32\2\2\u016b\u016c\5\16\b\2\u016c\u016d\7\23\2"+
		"\2\u016d\u016e\5\2\2\2\u016e\u016f\7\33\2\2\u016f\u0170\b\25\1\2\u0170"+
		"\u0172\3\2\2\2\u0171\u015d\3\2\2\2\u0171\u0163\3\2\2\2\u0171\u016a\3\2"+
		"\2\2\u0172)\3\2\2\2\u0173\u0174\5,\27\2\u0174\u0175\b\26\1\2\u0175\u017d"+
		"\3\2\2\2\u0176\u0177\5.\30\2\u0177\u0178\b\26\1\2\u0178\u017d\3\2\2\2"+
		"\u0179\u017a\5\60\31\2\u017a\u017b\b\26\1\2\u017b\u017d\3\2\2\2\u017c"+
		"\u0173\3\2\2\2\u017c\u0176\3\2\2\2\u017c\u0179\3\2\2\2\u017d+\3\2\2\2"+
		"\u017e\u017f\5\16\b\2\u017f\u0180\7#\2\2\u0180\u0181\b\27\1\2\u0181\u0189"+
		"\3\2\2\2\u0182\u0183\5\16\b\2\u0183\u0184\7\63\2\2\u0184\u0185\5\16\b"+
		"\2\u0185\u0186\7#\2\2\u0186\u0187\b\27\1\2\u0187\u0189\3\2\2\2\u0188\u017e"+
		"\3\2\2\2\u0188\u0182\3\2\2\2\u0189-\3\2\2\2\u018a\u018b\b\30\1\2\u018b"+
		"\u018c\7\24\2\2\u018c\u018d\5\16\b\2\u018d\u0191\7\b\2\2\u018e\u018f\5"+
		"*\26\2\u018f\u0190\b\30\1\2\u0190\u0192\3\2\2\2\u0191\u018e\3\2\2\2\u0192"+
		"\u0193\3\2\2\2\u0193\u0191\3\2\2\2\u0193\u0194\3\2\2\2\u0194\u0195\3\2"+
		"\2\2\u0195\u0196\7\n\2\2\u0196\u0197\7#\2\2\u0197\u0198\b\30\1\2\u0198"+
		"\u0199\b\30\1\2\u0199/\3\2\2\2\u019a\u019b\b\31\1\2\u019b\u019c\b\31\1"+
		"\2\u019c\u019d\7\f\2\2\u019d\u019e\5\16\b\2\u019e\u01a2\7\17\2\2\u019f"+
		"\u01a0\5*\26\2\u01a0\u01a1\b\31\1\2\u01a1\u01a3\3\2\2\2\u01a2\u019f\3"+
		"\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5"+
		"\u01ae\3\2\2\2\u01a6\u01aa\7\t\2\2\u01a7\u01a8\5*\26\2\u01a8\u01a9\b\31"+
		"\1\2\u01a9\u01ab\3\2\2\2\u01aa\u01a7\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac"+
		"\u01aa\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01af\3\2\2\2\u01ae\u01a6\3\2"+
		"\2\2\u01ae\u01af\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b1\7\n\2\2\u01b1"+
		"\u01b2\7#\2\2\u01b2\u01b3\b\31\1\2\u01b3\u01b4\b\31\1\2\u01b4\u01b5\b"+
		"\31\1\2\u01b5\61\3\2\2\2\348WZes~\u008e\u0096\u009f\u00ad\u00b7\u00da"+
		"\u00eb\u00ff\u011c\u012d\u013f\u0154\u015b\u0171\u017c\u0188\u0193\u01a4"+
		"\u01ac\u01ae";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}