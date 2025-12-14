package com.practice.DS;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeConstruction {

	
	public static void main(String[] args) {
		
		
		int inorder[] = {40,20,50,10,60,30};
		int preorder[] = {10,20,40,50,30,60};
		
		TreeNode root =  constructBinaryTreeFromInorder_preOrder(inorder,preorder);
		System.out.println(root);
	}

	private static TreeNode constructBinaryTreeFromInorder_preOrder(int[] inorder, int[] preorder) {
		
		int preStart = 0 ;//  for preorder 0 index will be first root.
		int preEnd = preorder.length-1;
		
		int instart = 0;
		int inend = inorder.length-1;
		
		Map<Integer,Integer> inMap =  populateInMap(inorder);
		
		TreeNode root  = buildTreeHelper(inorder, instart, inend, preorder, preStart, preEnd, inMap);
		return root;
	}

	private static TreeNode buildTreeHelper(int[] inorder, int instart, int inend, int[] preorder, int preStart,
			int preEnd, Map<Integer, Integer> inMap) {
	
		
		if (preStart>preEnd || instart>inend) {
			return null;
		}
		
		
		TreeNode root = new TreeNode(preorder[preStart]);
		
		int inRootIndex = inMap.get(root.val);
		int totalElementAtLeftInOrderPresnt = inRootIndex - instart;
		
		
		root.left = buildTreeHelper(inorder, instart, inRootIndex-1,
				preorder, preStart+1, preStart+totalElementAtLeftInOrderPresnt, inMap);
		
		
		root.right = buildTreeHelper(inorder, inRootIndex+1, inend, 
				preorder, preStart+totalElementAtLeftInOrderPresnt+1, preEnd, inMap);
		
		return root;
	}

	private static Map<Integer, Integer> populateInMap(int[] inorder) {
		
		
		Map<Integer,Integer> inMap = new HashMap<Integer, Integer>();
		
		for (int i = 0 ; i < inorder.length ; i ++) {
			
			inMap.put(inorder[i], i); // index of the node at that position.
		}
		// TODO Auto-generated method stub
		return inMap;
	}
	
}

