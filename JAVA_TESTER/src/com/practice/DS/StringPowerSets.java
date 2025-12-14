package com.practice.DS;

import java.util.ArrayList;
import java.util.List;

public class StringPowerSets {
	
	public static List<List<Integer>> res = new ArrayList<>();

	public static void main(String[] args) {
		String s="abc";  //output = {a,b,c,ab,bc,ac,abc}
		String ans="";
//		getAllSetsString(s, 0, ans);
		
		int arr[] = {1,2,3};
		List<List<Integer>> finalList = new ArrayList<List<Integer>>();
		getAllSetArray(arr, 0, new ArrayList<Integer>(),finalList);
		System.out.println("========================");
		System.out.println(finalList);
		
		int arr1[] = {1,2};
		int arr2[] = {3,5};
		int finalCount=finalList.size();
		for (List l : finalList) {
			for (int i = 0 ; i < arr1.length ; i ++) {
				if (l.contains(arr1[i]) && l.contains(arr2[i])) {
					finalCount--;
				}
			}
		}
		System.out.println(finalCount-1);
	}
	
	public static void getAllSetsString(String s, int inx, String ans) {
		
		if (inx==s.length()) {
			System.out.println(ans);
			return;
		}
//		System.out.println("Current - "+inx);
		getAllSetsString(s, inx+1, ans+s.charAt(inx));
		getAllSetsString(s, inx+1, ans);
	}
	
	public static void getAllSetArray(int arr[], int current, List<Integer> resultant, List<List<Integer>> finalList) {
		
		if(current==arr.length) {
//			res.add(ansArr);
//			res.add(new ArrayList<Integer>(resultant));
			//res.add(resultant);
			
			List<Integer> l = new ArrayList<Integer>();
			l.addAll(resultant);
			finalList.add(l);
//			System.out.println(resultant);
			return;
		}
		
		
		//include
		resultant.add(arr[current]);
		getAllSetArray(arr, current+1,resultant, finalList);
				

		resultant.remove(resultant.size() - 1);
		//Exclude
		getAllSetArray(arr, current+1, resultant,finalList);
		
		
		
	}
}
