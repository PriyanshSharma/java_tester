
package com.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountFreq {

	
	public static void main(String[] args) {
		String s= "PPAWAN";
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(Character c : s.toCharArray()) {
			int value=0;
			if (map.containsKey(c)) {
				value = map.get(c);
				map.put(c, value+1);
			}
			
			else {
				map.put(c, value+1);
			}
			
		}
		System.out.println("Map == ");
		System.out.println(map);
		
		
		
		char charArr[] = s.toCharArray();
		
		//counting sort == 
		
		int arr[] = new int[26];
		
		 for (int i = 0; i < s.length(); i++) {
			 int val = Math.abs(s.charAt(i) - 'a');
	          
				System.out.println(val);

			 
			 arr[val]++;
		 }
			
		
		
		System.out.println(Arrays.toString(arr));
	}
	
	
	
	
	
}
