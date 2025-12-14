package com.practice.DS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

	By listing and labeling all of the permutations in order, 
	we get the following sequence for n = 3:
	
	"123"
	"132"
	"213"
	"231"
	"312"
	"321"
	Given n and k, return the kth permutation sequence.
	
	 
	
	Example 1:
	
	Input: n = 3, k = 3
	Output: "213"
	Example 2:
	
	Input: n = 4, k = 9
	Output: "2314"
	Example 3:
	
	Input: n = 3, k = 1
	Output: "123"
 */
public class KthPermutation {

	public static void main(String[] args) {
		String ans =new KthPermutation().getPermutation(4, 17);
		System.out.println(ans);
	}
	
	 public String getPermutation(int n, int k) {
	        
		 
		 String ans ="";
		 
		 int fact=1;
		 List<Integer> list = IntStream.rangeClosed(1, n)
				 				.boxed() .collect(Collectors.toList());
		
		 for (int i=0; i<list.size()-1; i++) {
			 fact = fact*list.get(i);
		 }
		 k=k-1;
		 while (true) {
			
			int pickElement = k/fact; 
			ans = ans + list.get(pickElement);
			list.remove(pickElement);
			if (list.size()==0) {
				break;
			}
			k = k%fact;
		
			fact = fact/list.size(); // --> it is like we need the fact for the new available elements, 
									// one way to just reduce the factorial likw 3! to 2! = 
									// 3! = 1x2x3 thus to calculate 2! = 3!/3
		 }
		 
		 
		 return ans;
	 }
}

































