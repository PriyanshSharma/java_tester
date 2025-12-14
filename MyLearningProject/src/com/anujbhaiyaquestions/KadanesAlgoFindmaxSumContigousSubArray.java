package com.anujbhaiyaquestions;

public class KadanesAlgoFindmaxSumContigousSubArray {
public static void main(String[] args) {
	int [] arr= {1,-2,3,2,-6,4,100,-200};
	int count = 0 ; 
	int maxCount = 0 ;
	
	for(int i = 0 ; i<arr.length ; i++) {
		
		count = count+ arr[i];
		
		if(maxCount<count) {
			
			maxCount = count;
		}
		
		if(count<0) {
			count = 0 ;
		}
	}
	System.out.println(maxCount);
	
}
}
