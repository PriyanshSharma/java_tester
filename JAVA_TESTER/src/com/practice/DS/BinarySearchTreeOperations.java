package com.practice.DS;

public class BinarySearchTreeOperations {

	public static void main(String[] args) {
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
		TreeNode finalNode = insertion(node, 3);
		
		
		
		System.out.println(finalNode);
		
		System.out.println("Search 10 in BST ");
		TreeNode keyNode = searchBST(finalNode, 10);
		System.out.println(keyNode.val+" Left - "+keyNode.left.val+" Right - "+keyNode.right.val);
		
		System.out.println("Before deletion -- ");
		TreePrinter.printTree(finalNode);
		System.err.println("deleting element == 10 ");
		finalNode= deleteNode(finalNode, 10);
		
		TreePrinter.printTree(finalNode);
		finalNode =insertion(finalNode, 60);
		TreePrinter.printTree(finalNode);

		
		
		insertion(finalNode, 39);
		finalNode=insertion(finalNode, 38);
		TreePrinter.printTree(finalNode);
		
		finalNode=deleteNode(finalNode, 30);
		TreePrinter.printTree(finalNode);
		
		System.out.println("Is BST or NOT -- "+isBST(finalNode, Integer.MIN_VALUE, Integer.MAX_VALUE));


		

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
	
	public static TreeNode searchBST(TreeNode root, int key) {
		
		if(root==null) {
			return null;
		}
		
		if (root.val==key) {
			return root;
		}
		
		if(key<root.val) {
			return searchBST(root.left, key);
		}
		
		return searchBST(root.right, key);
	}
	
	public static TreeNode deleteNode(TreeNode root, int key) {
		if(root==null) {
			return root;
		}
		// Searching the key part--
		if (key<root.val) {
			root.left=deleteNode(root.left, key);
		}
		else if (key>root.val) {
			root.right = deleteNode(root.right, key);
		}
		
		// Search part ends here..
		
		// Now delete part starts--
		else {
			if(root.left==null) {
				return root.right;
			}
			else if (root.right==null) {
				return root.left;
			}
			
			// Got the value that has to be swapped for the deleted element. 
			//if that is swapped the original wil be deleted
			// Why root.data == ebcause we are overwirting the value of existing root.data from minValue that we
			//got from minValue--> extreme left val;
			root.val = minValue(root.right).val;
			root.right = deleteNode(root.right, root.val);
		}
		
		return root;
	}
	
	public static boolean isBST(TreeNode root, int min, int max) {
		if(root==null) {
			return true;
		}
		
		if(root.val<min || root.val>max) {
			return false;
		}
		
		
		return isBST(root.left, min, root.val)
					&&
					isBST(root.right, root.val, max);
	}

	private static TreeNode minValue(TreeNode node) {
		while (node.left!=null) {
			node=node.left;
		}
		return node;
	}
}
