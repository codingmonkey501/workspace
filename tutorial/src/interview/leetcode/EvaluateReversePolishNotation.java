package interview.leetcode;

import java.util.Stack;

public class EvaluateReversePolishNotation {

	
	/**
	 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

		Valid operators are +, -, *, /. Each operand may be an integer or another expression.
		
		Some examples:
		  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
		  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
	 */
	// The infix expression "5 + ((1 + 2) * 4) − 3" can be written down like
	// this in RPN: 5 1 2 + 4 * + 3 -
	
	public static void main(String[] args) {
		EvaluateReversePolishNotation e=new EvaluateReversePolishNotation();
		System.out.println(e.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
		System.out.println(e.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
		System.out.println(e.evalRPN(new String[]{"5", "1", "2", "+", "4", "*", "+", "3", "-"}));
	}
	
	//iterative way
	public int evalRPN(String[] tokens) {
		Stack<String> stack = new Stack<String>();
		for (String token : tokens) {
			if (!isOperator(token)) {
				stack.push(token);
			} else {
				int y = Integer.parseInt(stack.pop());
				int x = Integer.parseInt(stack.pop());
				if ("+".equals(token))
					x += y;
				else if ("-".equals(token))
					x -= y;
				else if ("*".equals(token))
					x *= y;
				else
					x /= y;
				stack.push(Integer.toString(x));
			}
		}
		return Integer.parseInt(stack.pop());
	}
		
		
	//recusive time O(n) space O(logn)
	public int evalRPN2(String[] tokens) {
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < tokens.length; i++)
			stack.push(tokens[i]);
		return evalRPN2(stack);
	}

	public int evalRPN2(Stack<String> tokens) {
		int x, y;
		String token = tokens.pop();
		if (isOperator(token)) {
			y = evalRPN2(tokens);
			x = evalRPN2(tokens);
			if ("+".equals(token))
				x += y;
			else if ("-".equals(token))
				x -= y;
			else if ("*".equals(token))
				x *= y;
			else
				x /= y;
		} else {
			x = Integer.parseInt(token);
		}
		return x;
	}

	private boolean isOperator(String op) {
		return new String("+-*/").contains(op);
	}
}
