package com.anujbhaiyaquestions;

public class CountmajorityElementsBoyerMoore {

	
	public static void main(String[] args) {
		int arr[] = 
//			{5,1,4,1,1};
			{1,1,1,1,5,5,2,2,2,2,1,1,1};
		
		majorityElementRecursion(arr,1,0,1);
		majorityRecusrion(arr);
	}

	private static void majorityRecusrion(int[] arr) {

			int ansindex = 0 ; 
			int count =1;
			for(int i = 0 ; i < arr.length ; i ++) {
				if(arr[i]==arr[ansindex]) {
					count++;
				}else {
					count--;
				}
				
				if(count==0) {
					System.out.println("Answer index changing for value = "+arr[ansindex]+" at index of i ="+i+" with ansindex = "+ansindex);
					
					ansindex = i ; 
	
					count++;

				}
			}
			System.out.println("count at last -- "+count);
			int majorCount = 0 ;
			for(int i = 0 ; i < arr.length ; i ++) {
				if (arr[ansindex]==arr[i]) {
					majorCount++;
				}
			}
			
			if(majorCount > arr.length/2) {
				System.out.println(arr[ansindex]);
			}
	}

	private static void majorityElementRecursion(int[] arr , int count,int ansIndex, int i) {

		if(i==arr.length) {
			int maxElem = arr[ansIndex];
			int majority =0;
			for(int j = 0 ; i < arr.length ; j++) {
				majority++;
			}
			if(majority> arr.length/2) {
				System.out.println(arr[ansIndex]);
			}
			return ;
		}
		if(arr[i]==arr[ansIndex]) {
			majorityElementRecursion(arr, count+1, ansIndex, i+1);
		}
		else {
			majorityElementRecursion(arr, count-1, ansIndex, i+1);
		}
		
		if(count == 0 ) {
			majorityElementRecursion(arr, count+1, i, i+1);
		}
	}
}
