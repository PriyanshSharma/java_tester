package com.algorithms.practics;

public class CustomTree {

	TreeNode root;
	
	public void insert(int data ) {
		if(root == null) {
			
			root= new TreeNode(data);
		}
	}

class TreeNode {
	public int data ;
	TreeNode left;
	TreeNode right;
	public TreeNode(int data) {

		this.data = data;
	} 
	public void insertRecusrsive(int val) {
		
		// case of duplication for the node to be inserted
		if(val == this.data) {
			return;
		}
		if(val<data) {
			if(left ==null) {
				left = new TreeNode(val);
			}
			else {
				left.insertRecusrsive(val);
			}
		}
		else {
			if(val>data) {
				if(right==null) {
					right = new TreeNode(val);
				}
				else {
					right.insertRecusrsive(val);
				}
			}
		}
		
	}
	
	}

	public static void main(String[] args) {
		CustomTree tree = new CustomTree();
//		tree.
	}
	}
