package ga.unnikked.booleancompiler.ast;

import ga.unnikked.booleancompiler.visitor.BooleanVisitor;

public class False extends Terminal {
	public False() {
		super(false);
	}

	@Override
	public <T> T accept(BooleanVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
