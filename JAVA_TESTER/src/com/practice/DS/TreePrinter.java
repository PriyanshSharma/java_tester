package com.practice.DS;

import java.util.ArrayList;
import java.util.List;

public class TreePrinter {

	 private static void printTree(TreeNode root, String prefix, boolean isLeft) {
	        if (root == null) return;

	        // Print current node
	        System.out.println(prefix + (isLeft ? "├── " : "└── ") + root.val);

	        // Adjust prefix for children
	        String newPrefix = prefix + (isLeft ? "│   " : "    ");

	        // Print left and right subtrees
	        printTree(root.left, newPrefix, true);
	        printTree(root.right, newPrefix, false);
	    }

	    // Helper method to start printing from root
	    public static void printTree(TreeNode root) {
	        if (root != null) {
	            System.out.println(root.val); // Print root
	            printTree(root.left, "", true);
	            printTree(root.right, "", false);
	        }
	    }
}
