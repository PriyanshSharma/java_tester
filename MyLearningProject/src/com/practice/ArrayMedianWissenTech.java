package com.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class ArrayMedianWissenTech {
public static void main(String[] args) throws IOException {
	
	double d = (double)3/2;
	System.out.println(Math.ceil(d));
	
	
	Scanner sc = new Scanner(System.in);
	
	int arraySize = sc.nextInt();
	
	int inputArr[] = new int[arraySize];
	BufferedReader bi = new BufferedReader(
            new InputStreamReader(System.in));
	
	String arrInput = sc.nextLine();
	inputArr =Stream.of(arrInput.split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
	
	int q = sc.nextInt();
	String[] queries =
			new String[q];
	
	for(int i = 0 ; i < q ; i ++) {
		
		queries[i]=bi.readLine();
	}
	
	
	calculateMedian(inputArr,queries);
}

private static void calculateMedian(int[] inputArr, String[] queries) {
	
	
	for(String s : queries) {
		int start = Integer.parseInt(s.split(" ")[0])-1;
		int end = Integer.parseInt(s.split(" ")[1])-1;
		
		
		int arr[] = Arrays.copyOfRange(inputArr, start, end + 1);
		Arrays.sort(arr);
		double d = (double)arr.length/2;
		int medianInxed = (int) Math.ceil(d);
		System.out.println(arr[medianInxed-1]);
		
	}
	
}
}
