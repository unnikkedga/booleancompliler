package ga.unnikked.booleancompiler.ast;

import ga.unnikked.booleancompiler.visitor.BooleanVisitor;

public class Or extends NonTerminal {
	@Override
	public <T> T accept(BooleanVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public String toString() {
		return String.format("(%s | %s)", left, right);
	}
}
