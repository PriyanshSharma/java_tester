package com.practice.DS;


/**
 * https://www.youtube.com/watch?v=fnmisPM6cVo&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=29
 * 
 * https://takeuforward.org/val-structure/check-for-children-sum-property-in-a-binary-tree/
 */
public class BinaryTreeChildrenSumProperty {

	public static void main(String[] args) {
		
	}
	
	
	public void changeBinaryTree(TreeNode root) {
		
		
		if (root==null) {
			return ;
		}
		
		int updateChildvalue = 0 ; 
		
		
		if (root.left!=null) {
			updateChildvalue += root.left.val;
		}
		
		if (root.right!=null) {
			updateChildvalue += root.right.val;
		}
		
		
		if (updateChildvalue>=root.val) {
			root.val = updateChildvalue;
		}
		
		else {
			
			if (root.left!=null) {
				root.left.val= updateChildvalue;
			}
			
			if (root.right!=null) {
				root.right.val=updateChildvalue;
			}
			
			
			changeBinaryTree(root.left);
			changeBinaryTree(root.right);
		}
		
		
		
		int totalV = 0 ; 
		
		if (root.left!=null) {
			totalV += root.left.val;
		}
		
		if (root.right!=null) {
			totalV += root.right.val;
		}
		
		if (root.left!=null || root.right!=null) {
			root.val = totalV;
		}
	}
}
