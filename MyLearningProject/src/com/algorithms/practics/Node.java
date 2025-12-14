package com.algorithms.practics;

public class Node<T> {
	T data;

	Node next;
	Node head ;
	
	
	public Node(T data) {
		this.data=data;
	}
	public Node() {
		
	}
	
	public void addNode(T data) {
		
		Node<T> newNode = new Node<>(data);
		Node<T> currentNode=null;
		
		if(this.head==null) {
			this.head=new Node(data);
			return;
		}
		newNode.next=null;
		currentNode = this.head;
			while(currentNode.next!=null) {
				currentNode = currentNode.next;
			}
			currentNode.next=newNode;
			
			return;
			
		
		
	}
	
	public void deleteNode(int position) {
		
		Node n = this.head;
		Node todelete=null;
		
		for(int i = 0 ; i < position-1 ; i ++) {
			 n = n.next;
		}
		todelete = n.next;
		n.next=todelete.next;
		todelete.next=null;
		
		
		
	}
	
	public  void insertInPosition(T data, int position) {
		Node n = new Node(data);
		Node next = this.head;
		if(position==0) {
			
			this.head =n;
			this.head.next=next;
			return;
		}
		
		Node current = this.head;
		
		for(int i = 0; i < position-1;i++) {
			
			current= current.next;
		}
		
		n.next=current.next;
		current.next=n;
		
	}
	
	
	public static void main(String[] args) {
		Node<Integer> n1 = new Node<Integer>();
		n1.addNode(10);
		n1.addNode(20);
		n1.addNode(30);
		
		
		n1.insertInPosition(50, 2);
		traverse(n1);
		
		n1.deleteNode(2);
		
		
		System.out.println("After deleting");
		traverse(n1);

		
		
	}
	
	public static void traverse (Node n1) {
		Node current = n1.head;
		// onlyu one node
	if(current!=null && current.next==null) {
		System.out.println(current.data);
		return ;
	}
		while(current!=null) {
			System.out.println(current.data);
			current=current.next;
		}
	}
	
	
	
	
}
