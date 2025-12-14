package com.practice.DS;

import java.util.Comparator;
import java.util.PriorityQueue;



public class MergeKSortedList {

	
	public static void main(String[] args) {
		/**
		 *  { 10, 20, 30, 40 },
        { 15, 25, 35, 45 },
        { 27, 29, 37, 48 },
        { 32, 33, 39, 50 },
		 */
		
		int arr[][] = {
						{ 10, 20, 30, 40 },
						{ 15, 25, 35, 45 },
						{ 27, 29, 37, 48 },
						{ 32, 33, 39, 50 }
						
						};
		
		new MergeKSortedList().mergeKSorted2DArray(arr);
	}
	
	
	public void mergeKSorted2DArray(int arr[][]) {
		
		PriorityQueue<HeapNode> minHeap = new PriorityQueue<HeapNode>(Comparator.comparing(hn->hn.element()));
		int n = arr.length;
		
		for (int i = 0 ; i < n ; i++) {
			HeapNode h = new HeapNode(arr[i][0], i, 0);
			minHeap.add(h);
		}
		
		
		
		while(!minHeap.isEmpty()) {
			
			HeapNode minNode = minHeap.poll();
			
			
			int row = minNode.i();
			int col = minNode.j();
			
			System.out.print(minNode.element()+" ");
			if (col+1<n) {
				int nextElement = arr[row][col+1];
				HeapNode nextNode = new HeapNode(nextElement, row, col+1);
				minHeap.add(nextNode);
			}
			
			
			
		}
		
		
	}
	
	public void mergeKSortedArray(int arr[]) {
		
	}
}



record HeapNode (int element, int i, int j) {}
