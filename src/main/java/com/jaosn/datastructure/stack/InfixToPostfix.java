package com.jaosn.datastructure.stack;

import java.util.Stack;

public class InfixToPostfix {

	public static void main(String[] args) {
		String str = "( 8 + 5 ) * 9";
		// 中序轉後序步驟
		// 1. 由左至右掃描
		// 2. 遇到運算子放入Stack
		// 3. 遇到數字print
		// 4. 遇到)pop直到遇到(
		// 5. 重複1~4 直到結束
		// 6. pop stack and print until (
		Stack<String> stack = new Stack<>();
		for (String s : str.split(" ")) {
			if (s.matches("\\d")) {
				System.out.print(s + " ");
			} else {
				if (!")".equals(s)) {
					stack.push(s);
				} else {
					do {
						String exp = stack.pop();
						if ("(".equals(exp)) {
							break;
						}
						System.out.print(exp + " ");
					} while (!stack.isEmpty());
				}
			}
		}
		
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		 
	}

}
