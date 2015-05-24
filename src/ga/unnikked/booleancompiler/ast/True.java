package ga.unnikked.booleancompiler.ast;

import ga.unnikked.booleancompiler.visitor.BooleanVisitor;

public class True extends Terminal {
	public True() {
		super(true);
	}

	@Override
	public <T> T accept(BooleanVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
