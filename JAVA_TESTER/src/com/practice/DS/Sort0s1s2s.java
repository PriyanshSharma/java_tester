package com.practice.DS;

import java.util.Arrays;
import java.util.StringJoiner;

public class Sort0s1s2s {

	public static void main(String[] args) {
		
		int arr[] = {0,0,0,1,1,2,2,2,1,1,0,0,2,1,0};
		
		sortAndPerform(arr);
		
		twoPassPerform(arr);
		
		dutchFlagImplementation(arr);
	}
	
	public static void sortAndPerform(int arr[]) {
		// O(nlogn)
		
		Arrays.sort(arr);
		
		System.out.println(Arrays.toString(arr));
	}
	
	public static void twoPassPerform(int arr[]) {
		
		int zerocount=0,oneCount=0,twoCount=0;
		
		for(int i : arr) {
			if (i==0) {
				zerocount++;
			}
			
			else if (i==1) {
				oneCount++;
			}
			else if (i==2) {
				twoCount++;
			}
		}
		StringJoiner joiner = new StringJoiner(" ,");
		for (int i = 0 ; i<zerocount;i++) {
			joiner.add("0");
			
		}
		for (int i = 0 ; i<oneCount;i++) {
			joiner.add("1");
		}
		for (int i = 0 ; i<twoCount;i++) {
			joiner.add("2");
		}
		
		System.out.println(joiner.toString());
	}
	
	public static void dutchFlagImplementation(int arr[]) {
		
		
		int low=0;
		int mid=0;
		int high = arr.length-1;
		
		while (mid<=high) {
			if(arr[mid]==0) {
				swap(arr, mid, low);
				mid++;
				low++;
			}
			
			else if(arr[mid]==1) {
				mid++;
			}
			else {
				swap(arr, mid, high);
				high--;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	private static void swap(int[] arrnew, int parent, int i) {
		int temp = arrnew[parent];
		arrnew[parent]=arrnew[i];
		arrnew[i]=temp;
		
	}
	
}
