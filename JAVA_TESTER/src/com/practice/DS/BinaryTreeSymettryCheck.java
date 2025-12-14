package com.practice.DS;



/*
 * Given the root of a binary tree, check whether it is a mirror of itself
 *  (i.e., symmetric around its center).
 *  Leetcode -101
 *  
 *  
 *  		1
 *  	   / \
 *  	  2	  2
 *  	 /\  / \
 *  	3 4  4  3
 */			
public class BinaryTreeSymettryCheck {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		
		
		System.out.println("Given Tree is symetry -- "+dfsHelper(root.left, root.right));
	}
	public static boolean dfsTree (TreeNode node) {
		
		return node==null || dfsHelper(node.left, node.right);
	}
	private static boolean dfsHelper(TreeNode left, TreeNode right) {
		
		if (left==null || right == null) {
			return left==right;
		}
		
		if (left.val!=right.val) {
			return false;
		}
		
		
		return dfsHelper(left.left , right.right)
					&& 
					dfsHelper(left.right, right.left );
	}
	
}
