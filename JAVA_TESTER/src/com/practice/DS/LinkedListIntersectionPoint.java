package com.practice.DS;

public class LinkedListIntersectionPoint {

	
	public static void main(String[] args) {
		 Node head1 = new Node(10);
	        head1.next = new Node(15);
	        head1.next.next = new Node(30);

	        // creation of second list: 3 -> 6 -> 9 -> 15 -> 30
	        Node head2 = new Node(3);
	        head2.next = new Node(6);
	        head2.next.next = new Node(9);

	        // 15 is the intersection point
	        head2.next.next.next = head1.next;
		
		Node intersectionNode = getIntersectionNode(head1,head2);
		
		System.err.println(intersectionNode.data);
		
	}
	
	public static Node getIntersectionNode(Node n1, Node n2) {
		if (n1==null || n2==null) {
			return null;
		}
		
		int l1 = getLengthOfList(n1);
		int l2 = getLengthOfList(n2);
		
		Node t1 = n1;
		Node t2 = n2;
		
		while (l1>l2) {
			l1--;
			t1=t1.next;
		}
		while (l2>l1) {
			l2--;
			t2=t2.next;
		}
		
		while (t1!=t2) {
			t1=t1.next;
			t2=t2.next;
		}
		return t1;
	}
	
	
	private static int getLengthOfList(Node head) {
		
		int len = 1 ; 
		while (head.next!=null) {
			len++;
			head = head.next;
		}
		
		return len;
	}
}
