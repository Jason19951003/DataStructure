package com.jaosn.datastructure.linkedlist;

public class DoubleLinkedList {

	private DoubleNode head;
	
	public DoubleLinkedList() {
		this.head = new DoubleNode(0, 0);
	}
	
	public void add(DoubleNode node) {
		DoubleNode temp = head;
		
		while (temp.next != null) {
			temp = temp.next;
		}
		
		temp.next =node;
		node.pre = temp;
	}
	
	public void delete(int val) {
		DoubleNode temp = head.next;
		
		while (temp.next != null && temp.value != val) {
			temp = temp.next;
		}
		
		if (temp.value == val) {
			temp.pre.next = temp.next;
			// 最後一個元素沒有next
			if (temp.next != null) {
				temp.next.pre = temp.pre;
			}
			
		} else {
			System.out.println("沒有元素: " + val);
		}
	}
	
	@Override
	public String toString() {
		String toString = "";
		DoubleNode temp = head;
		while (temp.next != null) {
			toString += temp.next.toString() + " -> ";
			temp = temp.next;
		}
		return toString;
	}
	
	public static void main(String[] args) {
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		
		DoubleNode node1 = new DoubleNode(1, 1);
		DoubleNode node2 = new DoubleNode(2, 2);
		DoubleNode node3 = new DoubleNode(3, 3);
		DoubleNode node4 = new DoubleNode(4, 4);
		
		doubleLinkedList.add(node1);
		doubleLinkedList.add(node2);
		doubleLinkedList.add(node3);
		doubleLinkedList.add(node4);
		
		System.out.println(doubleLinkedList);
		
		doubleLinkedList.delete(2);
		
		System.out.println(doubleLinkedList);
	}
}
