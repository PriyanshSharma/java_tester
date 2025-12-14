package com.anujbhaiyaquestions;

import java.util.HashMap;
import java.util.Map;

public class CountDistinctInEveryWindow {
	
	public static void main(String[] args) {
		int k = 3;
		
		int arr[] = {1,2,2,1,3,1,1,3};
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		
		for(int i = 0 ; i <k ; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		System.out.println(map.size());
		for(int i = k ; i<arr.length ; i++) {
			
			if(map.get(arr[i-k])==1) {
				map.remove(arr[i-k]);
			}
			else if(map.get(arr[i-k])>1){
				map.put(arr[i-k], map.get(arr[i-k])-1);
			}
			
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
			System.out.println(map.size());
			
			
		}
	}
}
