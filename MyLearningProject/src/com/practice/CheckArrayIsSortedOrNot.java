package com.practice;

public class CheckArrayIsSortedOrNot {
public static void main(String[] args) {
	
	int[] inputArr = {1,2,2,3,3,4,5,};
	boolean isSorted = false;
	isSorted =checkAscendingSorting(inputArr);
	if(!isSorted) {
		isSorted =checkDescendingSorting(inputArr);
	}
	System.out.println(isSorted);
}

private static boolean checkDescendingSorting(int[] inputArr) {
	boolean isSorted = false;
	for(int i=0;i<inputArr.length-1;i++) {
		if(inputArr[i]>=inputArr[i+1]) {
			isSorted = true;
		}
		else {
			isSorted = false;
			break;
		}
	}
	return isSorted;
}

private static boolean checkAscendingSorting(int[] inputArr) {
	boolean isSorted = false;
	for(int i=0;i<inputArr.length-1;i++) {
		if(inputArr[i]<=inputArr[i+1]) {
			isSorted = true;
		}
		else {
			isSorted = false;
			break;
		}
	}
	
	return isSorted;
}
}
