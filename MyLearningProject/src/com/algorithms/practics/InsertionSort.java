package com.algorithms.practics;

public class InsertionSort {
 public static void main(String[] args) {
	 int[] a = {20,35,-15,7,55,1,-22};

	 for(int unsortedArryIndex = 1 ; unsortedArryIndex<a.length;unsortedArryIndex++) {
		 
		 int i;
		 int elementInserted = a[unsortedArryIndex];
		 for(i = unsortedArryIndex ; i>0 && a[i-1]>elementInserted;i--) {
			 a[i]=a[i-1];
		 }
		 a[i]=elementInserted;
		 
	 }
	 
	 for(int a1: a) {
		 System.out.println(a1);
	 }
}
}
