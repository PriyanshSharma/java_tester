package com.practice;

public class CiscoProduct {
public static void main(String[] args) {
	int arr[] = {1,2,0,4,0};
	
	int res[] = new int[arr.length];
	int productAns = 1;
	int productZero =1;
	for(int i = 0 ; i < arr.length ; i ++) {
		if(arr[i]!=0) {
			productAns = productAns*arr[i];
		}
		else {
			productZero =0;
		}
		
	}
	
	
	for(int i = 0 ; i < arr.length ; i ++) {
		if(arr[i]!=0 && productZero==0) {
			res[i] = productZero;
		}
		else if(arr[i]==0){
			res[i]=productAns;
		}
		else {
			res[i] = productAns/arr[i];
		}
		
	}
	
	for(int ans : res) {
		System.out.println(ans);
	}
}
}

