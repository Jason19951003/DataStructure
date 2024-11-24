package com.jaosn.datastructure.linkedlist;

import java.util.Stack;

public class SingleLinkedList {

	private Node head;
	
	public SingleLinkedList() {
		head = new Node(0, 0);
	}
	
	public void addNode(Node node) {
		Node temp = head;
		
		while (temp.next != null) {
			temp = temp.next;
		}
		
		temp.next = node;
	}
	
	public void delete(int value) {
		Node curr = head;
		Node next = head.next;
		
		while (next != null && next.value != value) {
			curr = next;
			next = next.next;
		}
		if (next != null) {
			curr.next = next.next;
			next = null;
		} else {
			System.out.println("找不到該Node: " + value);
		}
		
	}

	/**
	 * 查詢LinkedList長度
	 * @return
	 */
	public int length() {
		Node temp = head;
		int res = 0;
		while (temp.next != null) {
			res++;
			temp = temp.next;
		}
		return res;
	}
	
	/**
	 * 查詢倒數第index個元素
	 * @param index
	 * @return
	 */
	public int findReverse(int index) {
		Node temp = head.next;
		
		if (index <= 0) {
			System.out.println("index 不可小於零");
			return -1;
		}
		
		for (int i = 0; i < length() - index; i++) {
			temp = temp.next;
		}
		return temp.value;
	}
	
	/**
	 * 反轉LinkedList
	 */
	public void reverse() {
		Node pre = null;
		Node curr = head;
		Node next = head.next;
			
		while (curr != null && next != null) {
			curr = next;
			next = next.next;
			curr.next = pre;
			pre = curr;
		}
		
		head.next = curr;
	}
	
	public SingleLinkedList reverseOutput() {
		SingleLinkedList linkedList = new SingleLinkedList();
		
		Stack<Integer> stack = new Stack<>();
		Node temp = head.next;
		while (temp != null) {
			stack.push(temp.value);
			temp = temp.next;
		}
		
		while (!stack.isEmpty()) {
			int val = stack.pop();
			linkedList.addNode(new Node(val, val));
		}
		
		return linkedList;
	}
	
	@Override
	public String toString() {
		String toString = "";
		Node temp = head;
		while (temp.next != null) {
			toString += temp.next.toString() + " -> ";
			temp = temp.next;
		}
		return toString;
	}
	
	public static void main(String[] args) {
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		
		Node node1 = new Node(1, 1);
		Node node2 = new Node(2, 2);
		Node node3 = new Node(3, 3);
		Node node4 = new Node(4, 4);
		
		singleLinkedList.addNode(node1);
		singleLinkedList.addNode(node2);
		singleLinkedList.addNode(node3);
		singleLinkedList.addNode(node4);
		
		System.out.println(singleLinkedList);
		System.out.println("長度為:" + singleLinkedList.length());
		System.out.println("倒數第2個元素為:" + singleLinkedList.findReverse(2));
		System.out.println(singleLinkedList);
		singleLinkedList.reverse();
		
		System.out.println(singleLinkedList);
		
		singleLinkedList.delete(2);
		
		System.out.println(singleLinkedList);
		
		singleLinkedList.delete(5);
		
		System.out.println(singleLinkedList.reverseOutput());
	}
	
}
