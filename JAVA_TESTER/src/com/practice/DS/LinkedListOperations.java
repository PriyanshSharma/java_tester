package com.practice.DS;

import java.util.Arrays;

public class LinkedListOperations {

	public static void main(String[] args) {
		
		int arr[] = {1,2,3,4,5,6,7,8,9};
		
		Node headNode = createLinkedListfromArray(arr);
		
		printMyLinkedList(headNode);
		
//		Node reversed = reverseMyLinkedList(headNode);
//		System.out.println("Reversed..");
//		printMyLinkedList(reversed);
		
		Node reverseNodeStart = headNode.next.next.next.next;
		
		Node reversedFrom = reverseMyLinkedList(headNode, reverseNodeStart);
		printMyLinkedList(reversedFrom);
		
	}
	
	
	public static Node reverseMyLinkedList(Node headNode) {
		
		
		Node curr =headNode;
		Node prev = null;
		while (curr!=null) {
			Node tempNode = curr.next;
			curr.next=prev;
			prev=curr;
			curr=tempNode;
		}
		
		return prev;
	}
	
	public static Node insertNode(Node headNode, int data) {
		
		if (headNode==null) {
			return new Node(data);
		}
		
		Node curr = headNode;
		Node newNode = new Node(data);
		
		while (curr.next!=null) {
			curr=curr.next;
		}
		curr.next=newNode;
		
		return headNode;
		
	}
	
	public static Node createLinkedListfromArray (int arr[]) {
		
		Node headNode = insertNode(null, arr[0]);
		for (int i = 1 ; i<arr.length ; i++ ) {
			headNode =insertNode(headNode, arr[i]);
		}
		
		return headNode;
	}
	
	public static void printMyLinkedList(Node headNode) {
		
		if (headNode==null) {
			System.out.println("null");
			return;
		}
		
		System.out.print(headNode.data+"--> ");
		
		printMyLinkedList(headNode.next);
	}
	
	public static Node reverseMyLinkedList(Node headNode, Node startPointOfReversal) {
		
		
		if (headNode==null || startPointOfReversal==null) {
			return headNode;
		}
		
		if (headNode.data==startPointOfReversal.data) {
			return reverseMyLinkedList(headNode);
		}
		
		Node newHead =null;
		
		Node curr = headNode;
		Node prev=null;
		
		while (curr!=null && curr.data!=startPointOfReversal.data) {
			prev=curr;
			curr = curr.next;
		}
		
		newHead= reverseMyLinkedList(startPointOfReversal);

		if (prev!=null) {
			prev.next = newHead;
		}
		
		return headNode;
	}
	
	public static Node deleteNode(Node headNode) {
		
		return null;
	}
}
