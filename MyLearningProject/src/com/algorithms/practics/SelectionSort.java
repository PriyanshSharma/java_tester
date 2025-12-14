package com.algorithms.practics;

public class SelectionSort {
	public static void main(String[] args) {

		int[] a = {20,35,-15,7,55,1,-22};

		selectionSortOtherLoop(a);
//		selectionSortUdemyLoop(a);
		
		

		
		
	}

	private static void selectionSortUdemyLoop(int[] a) {

		
		for(int sortedArray = a.length-1; sortedArray>0;sortedArray--) {	

		int largest = 0;
		for(int i =1;i<=sortedArray;i++) {
			if(a[i]>a[largest]) {
				largest=i;
			}
		}
		// swap larges and last unsortedArrayindex larges<->a[sortedArray]

			int temp = a[sortedArray];
			a[sortedArray]=a[largest];
			a[largest]=temp;
	}
	for(int i : a) {
		System.out.println(i);
	}

		
	}

	private static void selectionSortOtherLoop (int[] a){
		int lastunsorted = a.length-1;
		
		while(lastunsorted>0) {
			int largestIndex = 0 ;
			for(int j =1 ; j <=lastunsorted ; j++) {
				
				if(a[j]>a[largestIndex]) {
					///swap
					largestIndex=j;
				
				}
			}
			int temp = a[lastunsorted];
			a[lastunsorted]=a[largestIndex];
			a[largestIndex]=temp;
			lastunsorted--;
		}
			
	for(int i : a) {
			System.out.println(i);
		}
	}
	}
