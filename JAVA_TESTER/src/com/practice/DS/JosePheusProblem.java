package com.practice.DS;

public class JosePheusProblem {

	public static void main(String[] args) {
		int n = 14;
		int k = 2;
		
		int ans =calcJose(n,k);
		
		System.out.println(ans);
	}

	private static int calcJose(int n, int k) {

		if(n==1) {
			return 1;
		}
		 
		int i=1;
		int ans=0;
		
		while (i<=n) {
			
			ans = (ans+k)%i;
			i++;
		}
		
		return ans+1;
	}
}
