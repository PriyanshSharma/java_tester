package com.algorithms.practics;

public class MyLinkedList {

	Node head;

	public MyLinkedList(int x ){
		
	}
	
	class Node {
		int data;
		
		Node next;
	public Node(int i) {
		data = i;
	}
	
	}
	
	
	public void addData(int i) {
		
		Node curr = new Node(i);
		
		if(head==null) {
			head=curr;
			return ;
		}
		Node currentTraverserval = head;
		while (currentTraverserval.next!=null) {
			currentTraverserval = head.next;
		}
		currentTraverserval.next=curr;
//		head.next.next=null;
		
		
	}
	
	public static void linksPrinter(MyLinkedList l) {
		
		while (l.head!=null) {
			System.out.println("Elemm - "+l.head.data);
			l.head = l.head.next;
		}
		
	}
	
	public void reverseMyList (MyLinkedList l ) {
		
		
	}
	
	public static void main(String[] args) {
		
		MyLinkedList l = new MyLinkedList(0);
		l.addData(10);
		l.addData(20);
		l.addData(30);
		
		linksPrinter(l);
		
		System.out.println(l);
	}
}
