package com.algorithms.practics;

public class BinarySearchAlgoEx {
public static void main(String[] args) {
	int[] arr = {1,2,3,4,5,6,7,8,9};
	int elemtoSearch=9;
	
	int start =0;
	int end = arr.length-1;
	
	int mid = start+end /2;
	
	binarySearch(arr,mid,start,end,elemtoSearch);
}

private static void binarySearch(int[] arr, int mid,int start, int end, int elemtoSearch) {
	
	if(elemtoSearch==arr[mid]) {
		System.out.println("Found at index === "+mid);
		return;
	}
	if(elemtoSearch>arr[mid]) {
		start = mid;
		
	}
	else if (elemtoSearch<arr[mid]){
		end = mid;
	}
	mid = (start+end)/2;
	binarySearch(arr, mid,start,end, elemtoSearch);
}
}
