package com.practice.DS;

public class StackUsingLinkedlist {

	static Node head;
	static int size=0;
	
	public StackUsingLinkedlist() {
		head=null;
	}
	public static void main(String[] args) {
		StackUsingLinkedlist stackList = new StackUsingLinkedlist();
		
		insertElement(1);
		insertElement(2);

		insertElement(3);
		insertElement(4);
		System.out.println(head.data);
		System.out.println(popData());
		System.out.println(popData());
		
		System.out.println(peekData());
		System.out.println(peekData());

	}
	
	public static void insertElement(int data) {
		
		Node newNode = new Node(data);
		
		newNode.next = head;
		head = newNode;
		size++;
		
		
	}
	
	public static int popData() {
		int removedElement = head.data;
		head= head.next;
		size--;
		return removedElement;
	}
	
	public static int peekData() {
		return head.data;
	}
}

