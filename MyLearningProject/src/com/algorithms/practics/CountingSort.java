package com.algorithms.practics;

public class CountingSort {
public static void main(String[] args) {
	String  s = "congratulations";
	
	countSort(s);
}

private static void countSort(String s) {
	int arr[] = new int[26];
	
	for(int i = 0 ;i < s.length();i++) {
		try {
			arr[s.charAt(i)-'a']++;
		}catch (StringIndexOutOfBoundsException e) {
			System.out.println(i);
			System.out.println(s.charAt(i));
			
		}
		
	}
	
	for(int i = 0 ; i < 26; i ++) {
		for(int j = 0 ; j<arr[i];j++) {
			char c = (char) ('a'+i);
			System.out.print(c);
		}
	}
}
}
