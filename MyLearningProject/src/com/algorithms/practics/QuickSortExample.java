package com.algorithms.practics;

import java.util.stream.Stream;

public class QuickSortExample {

	public static void main(String[] args) {
		int [] arr = {4,6,2,5,7,9,1,3};
		
//		quickSort(arr,0,arr.length-1);
		quickSortCustom(arr, 0, arr.length-1);
		for(int a :arr) {
			System.out.println(a);
		}
	}

	private static void quickSort(int[] arr, int start, int end) {

		if(start<end) {
			int pivotIndex = partition(arr,start,end);
			quickSort(arr, start, pivotIndex-1);
			quickSort(arr, pivotIndex+1, end);
		}
		else 
			return;
		
	}

	private static int partition(int[] arr, int start, int end) {

		int pivotElement = arr[start];
		int i = start;
		int j = end;
		
		while(i<j) {
			while(arr[i]<=pivotElement)i++;
			while(arr[j]>pivotElement)j--;
			
			if(i<j) {
				
				// To swap values bigger at left with the value lesses at right
				swap(arr,i,j);
			}
			
			
		}
		
		// to swap pivot to its actual position, thus pivot will be sorted at its original position
		swap(arr,j,start);
		
		return j;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp=arr[i];
		
		arr[i]=arr[j];
		arr[j]=temp;
		
	}
	
	
	
	
	public static void quickSortCustom (int arr[] , int start, int end) {
		
		if(start<end ) {
			
			int pivotIndex = partionMyArray (arr, start,end);
			quickSort(arr, start, pivotIndex-1);
			quickSort(arr, pivotIndex+1, end);
		}
		
	}
	
	public static int partionMyArray(int arr[] , int start , int end) {
		int pivot = arr[start];
		
		int i = start; 
		int j = end;
		
		while (i<j) {
			while (arr[i]<=pivot) {
				i++;
			}
			while (arr[j]>pivot) {
				j--;
			}
			if(i<j) {
				swap(arr, i, j);
			}
		}
		swap(arr, start, j);
		return j;
		
	}
}
