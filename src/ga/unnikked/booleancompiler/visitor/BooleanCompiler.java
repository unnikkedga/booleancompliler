package ga.unnikked.booleancompiler.visitor;

import ga.unnikked.booleancompiler.ast.*;
import ga.unnikked.booleancompiler.vm.Bool;
import ga.unnikked.booleancompiler.vm.OpCode;

import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class BooleanCompiler implements BooleanVisitor<Void>{
	private List<Integer> code;

	public BooleanCompiler() {
		this.code = new LinkedList<>();
	}

	@Override
	public Void visit(And a) {
		visit(a.getLeft());
		visit(a.getRight());
		code.add(OpCode.AND);
		return null;
	}

	@Override
	public Void visit(Or o) {
		visit(o.getLeft());
		visit(o.getRight());
		code.add(OpCode.OR);
		return null;
	}

	@Override
	public Void visit(Not n) {
		visit(n.getLeft());
		code.add(OpCode.NOT);
		return null;
	}

	@Override
	public Void visit(True t) {
		code.add(OpCode.PUSH);
		code.add(Bool.TRUE);
		return null;
	}

	@Override
	public Void visit(False f) {
		code.add(OpCode.PUSH);
		code.add(Bool.FALSE);
		return null;
	}

	private Void visit(BooleanExpression b) {
		b.accept(this);
		return null;
	}

	public Integer[] getCode() {
		return code.toArray(new Integer[code.size()]);
	}
}
