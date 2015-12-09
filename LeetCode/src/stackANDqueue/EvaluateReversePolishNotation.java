package stackANDqueue;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		if (tokens.length == 0) {
			return 0;
		}
		for (int i = 0; i < tokens.length; i++) {
			String s = tokens[i];
			if (s.equals("+")) {
				int result = stack.pop() + stack.pop();
				stack.push(result);
			} else if (s.equals("*")) {
				int result = stack.pop() * stack.pop();
				stack.push(result);
			} else if (s.equals("-")) {
				int result = -stack.pop() + stack.pop();
				stack.push(result);
			} else if (s.equals("/")) {
				int sec = stack.pop();
				int fir = stack.pop();
				int result = fir / sec;
				stack.push(result);
			} else {
				stack.push(Integer.valueOf(s));
			}
		}
		return stack.pop();

	}
}
