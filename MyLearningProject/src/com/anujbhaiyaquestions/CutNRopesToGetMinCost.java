package com.anujbhaiyaquestions;

import java.util.PriorityQueue;

public class CutNRopesToGetMinCost {
	public static void main(String[] args) {
		int arr[] = {2,5,4,8,6,9};
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		
		queue.add(2);
		queue.add(5);
		queue.add(4);
		queue.add(8);
		queue.add(6);
		queue.add(9);
		
		int ropeCost =0;
		int ropeSum = 0;
		while(queue.size()>1) {
			
			int v1 = queue.poll();
			int v2 = queue.poll();
			
			ropeSum = v1+v2;
			ropeCost = ropeCost+ ropeSum; 
		}
		
		System.out.println(ropeCost);
		
	}
}
