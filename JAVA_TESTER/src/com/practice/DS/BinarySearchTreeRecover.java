package com.practice.DS;

/*
 * Recover the BST, where exactly two nodes values are swapped.
 * Get the correct BST
 */
public class BinarySearchTreeRecover {

	
	TreeNode first = null;
	TreeNode second = null;
	TreeNode prev = null;
	public static void main(String[] args) {
		
		BinarySearchTreeRecover obj = new BinarySearchTreeRecover();
		TreeNode node = new TreeNode(20);
		
		
		insertion(node, 10);
		insertion(node, 30);
		insertion(node, 5);
		insertion(node, 15);
		insertion(node, 25);
		insertion(node, 40);
		insertion(node, 55);
		insertion(node, 45);
		insertion(node, 2);
		
		
		
		
		System.out.println("My original tree -- ");
		TreePrinter.printTree(node);
		
		System.out.println("Inoder traversal of the tree -- ");
		BinaryTreeCreation.createTreeInOrder(node);
		
		
		node.left.right.val=40;
		node.right.right.val=15;
		
		System.out.println("Swapped value of tree now");
		TreePrinter.printTree(node);
		
		
		System.out.println("Inoder traversal of the tree after swapped -- ");
		BinaryTreeCreation.createTreeInOrder(node);
		
		
		
		System.out.println("Recovering BST .. After the changes -- ");
		
		obj.recoverBST(node);
		
		System.out.println("");
		
		TreePrinter.printTree(node);
		BinaryTreeCreation.createTreeInOrder(node);
		
		
	}
	
	
	public void recoverBST (TreeNode root) {
		
		if (root == null) {
			return;
		}
		
		inorderTraverse(root);
		
		if (first!=null && second!=null) {
			int t = first.val;
			first.val = second.val;
			second.val = t;
		}
		
	}
	
	public void inorderTraverse(TreeNode root) {
		
		if (root == null) {
			return ;
		}
		
		inorderTraverse(root.left);
		
		//Visit the node part 
		
		if (prev!=null && prev.val>root.val) {
			
			if (first==null) {
				first= prev;
				second=root;
			}
			else {
				second=root;
			}
		}
		
		prev=root;
		
		inorderTraverse(root.right);
		
	}
	
	public static TreeNode insertion(TreeNode root, int key) {
		
		if(root==null) {
			TreeNode node = new TreeNode(key);
			return node;
		}
		
		if(key<root.val) {
			root.left = insertion(root.left, key);
		}
		else {
			root.right = insertion(root.right, key);
		}
		
		return root;
	}
	
}
