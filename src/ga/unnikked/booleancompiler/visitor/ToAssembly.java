package ga.unnikked.booleancompiler.visitor;

import ga.unnikked.booleancompiler.ast.*;

/**
 *
 */
public class ToAssembly implements BooleanVisitor<Void> {
	private StringBuilder sb = new StringBuilder();

	@Override
	public Void visit(And a) {
		visit(a.getLeft());
		visit(a.getRight());
		sb.append("AND").append("\n");
		return null;
	}

	@Override
	public Void visit(Or o) {
		visit(o.getLeft());
		visit(o.getRight());
		sb.append("OR").append("\n");
		return null;
	}

	@Override
	public Void visit(Not n) {
		visit(n.getLeft());
		sb.append("NOT").append("\n");
		return null;
	}

	@Override
	public Void visit(True t) {
		sb.append("PUSH")
				.append(' ')
				.append("TRUE")
				.append("\n");
		return null;
	}

	@Override
	public Void visit(False f) {
		sb.append("PUSH")
				.append(' ')
				.append("FALSE")
				.append("\n");
		return null;
	}

	private Void visit(BooleanExpression b) {
		b.accept(this);
		return null;
	}

	public String getASM() {
		return sb.toString();
	}
}
