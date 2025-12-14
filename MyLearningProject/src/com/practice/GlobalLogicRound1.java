package com.practice;

public class GlobalLogicRound1 {
	
	public static void main(String[] args) {
		Node head = populateLinkList();
		print(reverse(head));
	}
	
	
	private static void print (Node node) {
		while (node!=null) {
			System.out.println(node.data);
			node = node.next;
		}
	}
	
	private static Node reverse (Node node) {
		
		Node previous = null ;; 
		Node curr = node;
		Node next = null;
		
		while (curr!=null){
			next = curr.next;
			curr.next = previous;
			previous = curr;
			curr = next;
			
			
		}
//		node = previous;
		
		return previous;
	}
	
	private static Node populateLinkList () {
		
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5); 
		head.next.next.next.next.next = new Node(6); 
		return head;
				
	}

	static class Node {
		
		int data;
		Node next;
		
		Node (int data){
			
			this.data = data;
		}
	
	}
}