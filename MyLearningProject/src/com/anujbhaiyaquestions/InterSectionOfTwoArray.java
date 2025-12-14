package com.anujbhaiyaquestions;

import java.util.HashSet;
import java.util.Set;

public class InterSectionOfTwoArray {
	
	public static void main(String[] args) {
		int arr1[] = {10,20,30};
		int arr2[] = {2,3,4,10,20};
		int i =0; 
		int j =0;
		Set<Integer> sets = new HashSet<Integer>();
		while (i<arr1.length && j<arr2.length) {
			if(arr1[i]<arr2[j]) {
				i++;
			}
			else if (arr1[i]>arr2[j]) {
				j++;
			}
			else {
				sets.add(arr1[i]);
				i++;
				j++;
			}
		}
		System.out.println(sets);
	}
}
