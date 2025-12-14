package com.practice.DS;

import java.util.PriorityQueue;

public class ConnectNRopesWithMinimumCost {

	public static void main(String[] args) {
		int arr[]= {2,5,4,8,6,9};
		
		PriorityQueue<Integer> p = new PriorityQueue<Integer>();
		
		for(int i : arr) {
			p.add(i);
		}
		int ans =0;
		while (p.size()>1) {
			int sum = p.poll()+p.poll();
			ans = ans+sum;
			p.add(sum);
		}
		
		System.out.println("Answer ="+ans);
	}
}
