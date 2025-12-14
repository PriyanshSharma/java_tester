package com.practice.DS;

public class BinarySearchFindMinInRotatedSortedArray {

	
	public static void main(String[] args) {
		int arr[] = {10,20,30,50,1,6,7,8,9};
		System.out.println( new BinarySearchFindMinInRotatedSortedArray().findMin(arr));
	}
	
	
	public int findMin(int[] arr) {
        
		int l = 0 ; 
		int h = arr.length-1;
		int ans = arr[(l+h)/2];
		
		while (l<=h) {
			int mid = (l+h)/2;
			
			ans = Math.min(ans, arr[mid]);
			
			//Left part is sorted
			if(arr[l]<=arr[mid]) {
				ans = Math.min(ans, arr[l]);
				l = mid+1;
			}
			
			else {
				ans=Math.min(ans, arr[mid]);
				
				h=mid-1;
			}
		}
		
		return ans;
    }
}
