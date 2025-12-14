package com.practice.DS;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRootToGivenNodePath {

	public static void main(String[] args) {
		
		
		 TreeNode root = new TreeNode(3);
	        root.left = new TreeNode(5);
	        root.right = new TreeNode(1);
	        root.left.left = new TreeNode(6);
	        root.left.right = new TreeNode(2);
	        root.right.left = new TreeNode(0);
	        root.right.right = new TreeNode(8);
	        root.left.right.left = new TreeNode(7);
	        root.left.right.right = new TreeNode(4);
	        
	        int targetLeafValue = 0;

	        List<Integer> path = new ArrayList<Integer>();
	        		new BinaryTreeRootToGivenNodePath().isPossiblePathFound(root, targetLeafValue,path );
	        		
	        System.out.println(path);
	        
	        TreeNode node1 = new TreeNode(1);
			node1.left = new TreeNode(2);
			node1.right = new TreeNode(2);
			
			node1.left.left = new TreeNode(3);
			node1.left.right = new TreeNode(4);
			
			node1.right.left = new TreeNode(4);
			node1.right.right = new TreeNode(3);
	        
	        List<Integer> l = new ArrayList<Integer>();
	        pathToNode(root, 7, l);

	        System.out.println("value -- "+l);
	}
	
	public boolean isPossiblePathFound(TreeNode root, int x , List<Integer> result) {
		
		if (root == null) {
			return false;
		}
		
		result.add(root.val);
		
		if (root.val==x) {
			return true;
		}
		
		
		else {
			
			boolean leftFound = isPossiblePathFound(root.left, x, result);
			boolean rightfound = isPossiblePathFound(root.right, x, result);
			
			if (leftFound==false && rightfound==false) {
				result.remove(result.size()-1);
			}
			else {
				
				return true;
			}
			
			
		}
		
		return false;
		
	}
	
	public static boolean pathToNode(TreeNode root, int target, List<Integer> results) {
		
		if (root == null) {
			
			return false;
		}
		
		System.out.println("Calling for == "+root.val);
		results.add(root.val);
		if (root.val==target) {
			System.err.println(results);
			return true;
		}
		
		boolean right =false;
		
		boolean left =pathToNode(root.left, target, results);
		if(!left) {
			 right = pathToNode(root.right, target, results);
		}
		
		
		if (left || right) {
			
			return true;
		}
		
		results.remove(results.size()-1);
		
		return false;
	}
}
