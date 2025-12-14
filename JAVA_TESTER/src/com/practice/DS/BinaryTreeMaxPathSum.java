package com.practice.DS;

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes 
 * in the sequence has an edge connecting them. A node can only appear in the sequence at most once. 
 * Note that the path does not need to pass through the root.
 * The path sum of a path is the sum of the node's values in the path.
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 * 
 * Leetcode Sol - 
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/solutions/7075080/max-path-of-binary-tree-by-p4priyansh_sh-jnjp/
 */

public class BinaryTreeMaxPathSum {

	int ans = Integer.MIN_VALUE;
	public static void main(String[] args) {
		
		
		TreeNode root = new TreeNode(1);
	        root.left = new TreeNode(2);
	        root.right = new TreeNode(3);
	        root.left.left = new TreeNode(4);
	        root.left.right = new TreeNode(5);
	        root.left.right.right = new TreeNode(6);
	        root.left.right.right.right = new TreeNode(7);
	        
	        System.out.println("Answer = "+
	        new BinaryTreeMaxPathSum().maxPathSum(root));
	}
	
	public int maxPathSum(TreeNode root) {
        int arr[] = {Integer.MIN_VALUE};
		
		 
		 return  maxPathSumUtil(root);
		
		
    }

	private int maxPathSumUtil(TreeNode root) {
		if (root == null) {
			return 0 ; 
		}
		
		
		// This we have done to handle the edge case, like if a tree is just [2,-1], in that case, max(0,-1)=> 0 not -1,
		// thus that will give max path sum as 2 not as 1...
		
		
		int lh = Math.max(0, maxPathSumUtil(root.left));
		int rh = Math.max(0,maxPathSumUtil(root.right));
		
		
		
		
//		arr[0] = Math.max(arr[0], lh+rh+root.data);
		ans = Math.max(ans, lh+rh+root.val);
		
//		System.out.println("Current ans arr= "+arr[0]);
		System.out.println("Current ans = "+ans);
		
		return root.val + Math.max(lh, rh);
				
	}
}
