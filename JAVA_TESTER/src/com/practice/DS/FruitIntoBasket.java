package com.practice.DS;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBasket {

	public static void main(String[] args) {
		
		int []arr = {1,2,3,2,2};
		int ans = new FruitIntoBasket().totalFruit(arr);
		System.out.println(ans);
	}
	

	public  int totalFruit(int[] arr) {
		
		int l =0,r=0,maxFruit=0;
		int n = arr.length;
		Map<Integer, Integer> frqMap = new HashMap<Integer, Integer>();
		while (r<n) {
			frqMap.put(arr[r], frqMap.getOrDefault(arr[r], 0)+1);
			
			if (frqMap.size()>2) {
				
				frqMap.put(arr[l],frqMap.get(arr[l])-1);
				
				if(frqMap.get(arr[l])==0) {
					frqMap.remove(arr[l]);
				}
				l++;
			}
			if (frqMap.size()<=2) {
				maxFruit=Math.max(maxFruit, r-l+1);
			}
			r++;
		}
		return maxFruit;
	}
}
