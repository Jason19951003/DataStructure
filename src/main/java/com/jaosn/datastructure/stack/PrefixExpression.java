package com.jaosn.datastructure.stack;

import java.util.Stack;

public class PrefixExpression {
	public static void main(String[] args) {
		String str = "- 4 * 5 8";
		Stack<Integer> stack = new Stack<>();
		String preffix[] = str.split(" ");
		
		for (int i = preffix.length-1; i >= 0; i--) {
			try {
				stack.push(Integer.parseInt(preffix[i]));
			} catch (Exception e) {
				int num1 = stack.pop();
				int num2 = stack.pop();
				if ("+".equals(preffix[i])) {
					stack.push(num1 + num2);
				} else if ("-".equals(preffix[i])) {
					stack.push(num2 - num1);
				} else if ("*".equals(preffix[i])) {
					stack.push(num1 * num2);
				} else if ("/".equals(preffix[i])) {
					stack.push(num2 / num1);
				}
			}
		}
		
		System.out.println(str + " = " + stack.pop());
	}
}
