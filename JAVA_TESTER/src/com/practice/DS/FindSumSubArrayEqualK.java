package com.practice.DS;

import java.util.HashMap;
import java.util.Map;

/*
 * Variation 1 - Find the sub-array whose sum of elements is =k (given)- Current solution - 
 * Though we can also find all the sub-Arrays
 * And with that we can able to get the max-sum sub array or the min-sum sub array
 * 
 * Idea - to use the map to store the prefix sum and get the complement value from it.	
 *
 * ----------------------------------------
 * <---------n-1-------------------------->
 * <---------prefixSum----------->
 * <--prefix-k------><------k---->	
 * 
 * thus here we have prefix - that we are calculating.
 * K we have. so we can keep a track of complement and keep looking for the same in map.
 * If not found put back the prefix sum in the map		
 * 
 * Variation 2 - Find all the sub-arrays possible whose sum is equal to K
 * Variation 3 - Find the length of minimum sub-array possible whose sum is equal to K.
 * 
 * Plz note the below implementation uses the compliment technique, thus we can able to use the hashMap.
 * In case in the question if asked, = Sum<=K or Sum >=k = we can use two pointer+sliding window
 * 
 */

public class FindSumSubArrayEqualK {

	public static void main(String[] args) {
		int arr[] = {10,5,2,7,1,9};
		Map<Integer, Integer> prefixMap = new HashMap<Integer, Integer>();
		int prefixSum=0;
		int target =15;
		int startIn=0;
		int endIn = 0;
		int totalsize=0;
		int maxLenOfSubArray=0;
		for(int i = 0 ; i < arr.length ; i ++) {
			prefixSum = prefixSum+arr[i];
			
			if(prefixSum-target==0) {
				startIn=0;
				endIn=i;
				System.out.println("Found SubArray = ["+startIn+","+endIn+"]");
				int sizeOf = endIn-startIn+1;
				System.out.println(sizeOf);
				maxLenOfSubArray = Math.max(maxLenOfSubArray, sizeOf);
				totalsize++;
				
			}
			
			if(prefixMap.containsKey(prefixSum-target)) {
				startIn=prefixMap.get(prefixSum-target)+1;
				endIn=i;
				
				System.out.println("Found SubArray = ["+startIn+","+endIn+"]");
				totalsize++;
				int sizeOf = endIn-startIn+1;
				System.out.println(sizeOf);
				maxLenOfSubArray = Math.max(maxLenOfSubArray, sizeOf);
				

			}
			prefixMap.put(prefixSum, i);
		}
		
		System.out.println("Total = "+totalsize);
		System.out.println("Max Len is ="+maxLenOfSubArray);
		
	}
}
