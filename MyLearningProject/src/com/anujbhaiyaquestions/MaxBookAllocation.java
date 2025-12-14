package com.anujbhaiyaquestions;

public class MaxBookAllocation {
	
	public static void main(String[] args) {
		int arr [] = {10,10,20,30};
		
		int low = getMax(arr);
		int high = sumArray(arr);
		int result =0;
		
		int totalStudents =2;
		while (low<=high) {
			int mid = (low+high) /2;
			
			if(isFeasible(arr,mid,totalStudents)) {
				result = mid;
				high = mid-1;
			}else {
				low = mid+1;
			}
		}
		
		System.out.println(result);
	}
	
	private static boolean isFeasible(int[] arr, int mid, int totalStudents) {
		
		int maxBoolAllocation =0;
		int studentReq =1;
		
		
		for(int i = 0; i < arr.length ; i++) {
			
			if(maxBoolAllocation + arr[i]>mid) {
				studentReq++;
			}
			else {
				maxBoolAllocation = maxBoolAllocation+arr[i];
			}
		}
		return studentReq<=totalStudents;
	}

	private static int sumArray(int[] arr) {
		int sum =0;
		for(int i : arr) {
			sum += i;
		}
		return sum;
	}

	private static int getMax(int arr[]) {
		int max=0;
		for(int i = 0 ; i < arr.length; i++) {
			if(max<arr[i]) {
				max=arr[i];
			}
		}
		
		return max;
	}
}
