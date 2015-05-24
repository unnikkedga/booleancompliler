package ga.unnikked.booleancompiler.visitor;

import ga.unnikked.booleancompiler.ast.*;

/**
 *
 */
public class BooleanEvaluator implements BooleanVisitor<Boolean>{
	@Override
	public Boolean visit(And a) {
		return visit(a.getLeft()) && visit(a.getRight());
	}

	@Override
	public Boolean visit(Or o) {
		return visit(o.getLeft()) || visit(o.getRight());
	}

	@Override
	public Boolean visit(Not n) {
		return !visit(n.getLeft());
	}

	@Override
	public Boolean visit(True t) {
		return true;
	}

	@Override
	public Boolean visit(False f) {
		return false;
	}

	private Boolean visit(BooleanExpression b) {
		return b.accept(this);
	}
}
