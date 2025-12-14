package com.practice.DS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class BinaryTreeCreation {

	
	public static void main(String[] args) {
		int arr [] = {2,4,1,7,10,4,-1,6,-1,-1,-1,-1,-1,-1,-1};
		
		TreeNode root =
		createMyTree(arr, 0);
		
		System.out.println(root.val);
		createTreeInOrder(root);
		System.out.println("Max Height = "+heightOfTree(root));
		System.out.println("Total size = "+getSize(root));
		System.out.println("Level Order traversal .. ");
		printLevelOrdertraversal(root);
		System.out.println("Left view -- ");
		List<Integer> list = new ArrayList<Integer>(15);
		list =printLeftView(root, list,0);
		System.out.println(list);
		System.out.println("PRint top view -== ");
		printTopView(root);
		
		System.out.println("PRint top view using record -== ");
		printTopViewUsingRecord(root);
		
	}
	
	
	
	private static void printTopView(TreeNode root) {
		// TODO Auto-generated method stub
		
		
		Map<Integer,Integer> mapper = new TreeMap<Integer,Integer>();
		Queue<Pair> q = new ArrayDeque<Pair>();
		
		// startLevelorder traversing
		
		if(root==null) {
			System.out.println("null");
			return;
		}
		Pair p = new Pair(0, root);
		q.add(p);
		
		while (!q.isEmpty()) {
			
			Pair poppedOut = q.poll();
			
			
			if(!mapper.containsKey(poppedOut.hd)) { // remove condition check for bottomview.
				mapper.put(poppedOut.hd, poppedOut.node.val);
			}
			if(poppedOut.node.left!=null) {
				q.add(new Pair(poppedOut.hd-1,poppedOut.node.left));

			}
			if(poppedOut.node.right!=null) {
				q.add(new Pair(poppedOut.hd+1,poppedOut.node.right));

			}
		}
	
		System.out.println(mapper);
	}
	



	public static void createTreeInOrder(TreeNode node) {
		
		if (node==null) {
			return ;
		}
		
		createTreeInOrder(node.left);
		System.out.print(node.val+" ");
		createTreeInOrder(node.right);
	}
	
	
	public static TreeNode createMyTree(int arr[],int i ) {
		
		
		int data = arr[i];
		System.err.println("i="+i);
		if (data==-1 || i >=arr.length) {
			return null;
		}
		
		TreeNode root = new TreeNode(data);
		
		if (2 * i + 1 < arr.length) {
            root.left = createMyTree(arr, 2 * i + 1);
        }
        if (2 * i + 2 < arr.length) {
            root.right = createMyTree(arr, 2 * i + 2);
        }
		return root;
	}
	
	public static int heightOfTree(TreeNode root) {
		
		if (root==null) {
			return 0;
		}
		
				
		return Math.max(heightOfTree(root.left), heightOfTree(root.right))+1;
	}
	
	public static int getSize(TreeNode root) {
		if (root==null) {
			
			return 0;
		}
		
		return getSize(root.left)
				+
				getSize(root.right)
				+1;
	}
	
	public static void printLevelOrdertraversal(TreeNode root) {
		
		if(root==null) {
			System.out.println("null");
		}
		
		Queue<TreeNode> q = new ArrayDeque<>();
		
		q.add(root);
		TreeNode popNode=null;
		while (!q.isEmpty()) {
			popNode=q.poll();
			System.out.println(popNode.val);
			
			if(popNode.left!=null) {
				q.add(popNode.left);  // Skip if right view is needed only

			}
			if (popNode.right!=null) {
				q.add(popNode.right); // Skip if left view is needed only

			}
		}
	}
	// Approach 2
	public static List<Integer> printLeftView(TreeNode root, List<Integer>list, int levelOrder) {
		
		
		if (root==null) {
			return null;
		}
		//[2, 4, 7, 6]
		if(levelOrder==list.size()) {
			list.add(root.val);
		}
		
		
		
		
		// reverse the order fr right view of the list
		printLeftView(root.left, list, levelOrder+1);
		printLeftView(root.right, list, levelOrder+1);
		
		return list;
		
	}
	
	public static void printTopViewUsingRecord(TreeNode root) {
		
		Map<Integer,Integer> mapper = new TreeMap<Integer,Integer>();
		Queue<RPair> q = new ArrayDeque<RPair>();
		
		// startLevelorder traversing
		
		if(root==null) {
			System.out.println("null");
			return;
		}
		RPair p = new RPair(0, root);
		q.add(p);
		
		while (!q.isEmpty()) {
			
			RPair poppedOut = q.poll();
			
			
			if(!mapper.containsKey(poppedOut.hd())) { // remove condition check for bottomview.
				mapper.put(poppedOut.hd(), poppedOut.node().val);
			}
			if(poppedOut.node().left!=null) {
				q.add(new RPair(poppedOut.hd()-1,poppedOut.node().left));

			}
			if(poppedOut.node().right!=null) {
				q.add(new RPair(poppedOut.hd()+1,poppedOut.node().right));

			}
		}
	
		System.out.println(mapper);
	}
}


class Pair{
	int hd;
	TreeNode node;
	
	public Pair(int hd, TreeNode node){
		this.hd=hd;
		this.node=node;
	}
}



 record RPair(int hd, TreeNode node) {}
