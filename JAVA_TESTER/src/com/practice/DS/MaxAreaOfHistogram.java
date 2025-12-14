package com.practice.DS;

import java.util.Arrays;
import java.util.Stack;

public class MaxAreaOfHistogram {

	public static void main(String[] args) {
		int arr[] = {4,2,1,5,6,3,2,4,2};
		
			//{3,1,2,4};//{4,2,1,5,6,3,2,4,2};
		
		int prevSmaller[] = getPreviousSmaller(arr);
		int nextSmaller[] = getNextSmaller(arr);
		
		int ans=0;
		for (int i= 0 ; i < arr.length ; i ++) {
			int width = nextSmaller[i]-prevSmaller[i]-1;
			int area = width*arr[i];
			ans = Math.max(ans, area);
		}
		System.out.println(getMaxAreaHistoGram(arr));
	}

	public static int getMaxAreaHistoGram(int arr[]) {
		int prevSmaller[] = getPreviousSmaller(arr);
		int nextSmaller[] = getNextSmaller(arr);
		
		int ans=0;
		for (int i= 0 ; i < arr.length ; i ++) {
			int width = nextSmaller[i]-prevSmaller[i]-1;
			int area = width*arr[i];
			ans = Math.max(ans, area);
		}
//		System.out.println(ans);
		
		return ans;
	}
	private static int[] getNextSmaller(int[] arr) {
		// TODO Auto-generated method stub
		
		int ns[] = new int[arr.length];
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = arr.length-1 ; i >= 0 ; i --) {
			
			while (!stack.isEmpty() && arr[stack.peek()]>=arr[i]) {
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				ns[i]=arr.length;
				stack.add(i);
			}
			else {
				ns[i]=stack.peek();
				stack.add(i);
			}
			
		}
		System.out.println("Next Smaller = "+Arrays.toString(ns));
		return ns;
	}

	private static int[] getPreviousSmaller(int[] arr) {
		// TODO Auto-generated method stub
		
		int ns[] = new int[arr.length];
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0 ; i < arr.length ; i ++) {
			
			while (!stack.isEmpty() && arr[stack.peek()]>=arr[i]) {
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				ns[i]=-1;
				stack.add(i);
			}
			else {
				ns[i]=stack.peek();
				stack.add(i);
			}
			
		}
		System.out.println("Previous Smaller = "+Arrays.toString(ns));
		return ns;

	}
}
