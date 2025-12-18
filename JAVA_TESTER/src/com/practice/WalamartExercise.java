package com.practice;


/**
 * 
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two 
 * endpoints of the ith line are (i, 0) and (i, height[i]).
	Find two lines that together with the x-axis form a container, 
	such that the container contains the most water.
	Return the maximum amount of water a container can store.
	Notice that you may not slant the container.
	 Input: height = [1,8,6,2,5,4,8,3,7]
	 				  0 1 2 3 4 5 6 7 8	
	 Output: 49
	 Explanation: The above vertical lines are represented by 
	 array [1,8,6,2,5,4,8,3,7]. 
	 In this case, the max area of water (blue section) the container can contain is 49.
	 */
public class WalamartExercise {

	
	public static void main(String[] args) {
		int arr[] = {1,8,6,2,5,4,8,3,0};
		int answer = findMaxVolumeOfWater(arr);
		
		System.out.println(answer);
	}
	
	
	public static int findMaxVolumeOfWater(int arr[]){
		
		if (arr==null) {
			return -1;
		}
		
		if (arr.length==1) {
			return 0;
		}
		
		int volume = Integer.MIN_VALUE;

		//0 1 2 3 4 5 6 7 8
		//1,8,6,2,5,4,8,3,7
		//  se
		int start=0;
		int end = arr.length-1;
		
		
		while (start<end) {
			
			int width = end-start;
			int height = 0;
			if (arr[start]<arr[end]) {
				height = arr[start];
				start++;
			}
			else {
				height=arr[end];
				end--;
			}
			
			int currVolume = height*width;
			
			volume = Math.max(volume, currVolume);
		}
		
		return volume;
	}
	
}



//TestCase 1 : int arr[] = null; --> -1;
//TestCase 2 : int arr[] ={1} --> 0
//TestCase 3 : int arr[] ={0,0} --> 0
//TestCase 4 : int arr[] = {1,1} -->1
//TestCase 5 : int arr[] = {1,-8,-9,-10}


