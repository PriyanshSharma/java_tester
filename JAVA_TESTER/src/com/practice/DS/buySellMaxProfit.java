package com.practice.DS;

public class buySellMaxProfit {

	
	public static void main(String[] args) {
		int arr[] = {5,2,7,3,6,1,2,4};
		
		int min = arr[0];
		int max=0;
		int count=0;
		
		for (int i = 0 ; i < arr.length ; i ++) {
			min = Math.min(min, arr[i]);
			
			count = arr[i]-min;
			max = Math.max(max, count);
		}
		
		System.out.println(max);
	}
	
	public static int getDiffBetweenRats(int n, int k){
		if (n==0){
			return 0;
		}

		int MOD = 10007;
		int[] w = new int[n + 1];
        int[] b = new int[n + 1];

		if(n>=1){
			w[1] = (w[0]+w[0]*2) % MOD;
			b[1] = (b[0] + b[0]*3) % MOD;
		}

		for (int i = 2 ; i <=n ; i ++){
			w[i] = (w[i-1] + (w[i-1]*3 + w[i-2]*2)) % MOD;
			b[i] = (b[i-1]+ (b[i-1]*3 + b[i-2]*3)) % MOD;
			if(n>=3){
				w[i] = (w[i]-k + MOD) % MOD ;
				b[i] = (b[i] - (k*3) + MOD) % MOD;
			}
		}


		int diff = Math.abs(w[n]-b[n]);

		return diff;
	}
}
