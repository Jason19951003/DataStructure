package com.jaosn.datastructure.linkedlist;

public class Node {
	int no;
	int value;
	Node next;
	
	public Node(int no, int value) {
		this.no = no;
		this.value = value;
		this.next = null;
	}

	@Override
	public String toString() {
		return "Node [no=" + no + ", value=" + value + "]";
	}
	
}
