package pins.phase.seman;

import pins.data.semtype.*;
import pins.common.report.*;
import pins.data.ast.tree.*;
import pins.data.ast.tree.decl.*;
import pins.data.ast.tree.expr.*;
import pins.data.ast.tree.expr.AstBinExpr.Oper;
import pins.data.ast.tree.stmt.*;
import pins.data.ast.tree.type.*;
import pins.data.ast.visitor.*;

/**
 * Type resolver.
 * 
 * Type resolver computes the values of {@link SemAn#declaresType},
 * {@link SemAn#isType}, and {@link SemAn#ofType}.
 */
public class TypeResolver extends AstFullVisitor<SemType, TypeResolver.Mode> {

	public enum Mode {
		HEAD, BODY
	}

	// GENERAL PURPOSE

	@Override
	public SemType visit(AstTrees<?> trees, Mode mode) {
		for (AstTree tree : trees)
			if (tree instanceof AstTypeDecl)
				tree.accept(this, Mode.HEAD);
		for (AstTree tree : trees)
			if (tree instanceof AstTypeDecl)
				tree.accept(this, Mode.BODY);
		for (AstTree tree : trees)
			if (tree instanceof AstVarDecl)
				tree.accept(this, mode);
		for (AstTree tree : trees)
			if (tree instanceof AstFunDecl)
				tree.accept(this, Mode.HEAD);
		for (AstTree tree : trees)
			if (tree instanceof AstFunDecl)
				tree.accept(this, Mode.BODY);
		return null;
	}

	// DECLERATIONS

	public SemType visit(AstTypeDecl typeDecl, Mode mode){
		if(mode.equals(Mode.HEAD)){
			SemAn.declaresType.put(typeDecl, new SemName(typeDecl.name()));
		}
		else if(mode.equals(Mode.BODY)){
			typeDecl.type().accept(this, mode);
			SemAn.declaresType.get(typeDecl).define(SemAn.isType.get(typeDecl.type()));
		}

		return null;
	}

	public SemType visit(AstFunDecl funDecl, Mode mode){
		if(mode.equals(Mode.HEAD)){
			funDecl.type().accept(this, mode);

			for(AstParDecl param : funDecl.pars()){
				param.accept(this, mode);
			}

			SemType funType = SemAn.isType.get(funDecl.type());

			SemAn.isType.put(funDecl.type(), funType);
		}
		else if(mode.equals(Mode.BODY)){
			funDecl.expr().accept(this, mode);

			SemType resultType = SemAn.ofType.get(funDecl.expr());
			SemType funType = SemAn.isType.get(funDecl.type());

			if(resultType instanceof SemInteger || resultType instanceof SemChar || resultType instanceof SemVoid || resultType instanceof SemPointer &&
			funType instanceof SemInteger || funType instanceof SemChar || funType instanceof SemVoid || funType instanceof SemPointer){
				if(!(resultType.getClass().equals(funType.getClass()))){
					throw new Report.Error(funDecl, "Type of function and result do not match!");
				}
			}
			else{
				throw new Report.Error(funDecl, "Function type and result must be of type int, char, void or pointer!");
			}
		}

		return null;
	}

	public SemType visit(AstVarDecl varDecl, Mode mode){
		varDecl.type().accept(this, Mode.BODY);

		return null;
	}

	public SemType visit(AstParDecl parDecl, Mode mode){
		parDecl.type().accept(this, mode);

		SemType type = SemAn.isType.get(parDecl.type());

		if(type instanceof SemInteger || type instanceof SemChar || type instanceof SemPointer){
			SemName sn = new SemName(parDecl.name());

			return sn;
		}
		else{
			throw new Report.Error(parDecl, "Function parameters must be of type int, char or pointer!");
		}
	}


	// TYPE

	public SemType visit(AstPtrType ptrType, Mode mode){
		SemPointer sp = new SemPointer(ptrType.baseType().accept(this, mode));
		SemAn.isType.put(ptrType, sp);
		
		return sp;
	}

	public SemType visit(AstArrType arrType, Mode mode){
		if(!(arrType.numElems() instanceof AstAtomExpr)){
			throw new Report.Error(arrType, "Wrong use of array!");
		}
		else if(((AstAtomExpr)arrType.numElems()).type() != AstAtomExpr.Type.INT){
			throw new Report.Error(arrType, "Wrong use of array!");
		}

		long numElems = Long.parseLong(((AstAtomExpr) arrType.numElems()).value());

		if(numElems < 1){
			throw new Report.Error(arrType, "Must be greater than 0!");
		}

		SemArray sa = new SemArray(arrType.elemType().accept(this, mode), numElems);
		SemAn.isType.put(arrType, sa);

		arrType.numElems().accept(this, mode);

		return sa;
	}

	public SemType visit(AstNameType nameType, Mode mode){
		if(SemAn.declaredAt.get(nameType) instanceof AstTypeDecl){
			SemType s = SemAn.declaresType.get((AstTypeDecl) SemAn.declaredAt.get(nameType));
			SemAn.isType.put(nameType, ((SemName)s).actualType());
		}
		else if(SemAn.declaredAt.get(nameType) instanceof AstVarDecl){
			SemAn.isType.put(nameType, SemAn.isType.get(((AstVarDecl) SemAn.declaredAt.get(nameType)).type()));
		}
		else if(SemAn.declaredAt.get(nameType) instanceof AstParDecl){
			SemAn.isType.put(nameType, SemAn.isType.get(((AstParDecl) SemAn.declaredAt.get(nameType)).type()));
		}
		
		return null;
	}

	public SemType visit(AstAtomType atomType, Mode mode){
		if(atomType.type().toString().equalsIgnoreCase("int")){
			SemInteger si = new SemInteger();
			SemAn.isType.put(atomType, si);
			return si;
		}
		else if(atomType.type().toString().equalsIgnoreCase("char")){
			SemChar sc = new SemChar();
			SemAn.isType.put(atomType, sc);
			return sc;
		}
		else if(atomType.type().toString().equalsIgnoreCase("void")){
			SemVoid sv = new SemVoid();
			SemAn.isType.put(atomType, sv);
			return sv;
		}

		return null;
	}


	// EXPR

	public SemType visit(AstBinExpr binExpr, Mode mode){
		binExpr.fstExpr().accept(this, mode);
		binExpr.sndExpr().accept(this, mode);

		SemType fstExpr = SemAn.ofType.get(binExpr.fstExpr());
		SemType sndExpr = SemAn.ofType.get(binExpr.sndExpr());

		if(binExpr.oper() == Oper.ADD || binExpr.oper() == Oper.SUB || binExpr.oper() == Oper.MUL || binExpr.oper() == Oper.DIV || binExpr.oper() == Oper.MOD){
			if(!(fstExpr instanceof SemInteger) || !(sndExpr instanceof SemInteger)){
				throw new Report.Error(binExpr, "Binary operators can only be assigned to ints!");
			}			

			SemInteger sn = new SemInteger();
			SemAn.ofType.put(binExpr, sn);
			
			return sn;
		}
		else if(binExpr.oper() == Oper.EQU || binExpr.oper() == Oper.NEQ || binExpr.oper() == Oper.GTH || binExpr.oper() == Oper.LTH
				|| binExpr.oper() == Oper.GEQ || binExpr.oper() == Oper.LEQ){

			if(fstExpr instanceof SemInteger && sndExpr instanceof SemInteger ||
			   fstExpr instanceof SemChar && sndExpr instanceof SemChar ||
			   fstExpr instanceof SemPointer && sndExpr instanceof SemPointer){
				
				SemInteger sn = new SemInteger();
				SemAn.ofType.put(binExpr, sn);
				
				return sn;
			}
			else{
				throw new Report.Error(binExpr, "!= and == can only be assigned to ints, chars and pointers!");
			}
		}

		return null;
	}

	public SemType visit(AstPfxExpr pfxExpr, Mode mode){
		pfxExpr.expr().accept(this, mode);
		SemType expr = SemAn.ofType.get(pfxExpr.expr());

		if(pfxExpr.oper() == AstPfxExpr.Oper.ADD || pfxExpr.oper() == AstPfxExpr.Oper.SUB){
			if(!(expr instanceof SemInteger)){
				throw new Report.Error(pfxExpr, "Unary operators can only be assigned to ints");
			}

			SemInteger sn = new SemInteger();
			SemAn.ofType.put(pfxExpr, sn);
	
			return sn;
		}
		else if(pfxExpr.oper() == AstPfxExpr.Oper.NEW){
			if(!(expr instanceof SemInteger)){
				throw new Report.Error(pfxExpr, "New can only be called on ints!");
			}
			
			SemPointer sp = new SemPointer(new SemVoid());
			SemAn.ofType.put(pfxExpr, sp);

			return sp;
		}
		else if(pfxExpr.oper() == AstPfxExpr.Oper.DEL){
			if(!(expr instanceof SemPointer)){
				throw new Report.Error(pfxExpr, "Del can only be called on pointers!");
			}

			SemVoid sv = new SemVoid();
			SemAn.ofType.put(pfxExpr, sv);

			return sv;
		}
		else if(pfxExpr.oper() == AstPfxExpr.Oper.PTR){
			SemPointer sp = new SemPointer(expr);
			SemAn.ofType.put(pfxExpr, sp);
			
			return sp;
		}

		return null;
	}

	public SemType visit(AstSfxExpr sfxExpr, Mode mode){
		sfxExpr.expr().accept(this, mode);

		if(sfxExpr.oper() == AstSfxExpr.Oper.PTR){
			if(SemAn.ofType.get(sfxExpr.expr()) instanceof SemPointer){
				SemType baseType = ((SemPointer) SemAn.ofType.get(sfxExpr.expr())).baseType();
				SemAn.ofType.put(sfxExpr, baseType);

				return baseType;
			}
			else{
				throw new Report.Error(sfxExpr, "Dereferenciras lahko samo pointerje");
			}
		}


		return null;
	}

	public SemType visit(AstArrExpr arrExpr, Mode mode){
		arrExpr.arr().accept(this, mode);
		arrExpr.idx().accept(this, mode);

		SemType arr = SemAn.ofType.get(arrExpr.arr());
		SemType idx = SemAn.ofType.get(arrExpr.idx());
		System.out.println(arr + "," + idx);
		if(arr instanceof SemArray){
			if(idx instanceof SemInteger){
				SemArray array = ((SemArray)arr);

				if(array.numElems() < 1){
					throw new Report.Error(arrExpr, "Array indexes must be greater than 0!");
				}

				SemAn.ofType.put(arrExpr, array.elemType());

				return array;
			}
			else{
				throw new Report.Error(arrExpr, "Array indexes can only be of type int!");
			}
		}
		else{
			throw new Report.Error(arrExpr, "Array error!");
		}
	}

	public SemType visit(AstAtomExpr atomExpr, Mode mode){
		if(atomExpr.type() == AstAtomExpr.Type.INT){
			SemInteger sn = new SemInteger();
			SemAn.ofType.put(atomExpr, sn);
	
			return sn;
		}
		else if(atomExpr.type() == AstAtomExpr.Type.CHAR){
			SemChar sc = new SemChar();
			SemAn.ofType.put(atomExpr, sc);

			return sc;
		}
		else if(atomExpr.type() == AstAtomExpr.Type.VOID){
			SemVoid sv = new SemVoid();
			SemAn.ofType.put(atomExpr, sv);

			return sv;
		}
		else if(atomExpr.type() == AstAtomExpr.Type.POINTER){
			SemPointer sp = new SemPointer(new SemVoid());
			SemAn.ofType.put(atomExpr, sp);

			return sp;
		}
		
		return null;
	}

	public SemType visit(AstNameExpr nameExpr, Mode mode){
		if(SemAn.declaredAt.get(nameExpr) instanceof AstTypeDecl){
			SemAn.ofType.put(nameExpr, SemAn.declaresType.get((AstTypeDecl) SemAn.declaredAt.get(nameExpr)));
		}
		else if(SemAn.declaredAt.get(nameExpr) instanceof AstVarDecl){
			SemAn.ofType.put(nameExpr, SemAn.isType.get(((AstVarDecl) SemAn.declaredAt.get(nameExpr)).type()));
		}
		else if(SemAn.declaredAt.get(nameExpr) instanceof AstParDecl){
			SemAn.ofType.put(nameExpr, SemAn.isType.get(((AstParDecl) SemAn.declaredAt.get(nameExpr)).type()));
		}

		return null;
	}

	public SemType visit(AstCastExpr castExpr, Mode mode){
		castExpr.expr().accept(this, mode);
		castExpr.type().accept(this, mode);

		SemType cast = SemAn.ofType.get(castExpr.expr());
		SemType castType = SemAn.isType.get(castExpr.type());

		if(cast instanceof SemInteger || cast instanceof SemChar || cast instanceof SemPointer &&
		castType instanceof SemInteger || castType instanceof SemChar || castType instanceof SemPointer){

			SemAn.ofType.put(castExpr, castType);
			return cast;
		}
		else{
			throw new Report.Error(castExpr, "Cast only accepts ints, chars and pointers!");
		}
	}

	public SemType visit(AstWhereExpr whereExpr, Mode mode){
		whereExpr.expr().accept(this, mode);
		
		for(AstDecl decl : whereExpr.decls()){
			decl.accept(this, mode);
		}

		SemType where = SemAn.ofType.get(whereExpr.expr());
			
		if(where instanceof SemInteger || where instanceof SemChar || where instanceof SemVoid || where instanceof SemPointer){
			SemAn.ofType.put(whereExpr, where);

			return where;
		}
		else{
			throw new Report.Error(whereExpr, "Where only accepts chars, inst, voids and pointers!");
		}
	}

	public SemType visit(AstCallExpr callExpr, Mode mode){
		for(AstExpr expr : callExpr.args()){
			expr.accept(this, mode);
		}

		SemType type = SemAn.ofType.put(callExpr, SemAn.isType.get(((AstFunDecl)SemAn.declaredAt.get(callExpr)).type()));
		SemAn.ofType.put(callExpr, type);

		return type;
	}

	public SemType visit(AstStmtExpr stmtExpr, Mode mode){
		SemType st = null;

		for(AstStmt statement : stmtExpr.stmts()){
			st = statement.accept(this, mode);
		}

		SemAn.ofType.put(stmtExpr, st);

		return st;
	}
	
	// STMT

	public SemType visit(AstExprStmt exprStmt, Mode mode){
		exprStmt.expr().accept(this, mode);

		SemType st = SemAn.ofType.get(exprStmt.expr());
		SemAn.ofType.put(exprStmt, st);

		return st;
	}

	public SemType visit(AstAssignStmt assignStmt, Mode mode){
		assignStmt.src().accept(this, mode);
		assignStmt.dst().accept(this, mode);

		SemType assignSrc = SemAn.ofType.get(assignStmt.src());
		SemType assignDst = SemAn.ofType.get(assignStmt.dst());

		if(assignDst instanceof SemInteger || assignDst instanceof SemChar || assignDst instanceof SemPointer &&
		assignSrc instanceof SemInteger || assignSrc instanceof SemChar || assignSrc instanceof SemPointer){
			if(!(assignSrc .getClass().equals(assignDst.getClass()))){
				throw new Report.Error(assignStmt, "Assign statement operands must be of same type!");
			}

			SemVoid sv = new SemVoid();
			SemAn.ofType.put(assignStmt, sv);

			return sv;
		}
		else{
			throw new Report.Error(assignStmt, "Assign statement only accepts ints, chars and pointers!");
		}
	}

	public SemType visit(AstIfStmt ifStmt, Mode mode){
		ifStmt.cond().accept(this, mode);
		
		for(AstStmt stmt : ifStmt.thenStmts()){
			stmt.accept(this, mode);
		}

		for(AstStmt stmt : ifStmt.elseStmts()){
			stmt.accept(this, mode);
		}

		SemType condType = SemAn.ofType.get(ifStmt.cond());

		if(condType instanceof SemInteger){
			SemVoid sv = new SemVoid();
			SemAn.ofType.put(ifStmt, sv);

			return sv;
		}
		else{
			throw new Report.Error(ifStmt, "If statement condition must be of type int!");
		}
	}

	public SemType visit(AstWhileStmt whileStmt, Mode mode){
		whileStmt.cond().accept(this, mode);
		
		SemType stmtsType = null;

		for(AstStmt stmt : whileStmt.bodyStmts()){
			stmtsType = stmt.accept(this, mode);	
		}

		SemType whileType = SemAn.ofType.get(whileStmt.cond());

		if(whileType instanceof SemInteger && stmtsType instanceof SemVoid){
			SemVoid sv = new SemVoid();
			SemAn.ofType.put(whileStmt, sv);

			return sv;
		}
		else{
			throw new Report.Error(whileStmt, "While condition must be of type int and statements must be of type void!");
		}
	}
}
