package com.practice;

public class SocieteGeneralRound1 {
	
	public static void main(String[] args) {
		BinarySearchNode tree = new BinarySearchNode(10);
		tree.insertVal(20);
		tree.insertVal(300);
		tree.insertVal(3);
	}
}

class BinarySearchNode{
	
	Node rootNode =null;	
	class Node {
		int value;
		Node left=null;
		Node right=null;
		
		Node (int item){
			
			 this.value =item;
		}
		
	}
	Node insertVal (int val) {
		if(rootNode==null) {
			rootNode = new Node(val);
			return rootNode;
		}
		
		
		if(val <= rootNode.value) {
			rootNode.left = insertVal(val);
		}
		else if(val > rootNode.value) {
			rootNode.right = insertVal(val);
		}
		
		return rootNode;
	}
	public BinarySearchNode(int val) {
		rootNode = new Node(val);
				
	}
	
	Node search (Node parentNode ,int valToBeSearch) {
		
		
		if(parentNode == null ) {
			return parentNode;
		}
		
		if(parentNode.value<valToBeSearch) {
			return search(parentNode.left,valToBeSearch);
		}
		
			return search(parentNode.right, valToBeSearch);
		
	}
//EMP, epname
/////@query("{epname:?0}")
//public getName (Sting apname);

}