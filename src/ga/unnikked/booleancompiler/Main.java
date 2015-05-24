package ga.unnikked.booleancompiler;


import ga.unnikked.booleancompiler.ast.BooleanExpression;
import ga.unnikked.booleancompiler.lexer.Lexer;
import ga.unnikked.booleancompiler.parser.RecursiveDescentParser;
import ga.unnikked.booleancompiler.visitor.BooleanCompiler;
import ga.unnikked.booleancompiler.vm.BooleanVM;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner((System.in));
		String expression = "";
		if(args.length > 0 && args[0].equals("-f")) {
			while(sc.hasNextLine()) expression += sc.nextLine(); System.out.println(expression);
		} else {
			System.out.println("Insert an expression:");
			expression = sc.nextLine();
		}

		Lexer lexer = new Lexer(new ByteArrayInputStream(expression.getBytes()));
		RecursiveDescentParser parser = new RecursiveDescentParser(lexer);
	    BooleanExpression ast = parser.build();

		System.out.println(String.format("AST: %s", ast));

		BooleanCompiler compiler = new BooleanCompiler();
		ast.accept(compiler);

		BooleanVM vm = new BooleanVM();
		boolean res = vm.start(compiler.getCode());

		System.out.println(String.format("RES: %s", res));
	}
}
