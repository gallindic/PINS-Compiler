parser grammar PinsParser;

@header {

	package pins.phase.synan;
	
	import java.util.*;
	
	import pins.common.report.*;
	import pins.phase.lexan.*;
  import pins.data.ast.tree.*;
  import pins.data.ast.tree.decl.*;
  import pins.data.ast.tree.type.*;
  import pins.data.ast.tree.expr.*;
	import pins.data.ast.tree.stmt.*;
}

@members {

}

options{
    tokenVocab=PinsLexer;
}

source
  returns [AstTrees<AstDecl> ast]
  : { Vector decls = new Vector(); }
  ( decl { decls.add($decl.ast); } )+
  { $ast = new AstTrees(decls); }
;

decl
  returns [ AstDecl ast ]
  : t=TYP ID ASSIGN type s=SEMICOLON 
    { $ast = new AstTypeDecl(new Location($t.getLine(),$t.getCharPositionInLine(),$s.getLine(),
    $s.getCharPositionInLine()+$s.text.length() - 1), $ID.text, $type.ast); }
  | v=VAR ID COLON type s=SEMICOLON
    { $ast = new AstVarDecl(new Location($v.getLine(),$v.getCharPositionInLine(),$s.getLine(),$s.getCharPositionInLine()+$s.text.length() - 1),
      $ID.text, $type.ast); }
  | { Vector vector = new Vector(); }
    f=FUN ID LP 
    ((param { vector.add($param.ast); })
    (COMMA param { vector.add($param.ast); })*)?
    RP COLON type ASSIGN expr s=SEMICOLON
    { AstTrees<AstParDecl> params = new AstTrees(vector); }
    { $ast = new AstFunDecl(new Location($f.getLine(),$f.getCharPositionInLine(),$s.getLine(),$s.getCharPositionInLine()+$s.text.length() - 1), $ID.text,
      params, $type.ast, $expr.ast); }
    ;

param
  returns [AstParDecl ast]
  : i=ID COLON j=type
    { $ast = new AstParDecl(new Location($i.getLine(), $i.getCharPositionInLine(), $j.ast.location().getEndLine(), $j.ast.location().getEndColumn()), $i.text, $j.ast); }
  ;

type
  returns [AstType ast]
  : i=CARET type
    { $ast = new AstPtrType(new Location($i.getLine(),$i.getCharPositionInLine(),$i.getLine(),$i.getCharPositionInLine()+$i.text.length() - 1), $type.ast );}
  | arr
    { $ast = $arr.ast; }
  ;

arr
  returns [AstType ast]
  : atomic
    { $ast = $atomic.ast; }
  | i=LB expr RB type
    { $ast = new AstArrType(new Location($i.getLine(), $i.getCharPositionInLine(), $type.ast.location().getEndLine(), $type.ast.location().getEndColumn()), $type.ast, $expr.ast ) ;}
  ;

atomic
  returns [AstType ast]
  : //type -> VOID
    i=VOID
    { $ast = new AstAtomType(new Location($i.getLine(),$i.getCharPositionInLine(),$i.getLine(),$i.getCharPositionInLine()+$i.text.length() - 1), AstAtomType.Type.VOID );}
  | //type -> CHAR
    i=CHAR
    { $ast = new AstAtomType(new Location($i.getLine(),$i.getCharPositionInLine(),$i.getLine(),$i.getCharPositionInLine()+$i.text.length() - 1), AstAtomType.Type.CHAR );}
  | //type -> INT
    i=INT
    { $ast = new AstAtomType(new Location($i.getLine(),$i.getCharPositionInLine(),$i.getLine(),$i.getCharPositionInLine()+$i.text.length() - 1), AstAtomType.Type.INT );}
  | //type -> ID
    i=ID
    { $ast = new AstNameType(new Location($i.getLine(),$i.getCharPositionInLine(),$i.getLine(),$i.getCharPositionInLine()+$i.text.length() - 1), $i.text );}
  | i=LP type j=RP
    { $type.ast.relocate(new Location($i.getLine(), $i.getCharPositionInLine(), $j.getLine(),$j.getCharPositionInLine()+$j.text.length() - 1));}
    { $ast = $type.ast; }
  ;

expr
  returns [AstExpr ast]
  : disjunctive
    { $ast = $disjunctive.ast; }
  | statement
    { $ast = $statement.ast; }
  ;

statement
  returns [AstExpr ast]
  : { Vector vector = new Vector(); }
    i=LBR 
    (stmt { vector.add($stmt.ast); })+
    j=RBR
    { AstTrees<AstStmt> statements = new AstTrees(vector); }
    { $ast = new AstStmtExpr(new Location($i.getLine(),$i.getCharPositionInLine(),$j.getLine(),
      $j.getCharPositionInLine()+$j.text.length() - 1), statements); }
  ;

disjunctive
  returns [AstExpr ast]
  : i=conjunctive OR j=disjunctive
    { $ast = new AstBinExpr(new Location($i.ast.location().getStartLine(), $i.ast.location().getStartColumn(), 
      $j.ast.location().getEndLine(), $j.ast.location().getEndColumn()), AstBinExpr.Oper.OR, $i.ast, $j.ast); }
  | conjunctive
    { $ast = $conjunctive.ast; }
  ;

conjunctive
  returns [AstExpr ast]
  : i=relation AND j=conjunctive
    { $ast = new AstBinExpr(new Location($i.ast.location().getStartLine(), $i.ast.location().getStartColumn(),
     $j.ast.location().getEndLine(),
     $j.ast.location().getEndColumn()), AstBinExpr.Oper.AND, $i.ast, $j.ast); }
  | relation
    { $ast = $relation.ast; }
  ;

relation
  returns [AstExpr ast]
  : additive
    { $ast = $additive.ast; }
  | i=additive EQ j=relation
    { $ast = new AstBinExpr(new Location($i.ast.location().getStartLine(), $i.ast.location().getStartColumn(), $j.ast.location().getEndLine(), $j.ast.location().getEndColumn()), AstBinExpr.Oper.EQU, $i.ast, $j.ast); }
  | i=additive NEQ j=relation
    { $ast = new AstBinExpr(new Location($i.ast.location().getStartLine(), $i.ast.location().getStartColumn(), $j.ast.location().getEndLine(), $j.ast.location().getEndColumn()), AstBinExpr.Oper.NEQ, $i.ast, $j.ast); }
  | i=additive LT j=relation
    { $ast = new AstBinExpr(new Location($i.ast.location().getStartLine(), $i.ast.location().getStartColumn(), $j.ast.location().getEndLine(), $j.ast.location().getEndColumn()), AstBinExpr.Oper.LTH, $i.ast, $j.ast); }
  | i=additive GT j=relation
    { $ast = new AstBinExpr(new Location($i.ast.location().getStartLine(), $i.ast.location().getStartColumn(), $j.ast.location().getEndLine(), $j.ast.location().getEndColumn()), AstBinExpr.Oper.GTH, $i.ast, $j.ast); }
  | i=additive LE j=relation
    { $ast = new AstBinExpr(new Location($i.ast.location().getStartLine(), $i.ast.location().getStartColumn(), $j.ast.location().getEndLine(), $j.ast.location().getEndColumn()), AstBinExpr.Oper.LEQ, $i.ast, $j.ast); }
  | i=additive GE j=relation
    { $ast = new AstBinExpr(new Location($i.ast.location().getStartLine(), $i.ast.location().getStartColumn(), $j.ast.location().getEndLine(), $j.ast.location().getEndColumn()), AstBinExpr.Oper.GEQ, $i.ast, $j.ast); }
  ;

additive
  returns [AstExpr ast]
  : multiplicative
    add_sec[$multiplicative.ast]
    {$ast = $add_sec.ast;}
;

add_sec[AstExpr missing_ast]
  returns [AstExpr ast]
  : ADD multiplicative
    add_sec[new AstBinExpr(new Location($missing_ast.location(), $multiplicative.ast.location()), AstBinExpr.Oper.ADD, $missing_ast, $multiplicative.ast)]
    { $ast = $add_sec.ast; }
  | MINUS multiplicative
    add_sec [new AstBinExpr(new Location($missing_ast.location(), $multiplicative.ast.location()), AstBinExpr.Oper.SUB, $missing_ast, $multiplicative.ast)]
    { $ast = $add_sec.ast; }
  | { $ast = $missing_ast; }
  ;

multiplicative
  returns [AstExpr ast]
  : prefix
    { $ast = $prefix.ast; }
  | i=prefix MUL j=multiplicative
    { $ast = new AstBinExpr(new Location($i.ast.location().getStartLine(), $i.ast.location().getStartColumn(), $j.ast.location().getEndLine(), $j.ast.location().getEndColumn()), AstBinExpr.Oper.MUL, $i.ast, $j.ast); }
  | i=prefix DIVIDE j=multiplicative
    { $ast = new AstBinExpr(new Location($i.ast.location().getStartLine(), $i.ast.location().getStartColumn(), $j.ast.location().getEndLine(), $j.ast.location().getEndColumn()), AstBinExpr.Oper.DIV, $i.ast, $j.ast); }
  | i=prefix MOD j=multiplicative
    { $ast = new AstBinExpr(new Location($i.ast.location().getStartLine(), $i.ast.location().getStartColumn(), $j.ast.location().getEndLine(), $j.ast.location().getEndColumn()), AstBinExpr.Oper.MOD, $i.ast, $j.ast); }
  ;
  
prefix
  returns [AstExpr ast]
  : postfix
    { $ast = $postfix.ast; }
  | i=NEW k=expr
    { $ast = new AstPfxExpr(new Location($i.getLine(),$i.getCharPositionInLine(), $k.ast.location().getEndLine(), $k.ast.location().getEndColumn()), AstPfxExpr.Oper.NEW, $k.ast); }
  | i=DEL k=expr
    { $ast = new AstPfxExpr(new Location($i.getLine(),$i.getCharPositionInLine(), $k.ast.location().getEndLine(), $k.ast.location().getEndColumn()), AstPfxExpr.Oper.DEL, $k.ast); }
  | i=ADD j=prefix
    { $ast = new AstPfxExpr(new Location($i.getLine(),$i.getCharPositionInLine(), $j.ast.location().getEndLine(), $j.ast.location().getEndColumn()), AstPfxExpr.Oper.ADD, $j.ast); }
  | i=MINUS j=prefix
    { $ast = new AstPfxExpr(new Location($i.getLine(),$i.getCharPositionInLine(), $j.ast.location().getEndLine(), $j.ast.location().getEndColumn()), AstPfxExpr.Oper.SUB, $j.ast); }
  | i=NEG j=prefix
    { $ast = new AstPfxExpr(new Location($i.getLine(),$i.getCharPositionInLine(), $j.ast.location().getEndLine(), $j.ast.location().getEndColumn()), AstPfxExpr.Oper.NOT, $j.ast); }
  | i=CARET j=prefix
    { $ast = new AstPfxExpr(new Location($i.getLine(),$i.getCharPositionInLine(), $j.ast.location().getEndLine(), $j.ast.location().getEndColumn()), AstPfxExpr.Oper.PTR, $j.ast); }
  ;

postfix
  returns [AstExpr ast]
  : variable
    postfix_sec[$variable.ast]
    { $ast = $postfix_sec.ast; }
  ;

postfix_sec[AstExpr missing_ast]
  returns[AstExpr ast]
  : LB expr t=RB postfix_sec[new AstArrExpr(new Location($missing_ast.location(), (LexAn.PrevToken)$t), $missing_ast, $expr.ast)]
    { $ast = $postfix_sec.ast; }
  | i=CARET postfix_sec[new AstSfxExpr(new Location($missing_ast.location(), (LexAn.PrevToken)$i),  AstSfxExpr.Oper.PTR, $missing_ast)]
    { $ast = $postfix_sec.ast; }
  | { $ast = $missing_ast; }
  ;
 
variable
  returns [AstExpr ast]
  : i=ID
  { $ast = new AstNameExpr(new Location($i.getLine(),$i.getCharPositionInLine(),$i.getLine(),$i.getCharPositionInLine()+$i.text.length() - 1), $i.text );}
  | i=NONE
    { $ast = new AstAtomExpr(new Location($i.getLine(),$i.getCharPositionInLine(),$i.getLine(),$i.getCharPositionInLine()+$i.text.length() - 1), AstAtomExpr.Type.VOID, $i.text );}
  | i=INTEGER
    { $ast = new AstAtomExpr(new Location($i.getLine(),$i.getCharPositionInLine(),$i.getLine(),$i.getCharPositionInLine()+$i.text.length() - 1), AstAtomExpr.Type.INT, $i.text );}
  | i=CHARCONST
    { $ast = new AstAtomExpr(new Location($i.getLine(),$i.getCharPositionInLine(),$i.getLine(),$i.getCharPositionInLine()+$i.text.length() - 1), AstAtomExpr.Type.CHAR, $i.text );}
  | i=NULL
    { $ast = new AstAtomExpr(new Location($i.getLine(),$i.getCharPositionInLine(),$i.getLine(),$i.getCharPositionInLine()+$i.text.length() - 1), AstAtomExpr.Type.POINTER, $i.text );}
  | function
    { $ast = $function.ast; }
  | enclosed
    { $ast = $enclosed.ast; }
  ;

function
  returns [AstExpr ast]
  : { Vector vector = new Vector(); }
    i=ID LP j=RP
    { AstTrees<AstExpr> args = new AstTrees(vector); }
    { $ast = new AstCallExpr(new Location($i.getLine(),$i.getCharPositionInLine(),$j.getLine(),$j.getCharPositionInLine()+$j.text.length() - 1), $i.text, args); }
  | { Vector vector = new Vector(); }
    i=ID LP 
    (expr { vector.add($expr.ast); })
    ((COMMA expr) { vector.add($expr.ast); })*
    j=RP
    { AstTrees<AstExpr> args = new AstTrees(vector); }
    { $ast = new AstCallExpr(new Location($i.getLine(),$i.getCharPositionInLine(),$j.getLine(),$j.getCharPositionInLine()+$j.text.length() - 1), $i.text, args); }
  ;

enclosed
  returns [AstExpr ast]
  : i=LP expr j=RP
    { $expr.ast.relocate(new Location(new Location($i.getLine(), $i.getCharPositionInLine(), $j.getLine(),$j.getCharPositionInLine()+$j.text.length() - 1))); }
    { $ast = $expr.ast; }
  | i=LP expr COLON type j=RP
    { $ast = new AstCastExpr(new Location($i.getLine(),$i.getCharPositionInLine(),$j.getLine(),$j.getCharPositionInLine()+$j.text.length() - 1), $expr.ast, $type.ast); }
  | i=LP expr WHERE source j=RP
    { $ast = new AstWhereExpr(new Location($i.getLine(),$i.getCharPositionInLine(),$j.getLine(),$j.getCharPositionInLine()+$j.text.length() - 1), $expr.ast, $source.ast); }
  ;

stmt
  returns [AstStmt ast]
  : expression 
    { $ast = $expression.ast; }
  | loop
    { $ast = $loop.ast; }
  | conditional
    { $ast = $conditional.ast; }
  ;

expression
  returns [AstStmt ast]
  : expr j=SEMICOLON
    { $ast = new AstExprStmt(new Location($expr.ast.location().getStartLine(), $expr.ast.location().getStartColumn(),$j.getLine(), $j.getCharPositionInLine()+$j.text.length() - 1), $expr.ast); }
  | i=expr ASSIGN k=expr j=SEMICOLON
    { $ast = new AstAssignStmt(new Location($i.ast.location().getStartLine(), $i.ast.location().getStartColumn(), $j.getLine(), $j.getCharPositionInLine()+$j.text.length() - 1), $i.ast, $k.ast); }
  ;

loop
  returns [AstStmt ast]
  : { Vector vector = new Vector(); }
    i=WHILE expr DO 
    (stmt { vector.add($stmt.ast); })+
    END j=SEMICOLON
    { AstTrees<AstStmt> statements = new AstTrees(vector); }
    { $ast = new AstWhileStmt(new Location($i.getLine(),$i.getCharPositionInLine(),$j.getLine(),$j.getCharPositionInLine()+$j.text.length() - 1), $expr.ast, statements); }
  ;

conditional
  returns [AstStmt ast]
  : { Vector vector = new Vector(); }
    { Vector vector2 = new Vector(); }
    i=IF expr THEN
    (stmt { vector.add($stmt.ast); })+
    (ELSE (stmt { vector2.add($stmt.ast); })+)?
    END j=SEMICOLON
    { AstTrees<AstStmt> thenStatements = new AstTrees(vector); }
    { AstTrees<AstStmt> elseStatements = new AstTrees(vector2); }
    { $ast = new AstIfStmt(new Location($i.getLine(),$i.getCharPositionInLine(),$j.getLine(),$j.getCharPositionInLine()+$j.text.length() - 1), $expr.ast, thenStatements, elseStatements); }
  ;