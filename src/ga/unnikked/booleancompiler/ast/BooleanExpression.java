package ga.unnikked.booleancompiler.ast;

import ga.unnikked.booleancompiler.visitor.BooleanVisitor;

/**
 *
 */
public interface BooleanExpression {
	<T> T accept(BooleanVisitor<T> visitor);
}
