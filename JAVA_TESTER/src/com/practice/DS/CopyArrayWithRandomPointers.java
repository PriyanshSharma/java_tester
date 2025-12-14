package com.practice.DS;

import java.net.SecureCacheResponse;

public class CopyArrayWithRandomPointers {

	public static void main(String[] args) {
		  Node head = new Node(1);
	        head.next = new Node(2);
	        head.next.next = new Node(3);

	        // Setting random pointers
	        head.random = head.next.next; // 1 -> 3
	        head.next.random = head;      // 2 -> 1
	        head.next.next.random = head.next; // 3 -> 2

	        System.out.println("Original List:");
	        Node current = head;
	        while (current!=null) {
	        	System.out.print(current.data+"->");
	        	current=current.next;
	        }
	        current=head;
	        System.out.println();
	        while (current!=null) {
	        	System.out.print(current.random.data+"->");
	        	current=current.next;
	        }
	        
	     Node copied =   getCopiedList(head);
	     
	     System.out.println("Coped val -- > ");
	     while (copied!=null) {
	        	System.out.print(copied.random.data+"->");
	        	copied=copied.next;
	        }
	}
	
	public static Node getCopiedList (Node originalhead) {
		//Copying and inserting in middle
		
		Node current = originalhead;
		while (current!=null) {
			Node newN= new Node(current.data);
			newN.next=current.next;
			current.next=newN;
			current=current.next.next;
		}
			
			
		//	Random pointer assignment
		
		current=originalhead;
		
		while (current!=null) {
			current.next.random=current.random.next;
			current=current.next.next;
			
		}
		
		
		Node returning=originalhead.next;
		current=originalhead;
		while (current!=null && returning!=null) {
			current.next=current.next.next;
			current=current.next;
			if(current!=null) {
				returning.next = returning.next.next;
				returning=returning.next;

			}
		}
				
		return returning;
	}
	}
