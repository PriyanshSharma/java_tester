package com.practice.DS;

import java.util.HashMap;
import java.util.Map;

public class FindUniqueElementsinKWindow {

	public static void main(String[] args) {
		int arr[] = {1,2,2,1,3,1,1,3};
		int k = 4;
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0  ; i < k ; i ++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
			
		}
		System.out.println(map.size());
		
		
		for(int i = k ; i <arr.length ; i ++ ) {
			int windowSliderCounter = i-k;
			if(map.get(arr[windowSliderCounter])==1) {
				map.remove(arr[windowSliderCounter]);
			}
			else {
				map.put(arr[windowSliderCounter], map.get(arr[windowSliderCounter])-1);
			}
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1 );
		System.out.println(map.size());
			
		}
	}
}
