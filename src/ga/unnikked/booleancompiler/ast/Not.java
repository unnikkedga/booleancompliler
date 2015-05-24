package ga.unnikked.booleancompiler.ast;

import ga.unnikked.booleancompiler.visitor.BooleanVisitor;

public class Not extends NonTerminal {
	public void setChild(BooleanExpression child) {
		setLeft(child);
	}

	public void setRight(BooleanExpression right) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> T accept(BooleanVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public String toString() {
		return String.format("!%s", left);
	}
}
