lexer grammar PinsLexer;

@header {
	package pins.phase.lexan;
	import pins.common.report.*;
}

@members {
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
}



/*	WHITESPACE	*/

WHITESPACE: [ \r\n\t]+ { if(getText().contains("\t")) setCharPositionInLine(getCharPositionInLine() + 8 - (getCharPositionInLine() % 8)); } -> skip;
LINE_COMMENT : '#' ~( '\r' | '\n' )* -> skip;
NESTED_COMMENT : '#{' (NESTED_COMMENT|.)*? '}#' {
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

} -> skip;





/*	KEYWORDS	*/

CHAR : 'char' ;
DEL : 'del' ;
DO : 'do' ;
ELSE : 'else' ;
END : 'end' ;
FUN : 'fun' ;
IF : 'if' ;
INT : 'int' ;
NEW : 'new' ;
THEN : 'then' ;
TYP : 'typ' ;
VAR : 'var' ;
VOID : 'void' ;
WHERE : 'where' ;
WHILE : 'while' ;



/*	CONSTS		*/

NONE : 'none' ;
NULL : 'nil' ;
INTEGER : [0-9]+ ;
CHARCONST : ['] (CHARCONST_USABLE) ['] ;


/*	IDENTIFIER	*/

ID : TEXT (TEXT|DIGIT)* ;




/*	SYMBOLS		*/

LP : '(' ;
RP : ')' ;
LB : '[' ;
RB : ']' ;
LBR : '{' ;
RBR : '}' ;
DOT : '.' ;
COMMA : ',' ;
COLON : ':' ;
SEMICOLON : ';' ;
AND : '&' ;
OR : '|' ;
NEG : '!' ;
EQ : '==' ;
NEQ : '!=' ;
LT : '<' ;
GT : '>';
LE : '<=' ;
GE : '>=' ;
MUL : '*' ;
DIVIDE : '/' ;
MOD : '%' ;
ADD : '+' ;
MINUS : '-';
CARET : '^' ;
ASSIGN : '=' ;



/*	ERROR	*/

ERROR : . { customError(); } ;


/*	FRAGMENNTS	*/

fragment TEXT : [a-zA-Z_] ;
fragment DIGIT : [0-9] ;
fragment ALL_USABLE_ASCII : [ -~] ;
fragment CHARCONST_USABLE : [\u0020-\u0026\u0028-\u005B\u005D-\u007E]|('\\\\')|('\\\'');
