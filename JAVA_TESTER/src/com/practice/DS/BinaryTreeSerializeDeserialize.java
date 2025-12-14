package com.practice.DS;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Leetcode = http://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 */
public class BinaryTreeSerializeDeserialize {

	public static void main(String[] args) {
		
	}
	
	
	
	 public String serialize(TreeNode root) {
	        
		 if (root ==null) {
			 return null;
		 }
		 
		 Queue<TreeNode> q = new LinkedList<TreeNode>();
		 StringBuilder res = new StringBuilder();
		 
		 
		 q.add(root);
		 
		 while (!q.isEmpty()) {
			 
			 TreeNode node = q.poll();
			 
			 if (node==null) {
				 res.append("n");
				 res.append(",");
				 continue;
			 }
			 
			
			 q.add(node.left);
			 
			 res.append(node.left.val);
			 res.append(",");
			 
			 q.add(node.right);
			 res.append(node.right.val);
			 res.append(",");
			 
		 }
		 
		 return res.toString();
		 
	    }

	    // Decodes your encoded val to tree.
	    public TreeNode deserialize(String data) {
	        
	    	String [] arr = data.split(",");
	    	Queue<TreeNode> q = new LinkedList<TreeNode>();
	    	
	    	TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
	    	q.add(root);
	    	
	    	for (int i = 1 ; i < arr.length ; i ++) {
	    		
	    		TreeNode parent = q.poll();
	    		
	    		if (arr[i]!="n") {
	    			TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
	    			q.add(left);
	    			parent.left = left;
	    		}
	    		
	    		if (arr[++i]!="n") {
	    			TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
	    			q.add(right);
	    			parent.right = right;
	    		}
	    	
	    	}
	    	
	    	return root ;
	    }
	
}
