package com.practice.DS;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
 * Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

	You can return the answer in any order.
 */
public class BinaryTreePrintAllNodesAtDistanceKFromGivenTargetNode {

	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(5);
		node.right = new TreeNode(1);
		
		node.left.left = new TreeNode(6);
		node.left.right = new TreeNode(2);
		node.left.right.left = new TreeNode(7);
		node.left.right.right = new TreeNode(4);
		
		
		node.right.left = new TreeNode(0);
		node.right.right = new TreeNode(8);
		
		TreeNode target = node.left;
		
		
		System.out.println(
		new BinaryTreePrintAllNodesAtDistanceKFromGivenTargetNode().distanceK(node, target, 2));
		
		// Un Comment incase u have the doubt of why not normal BFS traversal ----
//		new BinaryTreePrintAllNodesAtDistanceKFromGivenTargetNode().distanceKwithOutForLoop(node, 2, target);
		
	}
	
	
	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
		List<Integer> resultant = new ArrayList<Integer>();
		Map<TreeNode, TreeNode> parentMap = getParentMap(root);
		Map<TreeNode,Boolean> visitedMap = new HashMap<TreeNode, Boolean>();
		Queue<TreeNode> bfsQ = new LinkedList<TreeNode>();
		
		
		bfsQ.add(target);
		visitedMap.put(target,true);
		int currentLevel=0;
		while (!bfsQ.isEmpty()) {
			
			if (currentLevel==k) {
				break;
			}
			
			
			int size = bfsQ.size();
			currentLevel++;
			for (int i = 0 ; i < size ; i ++) {
				TreeNode node = bfsQ.poll();
				
				if (node.left!=null && visitedMap.get(node.left)==null) {
					bfsQ.add(node.left);
					visitedMap.put(node.left, true);
				}
				if (node.right!=null && visitedMap.get(node.right)==null) {
					bfsQ.add(node.right);
					visitedMap.put(node.right, true);
				}
				
				if (parentMap.get(node)!=null && visitedMap.get(parentMap.get(node))==null) {
					bfsQ.add(parentMap.get(node));
					visitedMap.put(parentMap.get(node), true);
				}
			}
		}
		
		
		
		while (!bfsQ.isEmpty()) {
			resultant.add(bfsQ.poll().val);
		}
		
		
		return resultant;
    }
	
	private Map<TreeNode, TreeNode> getParentMap(TreeNode root){

		//BFS traverssal and store the parent for every popped out child.
		
		Map<TreeNode, TreeNode> parentMap = new HashMap<TreeNode, TreeNode>();
		
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		queue.add(root);
		
		while (!queue.isEmpty()) {
			
			TreeNode popedOut = queue.poll();
			
			if (popedOut.left!=null) {
				
				queue.add(popedOut.left);
				parentMap.put(popedOut.left, popedOut);
				
			}
			
			if (popedOut.right!=null) {
				queue.add(popedOut.right);
				parentMap.put(popedOut.right, popedOut);
			}
		}
		
		
		return parentMap;
		
		
		
		
		
		
	}
	
	
//	public void distanceKwithOutForLoop(TreeNode root, int k, TreeNode target) {
//		
//		List<Integer> resultant = new ArrayList<Integer>();
//		Map<TreeNode, TreeNode> parentMap = getParentMap(root);
//		Map<TreeNode,Boolean> visitedMap = new HashMap<TreeNode, Boolean>();
//		Queue<TreeNode> bfsQ = new LinkedList<TreeNode>();
//		
//		
//		bfsQ.add(target);
//		visitedMap.put(target,true);
//		int currentLevel=0;
//		while (!bfsQ.isEmpty()) {
//			
//			if (currentLevel==k) {
//				break;
//			}
//			
//			
//			int size = bfsQ.size();
//			currentLevel++;
//			
//			TreeNode node = bfsQ.poll();
//				
//				if (node.left!=null && visitedMap.get(node.left)==null) {
//					bfsQ.add(node.left);
//					visitedMap.put(node.left, true);
//				}
//				if (node.right!=null && visitedMap.get(node.right)==null) {
//					bfsQ.add(node.right);
//					visitedMap.put(node.right, true);
//				}
//				
//				if (parentMap.get(node)!=null && visitedMap.get(parentMap.get(node))==null) {
//					bfsQ.add(parentMap.get(node));
//					visitedMap.put(parentMap.get(node), true);
//				}
//			}
//		
//		while (!bfsQ.isEmpty()) {
//			resultant.add(bfsQ.poll().data);
//		}
//		
//	}
}
