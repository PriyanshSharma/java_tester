package com.anujbhaiyaquestions;

public class BinarySearchRotatedArray {
	
	public static void main(String[] args) {
		int arr[] = {120,130,40,50,60,90};
		
		int low = 0 ;
		int high  = (arr.length) - 1;
		int value = 50;
		
		while (low<=high) {
			int mid = (low+high)/2;
		
		if(arr[mid]==value) {
			System.out.println("Found at -- > "+mid);
			break;
		}
		
			// I am going to left side;
			if(arr[low]<arr[mid]) {
				
				if(value>=arr[low] && value<arr[mid] ) {
					high = mid-1;
				}
				else {
					low = mid+1;
				}
			}
			
			else {
				if(value>arr[mid] && value<=high) {
					low = mid+1;
				}
				else {
					high = mid-1;
				}
			}
		}
		
		
	}
	
	
	
}
