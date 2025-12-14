package com.practice.DS;

public class BinaryTreeLCA {

	public static void main(String[] args) {
		
	}
	
	public static TreeNode findLCA(TreeNode root, TreeNode n1, TreeNode n2) {
		
		if(root==null) {
			return null;
		}
		
		if(root.val==n1.val || root.val==n2.val) {
			return root;
		}
		
		TreeNode left = findLCA(root.left, n1, n2);
		TreeNode right=findLCA(root.right, n1, n2);
		
		if(left==null) {
			return right;
		}
		if(right==null) {
			return left;
		}
		return root;
	}
}
