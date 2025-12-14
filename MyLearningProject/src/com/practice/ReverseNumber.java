package com.practice;

public class ReverseNumber {
public static void main(String[] args) {
			int input = 121878;
			int n;
			int result=0;
			int cout =0;
			while(input>0){
				n = input%10;
				
				result = result*10;
				result = result+n;
				input=input/10;
				cout++;
				
		}
	 System.out.println(cout);
}
}
