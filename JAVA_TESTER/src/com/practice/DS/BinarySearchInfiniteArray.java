package com.practice.DS;

public class BinarySearchInfiniteArray {

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,77,88,99,100,122,555,666,789,899,999,1000,1100,1200,1300,1400,1500};
		int key = 122;
		int low = 0 ; 
		int high =1;
		while (arr[high]<key) {
			low = high;
			high = high*2;
		}
		
		int count=0;
		while (low<=high) {
			int mid = (low+high)/2;
			if(key == arr[mid]) {
				System.out.println("found index = "+mid);
				break;
			}
			
			else if (key>arr[mid]) {
				low = mid+1;
				if(arr[low]==key) {
					System.out.println("found index = "+low);
					break;

				}
			}
			else if (key<arr[mid]) {
				high=mid-1;
				if(arr[high]==key) {
					System.out.println("found index = "+high);
					break;

				}
			}
			count++;
		}
		
		System.out.println("Total Counter = "+count);
	}
	
	
	
}
