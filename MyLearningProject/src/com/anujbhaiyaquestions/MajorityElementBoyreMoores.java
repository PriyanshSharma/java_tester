package com.anujbhaiyaquestions;

public class MajorityElementBoyreMoores {
	
	
	// any element that exists more that n/2 times
public static void main(String[] args) {
	 int arr[] = {5,1,4,1,1};
	 
	 int count = 1; 
	 int answerindex = 0 ;
	 
	 for(int i =0 ; i < arr.length-1 ; i++)
	 {
		 if(arr[i]==arr[answerindex]) {
			 count++;
		 }
		 else {
			 count--;
		 }
		 
		 
		 if(count==0) {
			answerindex = i;
			count =1;
		 }
	 }
	 
	 
	 count = 0 ; 
	 
	 int major = arr.length/2;
	 
	 for(int i = 0 ; i < arr.length ; i ++) {
		 
		 if(arr[answerindex] ==arr[i]) {
			 count++;
		 }
	 }
	 if(count>major) {
		 System.out.println(arr[answerindex]);
	 }
}
}
