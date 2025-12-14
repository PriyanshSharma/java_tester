package com.practice.DS;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class KthLargestandSmallest {

	public static void main(String[] args) {
		int arr[] = {20,10,60,30,50,40};
		

		int k =3;
		
		printKthLargest(arr,k);
		printKthSmallest(arr,k);
		
		
	
	}

	private static void printKthSmallest(int[] arr, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		
		for(int i = 0 ; i <k ; i ++) {
			maxHeap.add(arr[i]);
		}
		
		for (int i = k ; i <arr.length ; i ++) {
			if (maxHeap.peek()>arr[i]) {
				maxHeap.poll();
				maxHeap.add(arr[i]);
			}
		}
		
		System.out.println("K th smallest"+maxHeap.peek());
	}

	private static void printKthLargest(int[] arr, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		for(int i = 0 ; i <k ; i ++) {
			minHeap.add(arr[i]);
		}
		
		for (int i = k ; i <arr.length ; i ++) {
			if (minHeap.peek()<arr[i]) {
				minHeap.poll();
				minHeap.add(arr[i]);
			}
		}
		
		System.out.println("Kth Largext -- "+minHeap.peek());
		
	}
}
