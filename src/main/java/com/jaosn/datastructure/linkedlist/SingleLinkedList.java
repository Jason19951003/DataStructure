package com.jaosn.datastructure.linkedlist;

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
		
		singleLinkedList.delete(2);
		
		System.out.println(singleLinkedList);
		
		singleLinkedList.delete(5);
	}
	
}
