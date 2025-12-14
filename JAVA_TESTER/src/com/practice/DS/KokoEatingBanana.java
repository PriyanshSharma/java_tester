package com.practice.DS;


/**
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. 
 * The guards have gone and will come back in h hours.
 * Koko can decide her bananas-per-hour eating speed of k. 
 * Each hour, she chooses some pile of bananas and eats k bananas from that pile. 
 * If the pile has less than k bananas, she eats all of them instead and will not eat any 
 * more bananas during this hour.
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 * Return the minimum integer k such that she can eat all the bananas within h hours.
	
	Example 1:

	Input: piles = [3,6,7,11], h = 8
	Output: 4
	Example 2:
	
	Input: piles = [30,11,23,4,20], h = 5
	Output: 30
	Example 3:
	
	Input: piles = [30,11,23,4,20], h = 6
	Output: 23
 
 */
public class KokoEatingBanana {

	public static void main(String[] args) {
		
		int arr[] = {30,11,23,4,20};
		int h=6;
		System.out.println(new KokoEatingBanana().minEatingSpeed(arr, h));
	}
	
	
	public int minEatingSpeed(int[] arr, int h) {
        int low = 1;
        int high=-1;
        int n = arr.length;
        for (int i = 0 ; i <n; i++) {
        	high = Math.max(high, arr[i]);
        }
        int answer=Integer.MAX_VALUE;
        
        while (low<=high) {
        	
        	int mid = (low+high)/2;
        	
        	int totalHoursReq = calculateTotalHours(arr,mid);
        	
        	if (totalHoursReq<=h) {
        		high=mid-1;

        	}
        	
        	else {
        		low = mid+1;
        	}
        
        
        }
        
        return low;
    }


	private int calculateTotalHours(int[] arr, int mid) {
		
		double ans=0.0d;
		
		for (int i = 0 ; i < arr.length ; i ++) {
			ans += Math.ceil(((double)(arr[i]))/((double)mid));
		}
		return (int)ans;
	}
}
















