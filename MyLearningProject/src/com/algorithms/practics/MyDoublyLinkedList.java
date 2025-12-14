package com.algorithms.practics;

public class MyDoublyLinkedList {
	
	Node head;
	class Node {
		int data;
		Node next;
		Node prev;
	
		public Node(int d) {
			data = d;
		}
	
	}

	public void addNode(int data) {
		
		Node n = new Node(data);
		
		if(head==null) {
			head=n;
			return ;
			
		}
		Node currentInsert = head;
		while(currentInsert.next!=null) {
			currentInsert = currentInsert.next;
		}
		
		
		n.prev=currentInsert;
		currentInsert.next=n;
		n.next = null;
	}

public static void main(String[] args) {
	MyDoublyLinkedList list = new MyDoublyLinkedList();
	list.addNode(10);
	list.addNode(20);
	list.addNode(30);
	list.addNode(40);
	list.addNode(50);
	list.addNode(80);
	
}
}
