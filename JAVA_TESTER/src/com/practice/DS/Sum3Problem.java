	package com.practice.DS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3Problem {

	public static void main(String[] args) {
		List l = new Sum3Problem().threeSum(new int []{-1,0,1,2,-1,-4});
		
		System.out.println(l);
	}
	
	 public List<List<Integer>> threeSum(int[] arr) {
		 
		 Arrays.sort(arr);

				 
		 List<List<Integer>> resulList = new ArrayList<List<Integer>>();
		 
		 for (int i =0 ; i<arr.length-1 ; i ++ ) {
			 
			 
			if (i>0 && arr[i]==arr[i-1]) {
				continue;
			}
			
			 int k =arr.length-1;
			 int j = i+1;

			
			while (j<k) {
				int sum = arr[i]+arr[j]+arr[k];
				
				if(sum<0) {
					j++;
				}
				else if(sum>0) {
					k--;
				}
				else {
					List<Integer> store = new ArrayList<Integer>(Arrays.asList(arr[i],arr[j],arr[k])) ;
					resulList.add(store);
					
					j++;
					k--;
					
					while (j<k && arr[j]==arr[j-1]) {
						j++;
					}
					while (j<k && arr[k]==arr[k+1]) {
						k--;
					}
				}
			}
			
		 }
		 return resulList;
	        
	    }
}
