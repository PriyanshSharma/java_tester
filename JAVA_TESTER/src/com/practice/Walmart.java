package com.practice;

import java.util.ArrayList;
import java.util.List;

import com.practice.DS.TreeNode;

public class Walmart {

	public static void main(String[] args) {
		// Node n1, Node n2
		// root - given.
		
		
		TreeNode node1=null ;
		TreeNode node2 =null;
		
		TreeNode root = null;
		
		getLCA(node1, node2, root);
		
	
	}
	
	
	public static TreeNode getLCA(TreeNode n1, TreeNode n2, TreeNode root) {
		
		if(root==null) {
			return null;
		}
		
		
		// NLR ==
		
//		if(root.data == n1.data || root.data==n2.data) {
//			
//			return root;
//		}
		
		
		if(n1.parent== n2.parent) {
			
			return n1.parent;
		}
		
		List<TreeNode> parentList = new ArrayList<TreeNode>();
		
		
		TreeNode leftNode = getLCA(n1, n2, root.left);
		TreeNode rigthNode = getLCA(n1, n2, root.right);
		
		
		if(leftNode==null) {
			return rigthNode;
		}
		
		if (rigthNode==null) {
			return leftNode;
		}
		
		
		return root;
	}
}
