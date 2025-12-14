package com.practice.DS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMax {

	public static void main(String[] args) {
		int [] arr = {1,3,-1,-3,5,3,6,7};
		int k=3;
		int resutant[] =getMaxWindowWithK(arr,k);
		
		System.out.println(Arrays.toString(resutant));
	}

	private static int[] getMaxWindowWithK(int[] arr, int k) {
		Deque<Integer> q = new ArrayDeque<Integer>() ;
		List<Integer> result = new ArrayList<Integer>(); 
		for(int i = 0 ; i<k ; i++) {
			
			
			while (!q.isEmpty() && arr[q.peekLast()]<=arr[i]) {
				q.pollLast();
			}
			q.offerLast(i);
		}
		result.add(arr[q.peekFirst()]);
		System.out.println(arr[q.peekFirst()]);
		
		
		for (int i = k ; i < arr.length ; i++) {
			
			
			
			//Now we need to maintain only the elements of the window as well in the q, 
			//thus removing the last element from the q...
			// How ??? --- 
			// so the last element will always be i-k ,thus any element less than this should be removed from
			//queue
			
			while (!q.isEmpty() && q.peekFirst()<=(i-k)) {
				q.pollFirst();
			}
			
			// Maintaining the queue in decreasing order
			while (!q.isEmpty() && arr[q.peekLast()]<=arr[i]) {
				q.pollLast();
			}
			
			q.offerLast(i);
			result.add(arr[q.peekFirst()]);
		}
		
		return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
	}
	
	
	
	
}
