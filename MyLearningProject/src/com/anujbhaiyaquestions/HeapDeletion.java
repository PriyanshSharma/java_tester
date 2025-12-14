package com.anujbhaiyaquestions;

import java.util.Arrays;

public class HeapDeletion {

	public static void main(String[] args) {
		int arr [] = {30,20,10,15};
		
//		deleteFromHeap(arr);
		int arrnew[] = new int [arr.length+1];
		
		for(int i = 1 ; i < arrnew.length ; i++) {
			
			arrnew[i] =arr[i-1];
			
		}
		int deletedNode = arrnew[1];
		System.out.println("Deleted Node -- "+deletedNode);
		
		arrnew[1] = arrnew[arr.length];
		
		arrnew = Arrays.copyOf(arrnew, arrnew.length-1);
		heapify(arrnew, 1);
		System.out.println("heap -- >");
		for(int element:arrnew) {
			System.out.println(element);
		}
	}

	private static void heapify(int[] arrnew, int i) {
		
			int left = 2*i;
			int right = left+1;
			int largest=i;
			
			 if(left<=arrnew.length-1 && arrnew[left]>arrnew[largest]) {
				 largest = left;
			 }
			 if(right<=arrnew.length-1 && arrnew[right]>arrnew[largest]) {
				 largest = right;
			 }
			if(largest!=i) {
				swap(arrnew,largest,i);
				heapify(arrnew, largest);
			}
		
		}
	

	private static void swap(int[] arr, int largest, int i) {
		
		int temp  = arr[i];
		arr[i]=arr[largest];
		arr[largest] = temp;
		
	}
}
