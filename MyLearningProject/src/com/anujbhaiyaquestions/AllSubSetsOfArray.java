package com.anujbhaiyaquestions;

import java.util.*;

public class AllSubSetsOfArray {
	static List<List<Integer>> master = new ArrayList<List<Integer>>();
public static void main(String[] args) {
	
	int arr[] = {1,2,3};
	
	powerSet(arr, 0,new ArrayList());
	
	System.out.println(master);
}

	public static void powerSet(int arr[] , int current ,List<Integer> list) {
		if(current == arr.length) {
			master.add(list);
			return;
			
		}
		powerSet(arr, current+1, new ArrayList<Integer>(list));
		list.add(arr[current]);
		powerSet(arr, current+1, new ArrayList<Integer>(list));
		
		
		
	}
}
