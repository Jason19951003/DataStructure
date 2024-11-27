package com.jaosn.datastructure.stack;

import java.util.Stack;

public class SuffixExpression {

	public static void main(String[] args) {
		String str = "8 5 * 4 -";
		Stack<Integer> stack = new Stack<>();
		
		for (String suffix : str.split(" ")) {
			try {
				stack.push(Integer.parseInt(suffix));
			} catch (Exception e) {
				int num1 = stack.pop();
				int num2 = stack.pop();
				if ("+".equals(suffix)) {
					stack.push(num1 + num2);
				} else if ("-".equals(suffix)) {
					stack.push(num2 - num1);
				} else if ("*".equals(suffix)) {
					stack.push(num1 * num2);
				} else if ("/".equals(suffix)) {
					stack.push(num2 / num1);
				}
			}
		}
		
		System.out.println(str + " = " + stack.pop());
	}

}
