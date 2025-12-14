package com.practice.DS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Tekion_CompareWithFrequencymap {

	
	Set<String> dictionary = new HashSet<String>();
	
	Map<Character, Integer> frequencyMap  = new HashMap<Character, Integer>();
	Map<String, Map<Character, Integer>> dictionaryMapper = new HashMap<String, Map<Character,Integer>>();

	
	public Tekion_CompareWithFrequencymap() {
		// TODO Auto-generated constructor stub
		
		dictionary.add("foo");
		dictionary.add("bar");
		dictionary.add("eat");
		dictionary.add("rat");
		dictionary.add("cat");
		
		
		for (String s : dictionary) {
			
			Map<Character, Integer> currer = new HashMap<Character, Integer>();
			
			for (char c : s.toCharArray()) {
				currer.put(c, currer.getOrDefault(c, 0)+1);

			}
			
			dictionaryMapper.put(s, currer);
			
		}
		
	}
	
	public static void main(String[] args) {
		 Tekion_CompareWithFrequencymap obj = new Tekion_CompareWithFrequencymap();
		
		 while (true) {
			 Scanner sc = new Scanner(System.in);
			 char c = sc.next().charAt(0);
			 String str = obj.getString(c);
			 
			 if (str!=null || str!="") {
				 System.out.println(str);
			 }
		 }
		 
	}
	
	public String getString (char c) {
		
		//// c,a,a,f,v,f,g,b,h,j,g,e,a,r,a,a....

		
		frequencyMap.put(c, frequencyMap.getOrDefault(c, 0)+1);
		String ans="";
		boolean found=false;
		for (String s : dictionary) {
			
			if (s.contains(c+"")) {
					//bar, 
					Map<Character, Integer> currentFrequencyMap = getCurrentMapper(s);
					//b=1,a=1,r=1
					
					for (char c1:s.toCharArray()) {
						if (frequencyMap.containsKey(c1) && frequencyMap.get(c1)>=currentFrequencyMap.get(c1)) {
							found = true;
						}else {
							found=false;
							break;
						}
					}
					
					
				if(found) {
					
					ans= s;
					break;
				}
									
			}
			
			
		}
		
		if(found) {
			for (char s1:ans.toCharArray()) {
				
				
				frequencyMap.put(s1, frequencyMap.get(s1)-1);
			}
		}
		
		
		return ans!=""?ans:"";
	}

	private Map<Character, Integer> getCurrentMapper(String s) {
		// TODO Auto-generated method stub
		return dictionaryMapper.get(s);
	}
}
