package com.anujbhaiyaquestions;

import java.util.Stack;

public class AreaOfHistogram {
	public static void main(String[] args) {
		 int arr [] = {4,2,1,5,6,3,2,4,2};
		 
		 int prevSmaller[] = new int [arr.length];
		 
		 int nextSmaller[] = new int [arr.length];
		 
		 
		 prevSmaller = findPreSmaller (arr);
		 nextSmaller = findNextSmaller (arr);
		 
		 
		 int maxArea = 0 ;
		 for(int i = 0 ; i < arr.length ; i ++) {
			 int curr =  (nextSmaller[i] - prevSmaller[i] -1) * arr[i];
			 maxArea = Math.max(maxArea,curr);
		 }
		 System.out.println(maxArea);
	}

	private static int[] findNextSmaller(int[] arr) {
		int result[] = new int[arr.length];
		Stack<Integer> stack = new Stack<>();
		for(int i = arr.length-1 ; i >= 0 ; i --) {
			
			while (!stack.isEmpty() && arr[i]<=arr[stack.peek()]) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				result[i] = arr.length;
			}
			else {
				result[i] = stack.peek();
			}
			
			stack.push(i);
		}
		return result;
	}

	private static int[] findPreSmaller(int[] arr) {
		int result[] = new int[arr.length];
		Stack<Integer> stack = new Stack<>();
		for(int i = 0 ; i < arr.length ; i ++) {
			
			while (!stack.isEmpty() && arr[i]<=arr[stack.peek()]) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				result[i] = -1;
			}
			else {
				result[i] = stack.peek();
			}
			
			stack.push(i);
		}
		return result;
	}
}
