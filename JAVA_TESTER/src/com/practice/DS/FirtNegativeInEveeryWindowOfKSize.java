package com.practice.DS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirtNegativeInEveeryWindowOfKSize {

	public static void main(String[] args) {
		int arr[] = {-8,2,3,-6,1};
		
		System.out.println(
		firstNegInt(arr, 2));
	}
	
	static List<Integer> firstNegInt(int arr[], int k){
		
		List<Integer> result = new ArrayList<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		int l=0,r=0;
		
		while (r<arr.length) {
			
			if (arr[r]<0) {
				q.add(arr[r]);
			}
			
			if (r-l+1 ==k) {
				
				if (q.isEmpty()) {
					result.add(0);
				}
				else {
					result.add(q.peek());
				}
				
				
				// start shrinking
				if (arr[l]<0) {
					q.poll();
				}
				
				l++;
				
			}
			
			// window expanding
			r++;
		}
		
		return result;
	}
}
