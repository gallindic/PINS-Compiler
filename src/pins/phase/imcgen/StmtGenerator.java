package pins.phase.imcgen;

import java.util.*;

import pins.data.ast.tree.stmt.*;
import pins.data.ast.visitor.*;
import pins.data.mem.*;
import pins.data.imc.code.stmt.*;

public class StmtGenerator implements AstVisitor<ImcStmt, Stack<MemFrame>> {

	// TODO
	public ImcStmt visit(AstExprStmt exprStmt, Stack<MemFrame> frame){
		exprStmt.expr().accept(new ExprGenerator(), frame);

		ImcESTMT estmt = new ImcESTMT(ImcGen.exprImc.get(exprStmt.expr()));
		ImcGen.stmtImc.put(exprStmt, estmt);

		return estmt;
	}

	public ImcStmt visit(AstAssignStmt assignStmt, Stack<MemFrame> frame){
		ExprGenerator exprGenerator = new ExprGenerator();

		assignStmt.dst().accept(exprGenerator, frame);
		assignStmt.src().accept(exprGenerator, frame);
		
		ImcMOVE move = new ImcMOVE(ImcGen.exprImc.get(assignStmt.dst()), ImcGen.exprImc.get(assignStmt.src()));
		ImcGen.stmtImc.put(assignStmt, move);

		return move;
	}

	public ImcStmt visit(AstIfStmt ifStmt, Stack<MemFrame> frame){
		Vector<ImcStmt> ifStatements = new Vector<>();
		ifStmt.cond().accept(new ExprGenerator(), frame);

		ImcLABEL thenLabel = new ImcLABEL(new MemLabel()), elseLable = new ImcLABEL(new MemLabel()), endLabel = new ImcLABEL(new MemLabel());
		ImcCJUMP cjump = new ImcCJUMP(ImcGen.exprImc.get(ifStmt.cond()), thenLabel.label, elseLable.label);
		ImcJUMP jump = new ImcJUMP(endLabel.label);
		
		ifStatements.add(cjump);
		ifStatements.add(thenLabel);

		for(AstStmt thenStmt : ifStmt.thenStmts()){
			ImcStmt statement = thenStmt.accept(this, frame);
			ifStatements.add(statement);
		}

		ifStatements.add(jump);
		ifStatements.add(elseLable);

		for(AstStmt elseStmt : ifStmt.elseStmts()){
			ImcStmt statement = elseStmt.accept(this, frame);
			ifStatements.add(statement);
		}

		ifStatements.add(endLabel);

		ImcSTMTS imcSt = new ImcSTMTS(ifStatements);
		ImcGen.stmtImc.put(ifStmt, imcSt);

		return imcSt;
	}

	public ImcStmt visit(AstWhileStmt whileStmt, Stack<MemFrame> frame){
		Vector<ImcStmt> whileStatements = new Vector<>();
		whileStmt.cond().accept(new ExprGenerator(), frame);

		ImcLABEL start = new ImcLABEL(new MemLabel()), loop = new ImcLABEL(new MemLabel()), end = new ImcLABEL(new MemLabel());
		ImcCJUMP cjump = new ImcCJUMP(ImcGen.exprImc.get(whileStmt.cond()), loop.label, end.label);
		ImcJUMP jump = new ImcJUMP(start.label);

		whileStatements.add(start);
		whileStatements.add(cjump);
		whileStatements.add(loop);

		for(AstStmt stmt : whileStmt.bodyStmts()){
			ImcStmt statement = stmt.accept(this, frame);
			whileStatements.add(statement);
		}

		whileStatements.add(jump);
		whileStatements.add(end);
		
		ImcSTMTS imcSt = new ImcSTMTS(whileStatements);
		ImcGen.stmtImc.put(whileStmt, imcSt);

		return imcSt;
	}
}
