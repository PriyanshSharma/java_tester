package com.practice.DS;

public class PeakElement {

	public static void main(String[] args) {
		
		int arr[] = //{1,2,0,4,5,6,7,8,9,11,12};
				{1,2,3,4,10,9,11,12,13,14,15,16,17};
		int index = new PeakElement().findPeakElement(arr);
		System.out.println(index);
	}
	
	public int findPeakElement(int[] arr) {
	        int low = 0;
	        int high = arr.length - 1;

	        while (low <= high) {
	            int mid = low + (high - low) / 2;

	            boolean leftOK = (mid == 0 || arr[mid] >= arr[mid - 1]);
	            boolean rightOK = (mid == arr.length - 1 || arr[mid] >= arr[mid + 1]);

	            if (leftOK && rightOK) {
	                // Found a peak
	                return mid;
	            } else if (mid > 0 && arr[mid - 1] > arr[mid]) {
	                // Move left
	                high = mid - 1;
	            } else {
	                // Move right
	                low = mid + 1;
	            }
	        }

	        return -1; // Should never happen if array has at least one element
	    
}
}
