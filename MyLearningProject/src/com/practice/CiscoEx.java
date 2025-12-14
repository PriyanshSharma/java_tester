package com.practice;




//nput - {2,1,7,5,9,13,16} k= 3 Result – {5,9,13,16,2,1,7}


public class CiscoEx {
			public static void main(String[] args) {
				String s = "s1";
				
				foo(s);
				System.out.println("In maain "+s);
//				{5,9,13,16,2,1,7}
//				{13,16,2,1,7,5,9}
				int []input = {2,1,7,5,9,13,16} ;
				int k= 5;
				int resutlArr[] = new int[input.length];
				
				
		for(int i = 0 ; i < input.length-k ; i++) {
			
			resutlArr[i]=input[k+i];
			
		}
		
		for(int i = 0 ; i <k ; i++) {
			resutlArr[input.length-k+i]=input[i];
		}
		
		for(int a : resutlArr) {
			System.out.println(a);
		}
	}
			
			public static void foo (String s) {
				s=s.replace('1', '2');
				System.out.println("in foo "+s);
			}
}
