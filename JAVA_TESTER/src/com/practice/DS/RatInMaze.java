package com.practice.DS;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Consider a rat placed at position (0, 0) in an n x n square matrix mat[][]. The rat's goal is to reach the destination at position (n-1, n-1). The rat can move in four possible directions: 'U'(up), 'D'(down), 'L' (left), 'R' (right).

The matrix contains only two possible values:

0: A blocked cell through which the rat cannot travel.
1: A free cell that the rat can pass through.
Your task is to find all possible paths the rat can take to reach the destination, 
starting from (0, 0) and ending at (n-1, n-1), under the condition that the rat cannot revisit any cell along the same path. Furthermore, the rat can only move to adjacent cells that are within the bounds of the matrix and not blocked.
If no path exists, return an empty list.

Note: Return the final result vector in lexicographically smallest order.

Examples:

Input: mat[][] = [[1, 0, 0, 0], [1, 1, 0, 1], [1, 1, 0, 0], [0, 1, 1, 1]]
Output: ["DDRDRR", "DRDDRR"]
Explanation: The rat can reach the destination at (3, 3) from (0, 0) by two paths -
 DRDDRR and DDRDRR, when printed in sorted order we get DDRDRR DRDDRR.
Input: mat[][] = [[1, 0], [1, 0]]
Output: []
Explanation: No path exists as the destination cell is blocked.
Input: mat = [[1, 1, 1], [1, 0, 1], [1, 1, 1]]
Output: ["DDRR", "RRDD"]
Explanation: The rat has two possible paths to reach the destination: 
1. "DDRR" 2. "RRDD", These are returned in lexicographically sorted order.
 */
public class RatInMaze {

	public static void main(String[] args) {
		int mat[][] = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
		new RatInMaze().ratInMaze(mat);
	}
	
	 public ArrayList<String> ratInMaze(int[][] maze) {
	        
		 	ArrayList<String> list = new ArrayList<String>();
		 	int visited[][] = new int[maze.length][maze.length];
		 	
		 	getRatInMazePath(maze,0,0,list,maze.length,visited,"");
		 	System.out.println(list);
		 	return list;
	        
	    }

	private void getRatInMazePath(int[][] maze, int row, int col, ArrayList<String> list, int n, int[][]visited, String ans) {

		
			if (row==n-1 && col==n-1) {
				list.add(ans);
				return;
			}
				
				//Down
				if (row+1<n) {
					if (ifNextMovePossible(maze,row+1,col,visited)) {
						
						visited[row+1][col]=1;
						getRatInMazePath(maze, row+1, col, list,n,visited,ans+'D');
						visited[row+1][col]=0;
						
						
						
					}
				}
				
				//left
				if(col-1>=0) {
					if (ifNextMovePossible(maze,row,col-1,visited)) {
						
						
						visited[row][col-1]=1;
						getRatInMazePath(maze, row, col-1, list,n,visited,ans+'L');
						visited[row][col-1]=0;
						
					}
				}
				//right
				if(col+1<n) {
					if (ifNextMovePossible(maze,row,col+1,visited)) {
						
						visited[row][col+1]=1;
						getRatInMazePath(maze, row, col+1, list,n,visited,ans+'R');
						visited[row][col+1]=0;
					}
				}
				
				
				//Up
				if (row-1>=0) {
					if (ifNextMovePossible(maze,row-1,col,visited)) {
						
						visited[row-1][col]=1;
						getRatInMazePath(maze, row-1, col, list,n,visited,ans+'U');
						visited[row-1][col]=0;
						
					}
				}
				
				
			}

	private boolean ifNextMovePossible(int[][] maze, int row, int col, int[][]visited) {
		return maze[row][col]==1 && visited[row][col]==0;
	}
}






























