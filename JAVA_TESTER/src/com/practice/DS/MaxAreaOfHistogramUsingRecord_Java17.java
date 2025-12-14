package com.practice.DS;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class MaxAreaOfHistogramUsingRecord_Java17 {

	
	public static void main(String[] args) {
		
		int arr [] = {4,2,1,5,6,3,2,4,2};
		System.out.println(
		new MaxAreaOfHistogramUsingRecord_Java17().calculateMaxAreaOfHistoGram(arr));
	}
	
	
	public int calculateMaxAreaOfHistoGram(int arr[]) {
		int maxArea = Integer.MIN_VALUE;
		NodeValue[] previousmaller = getPresviouSmaller(arr);
		NodeValue[] nexSmaller = getNextSmallerValue(arr);
		
		System.out.println(Arrays.toString(previousmaller));
		System.out.println(Arrays.toString(nexSmaller));
		
		
		
		for (int i = 0 ; i < arr.length ; i ++ ) {
			
			int height = arr[i];
			int width = (nexSmaller[i].index - previousmaller[i].index)-1;
			
			int area = height*width;
			maxArea = Math.max(maxArea, area);
		}
		
		
		return maxArea;
	}
	
	public NodeValue[] getPresviouSmaller(int arr[]) {
		
		Stack<NodeValue> resultant = new Stack<NodeValue>(); 
		NodeValue [] nArr = new NodeValue[arr.length];
		for (int i=0; i < arr.length ; i ++) {
			
			while (!resultant.isEmpty() && resultant.peek().value>=arr[i]) {
				resultant.pop();
			}
			
			if(resultant.isEmpty()) {
				
				resultant.add(new NodeValue(-1, i));
				nArr[i] = new NodeValue(-1, i);
			}
			
			if(resultant.peek().value<arr[i]) {
				nArr[i] = new NodeValue(resultant.peek().value, resultant.peek().index);
				resultant.add(new NodeValue(arr[i], i));
			}
			
		}
		return nArr;
	}
	
	public NodeValue[] getNextSmallerValue(int arr[]) {
		
		Stack<NodeValue> resultant = new Stack<NodeValue>(); 
		NodeValue [] nArr = new NodeValue[arr.length];
		for (int i=arr.length-1; i >= 0 ; i --) {
			
			while (!resultant.isEmpty() && resultant.peek().value>=arr[i]) {
				resultant.pop();
			}
			
			if(resultant.isEmpty()) {
				resultant.add(new NodeValue(-1, i));
				nArr[i] = new NodeValue(-1, i);

			}
			
			if(resultant.peek().value<arr[i]) {
				nArr[i] = new NodeValue(resultant.peek().value, i);
				resultant.add(new NodeValue(arr[i], i));
			}
			
		}
		return nArr;
	}
	
	
	
	public record NodeValue(int value, int index) {
		
		@Override
		 public String toString()
	    {

	        // Return the attributes
	        return index+",";
	    }
	}

}
