package com.practice.DS;

import java.util.Arrays;
import java.util.Stack;

public class PreviousSmaller_LargerElement {

	public static void main(String[] args) {
	
		int arr [] = {4,10,5,8,20,15,3,12};
//			{1,6,2};
//			{4,10,5,8,20,15,3,12};
		previousLargerElement(arr);
		previousSmallerElemnet(arr);
		nextSmallerElement(arr);
	}
	
	private static void nextSmallerElement(int[] arr) {
		// TODO Auto-generated method stub
		Stack<Integer> resultant = new Stack<Integer>(); 
		int a[] = new int[arr.length];
		for (int i = arr.length-1 ; i >=0; i --) {
			
			while (!resultant.isEmpty() && resultant.peek()>=arr[i]) {
				resultant.pop();
			}
			
			if(resultant.isEmpty()) {
				a[i]=-1;
				//System.out.print("-1, ");
				resultant.add(arr[i]);
			}
			
			if(resultant.peek()<arr[i]) {
				a[i]=resultant.peek();
				//System.out.print(resultant.peek()+", ");
				
				resultant.add(arr[i]);
			}
			
		}
		System.out.println("\n Result Array = ");
		System.out.println(Arrays.toString(a));
		
	}

	public static void previousSmallerElemnet(int arr[]) {
		
		System.out.println("\nPrevious smaller element array");
		Stack<Integer> resultant = new Stack<Integer>(); 
		for (int i : arr) {
			
			while (!resultant.isEmpty() && resultant.peek()>=i) {
				resultant.pop();
			}
			
			if(resultant.isEmpty()) {
				System.out.print("-1, ");
				resultant.add(i);
			}
			
			if(resultant.peek()<i) {
				System.out.print(resultant.peek()+", ");
				resultant.add(i);
			}
			
		}
	}
	
	public static void previousLargerElement(int arr[]) {
		
		System.out.println("Previous larger element..");
		Stack<Integer> resultant = new Stack<Integer>(); 
		for (int i : arr) {
			
			while (!resultant.isEmpty() && resultant.peek()<=i) {
				resultant.pop();
			}
			
			if(resultant.isEmpty()) {
				System.out.print("-1, ");
				resultant.add(i);
			}
			
			if(resultant.peek()>i) {
				System.out.print(resultant.peek()+", ");
				resultant.add(i);
			}
			
		}
	}
}
