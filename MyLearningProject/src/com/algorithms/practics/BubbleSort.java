package com.algorithms.practics;

public class BubbleSort {
	public static void main(String[] args) {
		
		int[] arr = new int[7];
		
		arr[0]=20;
		arr[1]=-15;
		arr[2]=35;
		arr[3]=7;
		arr[4]=55;
		arr[5]=1;
		arr[6]=-22;
		
		
		
		for(int n=0;n<arr.length;n++) {
			int sortedArrayIndex = arr.length;
			for(int i=0 ;i<sortedArrayIndex-1;i++) {
				if(arr[i]>arr[i+1]) {
//					swap 
					int temp =arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=temp;
				}
				
			}
			sortedArrayIndex--;
		}
		for(int a: arr) {
			System.out.println(a);
		}
	}

}
