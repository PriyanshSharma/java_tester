package com.practice;

import java.util.ArrayList;
import java.util.List;

public class Practice1 {
	
	/*
	 * Given an array arr of size n, the task is to print all the subsets of the array.
			Subset: A subset of an array is a tuple that can be obtained from the array by removing some (possibly none or all) elements of it.
			Examples:
			Input: arr = [1, 2, 3]
			arr = {1}
			1 ""
			
			
			Output: {{}, {1}, {1, 2}, {1, 2, 3}, {1, 3}, {2}, {2, 3}, {3}}
			Input: arr = [2, 4]
			Output: {{}, {2}, {2, 4}, {4}}
				 */

	
	public static void main(String[] args) {
		int arr[] = {1,2,3};
		int currentIndex=0;
		List<Integer> resultant = new ArrayList<>() ;
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		 printSubSet(arr,currentIndex,resultant, res);
		System.out.println(res);
	}

	public static void printSubSet(int arr[], int index, List<Integer> resultant, List<List<Integer>> allSubsets) {
		
		
		if(index ==arr.length) {
			allSubsets.add(new ArrayList<Integer>(resultant));
//			System.out.println(allSubsets);
			return ;
		}
		
		printSubSet(arr, index+1, resultant,allSubsets); // leave
		System.out.println(index); //2,1,0
		resultant.add(arr[index]);
		printSubSet(arr, index+1, resultant,allSubsets); //add 1
		resultant.remove(resultant.size()-1);
		

	}
}
