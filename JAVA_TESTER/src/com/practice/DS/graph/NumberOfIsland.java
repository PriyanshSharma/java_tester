package com.practice.DS.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland {

	
	public static void main(String[] args) {
		char arr[][] = {
				{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}
		};
		new NumberOfIsland().numIslands(arr);		  
	}
	
	public  int numIslands(char[][] grid) {
        int count =0 ; 
        
        int row = grid.length;
        int col = grid[0].length;
        boolean visitedArray [][] = new boolean[row][col];
//        Arrays.fill(visitedArray, false);
        
        for (int i=0 ; i < row ; i++) {
        	for (int j = 0 ; j< col ; j++) {
        		if(grid[i][j]=='1' && !visitedArray[i][j]) {
        			Pair p = new Pair(i, j);
        			bfs(grid,visitedArray,p);
        			count++;
        		}
        	}
        }
        System.out.println(count);
        return count;
    }

	private void bfs(char[][] grid, boolean[][] visitedArray, Pair p) {
		
		Queue<Pair> queue = new LinkedList<Pair>();
		
		queue.add(p);
		int r = grid.length;
		int c = grid[0].length;
		
		while (!queue.isEmpty()) {
			
			Pair pair = queue.poll();
			
			for (int i = -1; i<=1 ; i++) {
				for (int j = -1 ; j<=1 ; j++) {
					int curRow = pair.first()+i;
					int curCol = pair.second()+j;
					
					if ((curRow>=0 && curRow<r) 
							&&
							(curCol>=0 && curCol <c)
							&& (!visitedArray[curRow][curCol])
									&& (grid[curRow][curCol]=='1')) {
						Pair p1 = new Pair(curRow, curCol);
						queue.add(p1);
						visitedArray[curRow][curCol]=true;
					}
				}
			}
		}
		
	}
}

record Pair (int first, int second) {
	
}