package ga.unnikked.booleancompiler.vm;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 */
public final class BooleanVM {
	private Stack<Integer> stack;

	public BooleanVM() {
		this.stack = new Stack<>();
	}

	public boolean start(Integer[] code) {
		System.out.println("CODE: " + Arrays.toString(code));
		int opcode;
		int ip = 0;
		while (ip < code.length) {
			// fetching
			opcode = code[ip++];
			switch (opcode) {
				case OpCode.PUSH : stack.push(code[ip++]); break;
				case OpCode.AND: {
					int b = stack.pop();
					stack.push(stack.pop() & b);
					break;
				}
				case OpCode.OR: {
					int b = stack.pop();
					stack.push(stack.pop() | b);
					break;
				}
				case OpCode.NOT: stack.push(~stack.pop() & 0x01); break;
				default: throw new RuntimeException("Invalid opcode " + code[ip -1]);
			}
		}
		return stack.pop() == Bool.TRUE;
	}
}
