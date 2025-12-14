package com.practice.DS;

import java.util.Objects;

public class TreeNode {

	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;
	
	public TreeNode (int data) {
		this.val=data;
		
	}

	@Override
	public String toString() {
		return val+"";
	}

	@Override
	public int hashCode() {
		return Objects.hash(val, left, right);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TreeNode other = (TreeNode) obj;
		return val == other.val && Objects.equals(left, other.left) && Objects.equals(right, other.right);
	}
	
	
}
