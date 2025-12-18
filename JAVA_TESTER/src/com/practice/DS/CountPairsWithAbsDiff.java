package com.practice.DS;

import java.util.HashMap;
import java.util.Map;

public class CountPairsWithAbsDiff {

	
	public static void main(String[] args) {
		CountPairsWithAbsDiff ob = new CountPairsWithAbsDiff();
		
		 int[] arr = {7,7,8,3,1,2,7,2,9,5};
	        int k = 6;
		
		ob.countKDifference(arr, k);
	}
	

	public int countKDifference(int[] arr, int k) {
        
		int count=0;
		
		Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
		
		for (int i : arr) {
			
			if (freqMap.containsKey(i+k)) {
				System.out.println("Curr element --"+i);
				System.out.println("Cntains i+k--> "+(i+k));
				
				count += freqMap.get(i+k);
			}
			
			if (freqMap.containsKey(i-k)) {
				System.out.println("Curr element --"+i);
				System.out.println("Cntains i-k--> "+(i+k));
				count += freqMap.get(i-k);
			}
			
			freqMap.put(i, freqMap.getOrDefault(i, 0)+1 );
			
		}
		
		System.out.println(count);
		return count;
    }
}
