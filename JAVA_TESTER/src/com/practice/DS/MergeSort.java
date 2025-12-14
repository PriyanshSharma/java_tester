package com.practice.DS;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = {20,-15,35,7,55,1,-22};
		int n = arr.length-1;
		mergeSortDivide(arr,0,n);
		for (int i : arr) {
			System.out.println(i);
		}
	}
	
	public static void mergeSortDivide (int arr[], int low, int high) {
		
		if (low>=high) {
			return;
		}
		int mid = (low+high)/2;
		mergeSortDivide(arr, low, mid);
		mergeSortDivide(arr, mid+1, high);
		mergeBack(arr, low, mid, high);
	}
	
	public static void mergeBack (int arr[], int low, int mid, int high) {
		
		int left = low;
		int right = mid+1;
		int index=0;
		int tempArr[] = new int [high-low+1];
		while (left<=mid && right <=high) {
			if(arr[left]<arr[right]) {
				tempArr[index++]=arr[left++];
			}
			else {
				tempArr[index++]=arr[right++];

			}
		}
		while (left <=mid) {
			tempArr[index++] = arr[left++];
		}
		while (right <=high) {
			tempArr[index++] = arr[right++];
		}
		
		// Copy this temp array in main array ==
		
		for (int i =0,j=low ;i<tempArr.length ; i++) {
			arr[j++]=tempArr[i];
		}
		
	}
	
	
}
