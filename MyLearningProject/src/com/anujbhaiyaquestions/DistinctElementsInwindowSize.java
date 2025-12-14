package com.anujbhaiyaquestions;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DistinctElementsInwindowSize {
	
	public static void main(String[] args) {
		int arr[] = {1,2,2,1,3,1,1,3};
		
		int k =4;
		
		
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		
		
		// i have created a map manually for my first window [0-3] indexes. 
		for(int i = 0 ; i < k ; i ++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
//		System.out.println(map.size());
		for(int i = k; i <arr.length ; i ++) {
			
			if(map.get(arr[i-k])==1) {
				map.remove(arr[i-k]);
			}
			
			else {
				map.put(arr[i-k], map.get(arr[i-k])-1);
				
			}
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
			
//			System.out.println(map.size());
			
		}
		
//		finadMaxProduct();
	}
	
	
	public static void finadMaxProduct(List<Integer> products) {
		List<Integer> maxAnsss = new ArrayList<Integer>();
		
		
		
		for(int i = products.size()-1 ; i >= 0 ; i --) {
			int sum =0;
			int startval = products.get(i);
			int j = i;
			while (j>0) {
				
				int prevToStart = products.get(j-1);
				if (prevToStart>=startval) {
					int adder = prevToStart - startval;
					int res = prevToStart -adder -1;
					sum = sum + (startval +res);
					
				}
				else if (prevToStart<startval) {
					
					sum = sum+prevToStart;
				}
				startval = products.get(j);
				j--;
			}
			maxAnsss.add(sum);
			
		}
		int maxVal = maxAnsss.stream().max(Comparator.naturalOrder()).get();
		
		System.out.println(maxVal);
	}
}
