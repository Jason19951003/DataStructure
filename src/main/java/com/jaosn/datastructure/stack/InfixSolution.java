package com.jaosn.datastructure.stack;

import java.util.Stack;

/**
 * 不包含括號的中序
 */
public class InfixSolution {
	public static void main(String[] args) {
		String str = "8+5*2";

		Stack<Integer> numStack = new Stack<>();
		Stack<Integer> opStack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			try {
				Integer num = Integer.parseInt(String.valueOf(str.charAt(i)));
				numStack.push(num);
			} catch (Exception e) {
				char op = str.charAt(i);
				if (opStack.isEmpty() || priority(opStack.peek()) < priority(op)) {
					opStack.push((int) op);
				} else {
					int num1 = numStack.pop();
					int num2 = numStack.pop();

					switch (op) {
						case '+':
							numStack.push(num1 + num2);
							break;
						case '-':
							numStack.push(num2 - num1);
							break;
						case '*':
							numStack.push(num1 * num2);
							break;
						case '/':
							numStack.push(num2 / num1);
							break;
					}
				}
			}
		}

		while (!opStack.isEmpty()) {
			int num1 = numStack.pop();
			int num2 = numStack.pop();
			char op = (char) opStack.pop().intValue();
			switch (op) {
			case '+':
				numStack.push(num1 + num2);
				break;
			case '-':
				numStack.push(num2 - num1);
				break;
			case '*':
				numStack.push(num1 * num2);
				break;
			case '/':
				numStack.push(num2 / num1);
				break;
			}
		}
		System.out.println(str + " = " + numStack.pop());
		
	}

	public static int priority(int op) {
		if (op == '+' || op == '-') {
			return 1;
		} else if (op == '*' || op == '/') {
			return 2;
		}
		return -1;
	}
}
