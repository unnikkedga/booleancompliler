package ga.unnikked.booleancompiler.visitor;

import ga.unnikked.booleancompiler.ast.*;

/**
 *
 */
public interface BooleanVisitor<T> {
	T visit(And a);

	T visit(Or o);

	T visit(Not n);

	T visit(True t);

	T visit(False f);
}
