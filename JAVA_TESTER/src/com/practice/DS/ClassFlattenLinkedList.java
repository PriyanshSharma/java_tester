package com.practice.DS;

public class ClassFlattenLinkedList {

	public static void main(String[] args) {
		Node head = createLinkedList();
		
		/*
	     1 ->2 -> 3 -> 4
		     |
		     5 -> 6 -> 7
		          |
		          8 -> 9
		               |
		               10->null
		 */
		falttenLinkedList(head);
	}

	private static void falttenLinkedList(Node head) {
		
		Node current = head;
		Node tail = head;
		
		while(tail.next!=null) {
			tail=tail.next;
		}
		
		while (current!=null) {
			
			if(current.child!=null) {
				tail.next=current.child;
				while (tail.next!=null) {
					tail=tail.next;
				}
			}
			current=current.next;
		}
		
		Node temp = head;
		
		while (temp!=null) {
			System.out.print(temp.data+"->");
			temp=temp.next;
					
		}
	}

	private static Node createLinkedList() {
		
		 Node head = new Node(1);
	        head.next = new Node(2);
	        head.next.next = new Node(3);
	        head.next.next.next = new Node(4);

	        head.next.child = new Node(5);
	        head.next.child.next = new Node(6);
	        head.next.child.next.next = new Node(7);

	        head.next.child.next.child = new Node(8);
	        head.next.child.next.child.next = new Node(9);
	        head.next.child.next.child.next.child = new Node(10);

	        return head;
		
		
	}
}
