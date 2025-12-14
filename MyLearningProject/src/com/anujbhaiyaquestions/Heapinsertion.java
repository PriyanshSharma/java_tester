package com.anujbhaiyaquestions;

import java.util.Arrays;

public class Heapinsertion {
	public static void main(String[] args) {
//		int intialSize = 7;//; // intital size fo array befor
		int arr[] = {50,40,45,30,20,35,10};
		
		
		int arrnew[] =	new int[arr.length+2];//Arrays.copyOf(arr, arr.length+1);
		
		for(int e = 1 ; e<arrnew.length-1 ; e++) {
			arrnew[e] = arr[e-1];
			
		}
		int data = 60 ;
		arrnew[arrnew.length-1] = 60; // inserted at last 
		
		
		// satisfy the heap -- -
		
		
		int i =arrnew.length-1;
		
		while (i>1) {
			int parent = i/2;
			if(arrnew[parent]<arrnew[i]) {
				swap(arrnew,parent,i);
				i=parent;
			}
		}
		
		for(int iii : arrnew) {
			System.out.println(iii);
		}
	}

	private static void swap(int[] arrnew, int parent, int i) {
		int temp =arrnew[i];
		arrnew[i]=arrnew[parent];
		arrnew[parent] = temp;
		
		
	}
}
