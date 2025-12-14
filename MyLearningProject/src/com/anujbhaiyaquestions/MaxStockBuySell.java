package com.anujbhaiyaquestions;

public class MaxStockBuySell {
	
	public static void main(String[] args) {
		
		int arr [] = {3,1,4,8,7,2,5};
		
		
		maxProfitSingleBuySell(arr);
		maxProfitMultipleBuySell(arr);
	}

	private static void maxProfitMultipleBuySell(int[] arr) {
		
		/// find my minimum till now way.
		
				
				int maxDiff =0;
				for(int i = 1 ; i < arr.length ; i++) {
					if(arr[i]>arr[i-1]) {
						maxDiff += arr[i]-arr[i-1];
					}
				}
				System.out.println(maxDiff);
		
	}

	private static void maxProfitSingleBuySell(int[] arr) {
		
		/// find my minimum till now way.
		
				int minTillNow =arr[0] ;
				
				int maxDiff =0;
				for(int i = 0 ; i < arr.length ; i++) {
					if(minTillNow>arr[i]) {
						minTillNow = arr[i];
					}
					if(maxDiff< arr[i]-minTillNow) {
						maxDiff = arr[i]-minTillNow;
					}
				}
				System.out.println(maxDiff);
	}

}
