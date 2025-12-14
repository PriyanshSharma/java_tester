package com.practice.DS;

public class BinaryTreeDistanceBetween2Nodes {

	static int answer=0;
	public static void main(String[] args) {
		
	}
	
	public static int distanceMax(TreeNode root) {
		
		if(root==null) {
			return -1;
		}
		
		int lh = distanceMax(root.left);
		int rh=distanceMax(root.right);
		
		answer = Math.max(answer, lh+rh+1);
		
		return Math.max(lh, rh)+1;
	}
}
