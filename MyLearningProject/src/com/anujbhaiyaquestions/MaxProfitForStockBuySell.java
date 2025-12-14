package com.anujbhaiyaquestions;

import com.algorithms.practics.PrefixMinOfArray;

public class MaxProfitForStockBuySell {

	public static void main(String[] args) {
		int arr[]  = {3,1,4,8,7,2,5};
		
		int[] prefixMin = PrefixMinOfArray.getPrefixMin(arr);
		
		getMaxProfit(arr,prefixMin);
	}

	private static void getMaxProfit(int[] arr, int[] prefixMin) {
		
		int maxProfit = 0 ; 
		
		for(int i = 0; i <arr.length ; i ++) {
			if(maxProfit< arr[i]-prefixMin[i]) {
				maxProfit = arr[i]-prefixMin[i];
			}
		}
			System.out.println(maxProfit);	
	}
}
