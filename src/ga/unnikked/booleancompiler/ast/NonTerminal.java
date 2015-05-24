package ga.unnikked.booleancompiler.ast;

public abstract class NonTerminal implements BooleanExpression {
	protected BooleanExpression left, right;

	public void setLeft(BooleanExpression left) {
		this.left = left;
	}

	public void setRight(BooleanExpression right) {
		this.right = right;
	}

	public BooleanExpression getLeft() {
		return left;
	}

	public BooleanExpression getRight() {
		return right;
	}
}
