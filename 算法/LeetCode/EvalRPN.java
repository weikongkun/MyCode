package com.leetCode;

/**
 * <p>Title:Evaluate_reverse_polish_notation</p>
 * <p>Description:Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are+,-,*,/. Each operand may be an integer or another expression.逆波兰表达式(后缀表达式) </p>
 * @auther Administrator
 * @data 2017年10月14日 下午10:14:40
 */

import java.util.Stack;

public class EvalRPN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = new String[] {"4", "13", "5", "/", "+"};
		System.out.println(evalRPN(strs));

	}
	
	public static int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equals("+"))
				stack.push(stack.pop() + stack.pop());
			else if (tokens[i].equals("-")) {
				int num2 = stack.pop();
				int num1 = stack.pop();
				stack.push(num1 - num2);
			}
			else if (tokens[i].equals("*"))
				stack.push(stack.pop() * stack.pop());
			else if (tokens[i].equals("/")) {
				int num2 = stack.pop();
				int num1 = stack.pop();
				stack.push(num1 / num2);
			}
			else
				stack.push(Integer.valueOf(tokens[i]));
		}
		return stack.peek();
	}

}
