package com.practice.DS;

public class BinarySearchRotatedArray {

	public static void main(String[] args) {
		int arr[] = {2,2,2,0  ,0,1};
		int key = 0;
		
		int low = 0 ;
		int high=arr.length-1;
		int answerIndex=-1;
		while(low<=high) {
			int mid = (low+high)/2;

            
			if(arr[mid]==key) {
                answerIndex=mid;
                break;
			}
            
            if(arr[low]==key) {
                answerIndex=low;
                break;
			}

            if(arr[high]==key) {
                answerIndex=high;
                break;
			}

            if(arr[mid]==arr[low] && arr[mid]==arr[high]){
                low =low+1;
                high = high-1;
                continue;
            }
			

			
			// Left is sorted - Matlab left is already sorted.
			if(arr[mid]>=arr[low]) { 
				if(key<=arr[mid] && key >=arr[low] ) {
					high=mid-1;
				}
				else {
					low = mid+1;
				}
			}
			
			else {
				if(key>=arr[mid] && key <=arr[high] ) {
					low=mid+1;
				}
				else {
					high = mid-1;
				}
			}

		}
		
		System.out.println(answerIndex);
	} 
}
