package com.anujbhaiyaquestions;

public class BinarySearchInInfiniteArray {
	public static void main(String[] args) {
		int [] infiniteArray = {1,2,3,4,5,6,7,8,9,34,53,67,78,89,90,100,111,222,333,444,555,666,777,888,1000,1234,2343,3456,4567,5765,6786,7898,8567,9876,10345,11456};
		
		
		int key = 4561;
		
		int low = 0 ; 
		int high =1;
		while (infiniteArray[high]<key) {
			low =high;
			high = 2*high;
		}
		 System.out.println(binarySearch(infiniteArray,low,high,key));
		
	}

	private static boolean binarySearch(int[] infiniteArray, int low, int high,int key) {
		// TODO Auto-generated method stub
		int mid = (low+high )/2;
		
		if(infiniteArray[mid]==key) {
			return true;
		}
		
		if(infiniteArray[mid]<key) {
			low = mid+1;
		}else {
			high = mid-1;
		}
		
		return binarySearch(infiniteArray, low, high, key);
	}
	
}
