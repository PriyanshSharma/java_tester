package com.practice;

import java.util.ArrayList;
import java.util.List;

public class Allstate {
	
	
	/*
	 * 9,9,9,11,12,46,56,56,77,78,99,99,102



		output: 9, 12, 56, 78, 102
	 */
	public static void main(String[] args) {
		
		int arr[] = {9,9,9,11,12,46,56,56,77,78,99,99,102};
		List<Integer> uniqueElems = new ArrayList<Integer>();
		
		for(int i = 0 ; i < arr.length-1 ; i++) {
			
			if(arr[i]!=arr[i+1]) {
				uniqueElems.add(arr[i]);
			}
			
		}
		
		System.out.println(uniqueElems);
		
		
		for(int i = 0 ; i < uniqueElems.size() ; i=i+2) {
			System.out.print(uniqueElems.get(i)+" ");
		}
	}
}






// Emp - ename,esal,eid

/// update emp set ename ="New name" where eid=100