package com.practice.DS;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		int arr[] = {2,3,1,3,3}; // 2,3,3,3,1 i=2 = 2,3,1,3,3 = 2,3,3,1,3
		nextPermutation(arr);
//		reverseArray(arr, 5, arr.length-1);
//		System.out.println(Arrays.toString(arr));
	}

	private static void nextPermutation(int[] arr) {

		/*
		 * Algo - 
		 * 1. Find the partition from the end- such that the element of the array 
		 * starts decreasing = ex = 1,3,2,1 = here the element start decreasing from n-4 index
		 * stop there
		 * now since we have the max value if take the number from the partition, 
		 * That is the max number possible from those elements, as those are already in the decreasing order sorter.
		 * Thus now take one more element from left of the partition.
		 * now find out the next larger number than that, jsut the next larger number
		 * swap those two elements
		 * now the Bigger number that was formed earlier from step 1 is still the biggest number from those element
		 * Thus now reverse the number from that parttion, so as to make the largest number smallest and as 
		 * we already swapped with the next available number it will be next in lexicographically sorted number
		 * 
		 */
		
		//Step 1 = Find the partition
		int n=arr.length;
		int i=n-2;
		
			while (i>=0 && (arr[i]>=arr[i+1])) {
				i--;
			}
		
		
		if (i==-1) {
			// just reverse the array as there is no next lexicographically solution available
			reverseArray(arr,0,n-1);
			System.out.println(Arrays.toString(arr));
		}
		else {
			//find the next greatest element than this smaller
			int nextGreater=0;
			int minDiff=Integer.MAX_VALUE;
			int j =i+1;
			for (; j <arr.length ; j++){
				int diff=0;
				if (arr[j]>arr[i]) {
					diff = arr[j]-arr[i];
					if(diff<=minDiff) {
						minDiff=diff;
						nextGreater=j;
						
					}
				}
			}
			swapArrayElems(arr, i, nextGreater);
			
			reverseArray(arr, i+1, n-1);
			
			System.out.println(Arrays.toString(arr));
		}
		
		
	}

	private static void reverseArray(int[] arr, int start, int end) {
		
		
		while (start<end) {
			swapArrayElems(arr,start,end);
			
			start++;
			end--;
		}
		
	}

	private static void swapArrayElems(int[] arr, int start, int end) {
		int temp = arr[end];
		arr[end]=arr[start];
		arr[start]=temp;
		
	}
}
