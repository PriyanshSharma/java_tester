package com.practice.DS;

import java.util.Arrays;

public class HeapExample {

	public static void main(String[] args) {
		int arr[] = {50,40,45,30,20,35,10};
		int elem = 60;
		int arrnew[]=insertElement(arr,arr.length,elem);
		for(int e : arrnew) {
			System.out.println(e);
		}
		
		insertElementSameArray(arr, elem);
		
		int arrNoHeap[] = {20,10,30,5,50,40}; 
		buildHeap(arrNoHeap);
		
		int deletedNode =deleteNodeFromHeap(arrNoHeap, arrNoHeap.length-1);
		
		System.out.println("Deleted Node - "+deletedNode);
		
		System.out.println("Checking heap .. ");
		buildHeap(arrNoHeap);

		heapSort(arrNoHeap);
		
	}
	//Using seperate array
	public static int [] insertElement(int arr[], int n , int element) {
		
		 
		 
		 int i =n+1;
		 int arrnew[] =  new int[arr.length+2];

		 for(int k=0; k<arr.length;k++) {
			 int a=k+1;
			 arrnew[a]=arr[k];
		 }
		arrnew[i]=element;
		 while (i>1) {
			 int parent = i/2;
			 
			 if(arrnew[parent]<arrnew[i]) {
				 swap(arrnew,parent,i);
				 i=parent;
			 }
		 }
		return arrnew;
	}
	
	
	public static void insertElementSameArray(int arr[], int elem) {
		
		int end = arr.length;
		
		int a[] = new int[end+1];
		
		for(int k = 0 ; k<arr.length ; k++) {
			a[k]=arr[k];
		}
		
		a[end]=elem;
		
		while (end>0) {
			int parent = (end)/2;
			
			if(a[parent]<a[end]) {
				swap(a, parent, end);
				end=parent;
			}
		}
		for (int i : a)
			System.out.println(i);
		}
	
	private static void swap(int[] arrnew, int parent, int i) {
		int temp = arrnew[parent];
		arrnew[parent]=arrnew[i];
		arrnew[i]=temp;
		
	}
	
	public static void buildHeap (int arr[]) {
		System.out.println("Before heap creation - "); // --> {20,10,30,5,50,40}
		System.out.println(Arrays.toString(arr));
		int n =(arr.length/2)-1;
		for(int i = n;i>=0;i--) {
			heapify(arr, i);
		}
		System.out.println("Heap Created .. "); //--> {50, 20, 40, 5, 10, 30}
		System.out.println(Arrays.toString(arr));
	}
	
	public static void heapify(int arr[],int i) {
		int left = (2*i) +1;
		int right = (2*i)+2;
		int maxIndex =i;
		 if (left < arr.length && arr[left] > arr[maxIndex]) {
			 maxIndex = left;
	        }
	      if (right < arr.length && arr[right] > arr[maxIndex]) {
	        	maxIndex = right;
	        }
		if(arr[maxIndex]>arr[i]) {
			swap(arr, maxIndex, i);
			heapify(arr, maxIndex);
		}
	}
	
	
	public static void heapSort(int arr[]) {
		System.out.println("Sorted Array -- ");
		int n = arr.length-1;
		for(int i = 0 ; i < arr.length; i ++) {
			System.out.print(" "+deleteNodeFromHeap(arr,n));
			n--;
		}
	}
	
	public static int deleteNodeFromHeap(int arr[], int n) {
		
		int deletedNode =arr[0];
		arr[0]=arr[n];
		arr[n]=Integer.MIN_VALUE;
		int i =0;
		
		heapify(arr, i);
		
		return deletedNode;
	}
}
