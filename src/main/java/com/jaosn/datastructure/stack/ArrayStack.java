package com.jaosn.datastructure.stack;

public class ArrayStack<T> {

	private int maxSize;
	private int top;
	private T[] stack;
	
	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		this.top = -1;
		stack = (T[]) new Object[maxSize];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return maxSize == top + 1;
	}
	
	public void push(T item) {
		if (isFull()) {
			System.out.println("Stack已滿");
			return;
		}
		stack[++top] = item;
	}
	
	public T pop() {
		if (isEmpty()) {
			System.out.println("Stack為空!");
			return null;
		}
		return stack[top--];
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i <= top; i++) {
			sb.append(stack[i] + " ");
		}
		sb.append("]\n");	
		return sb.toString();
	}
		
	public static void main(String[] args) {
		ArrayStack<Integer> stack = new ArrayStack<>(10);
		
		stack.push(10);
		stack.push(3);
		stack.push(18);
		
		System.out.println(stack);
		
		System.out.println(stack.pop());
		
		System.out.println(stack);
	}
}
