package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Tesco {

	public static void main(String[] args) {
	
		
		int arr [] = {4, 4, 2, 2, 5};
		int k = 2;
		
		//8, 4, 3, 6, 1, 5, 7, 5, 2, 1 = 1,1,2,3,4,5,6,7,8
		//k=4
		
		//teamA = 8,7,6,5
		//teamB = 4,3,2,1
		
		
		getMaxMinStrenthsForTeam(arr, k);
	}
	
	
	public static void getMaxMinStrenthsForTeam(int arr[], int k){
		
		if (k>arr.length) {
			return;
		}
		
		int n = arr.length ;
		int max = 0;
		int min = 0 ; 
		
		List<Integer> teamA = new ArrayList<Integer>();
		List<Integer> teamB = new ArrayList<Integer>();
		
		Arrays.sort(arr);
		
		int playersAdder=0;
		int i = n-1;
		
		while (playersAdder<=k) {
			teamA.add(arr[i]);
			i--;
			playersAdder++;
			
			
		}
		playersAdder=0;
		while (playersAdder<=k) {
			teamB.add(arr[i]);
			i--;
			playersAdder++;
			
		}
		int stA = 0 ;
		int stB=0;
		for (int a = 0 ; a < teamA.size() ; a++) {
			stA += teamA.get(i);
		}
		
		for (int a = 0 ; a < teamA.size() ; a++) {
			stB += teamB.get(i);
		}
		
		max = stA+stA;
		
		int s = 0 ;
		int curr_diff=Integer.MAX_VALUE;
		
		
		
		for (int j = n-1 ; j >= 2*k ; j--) {
			
			
			//teamA = 8,7,6,5   //X
			//teamB = 4,3,2,1
			
			
			
			
			
			//teamA = 1,7,6,5 //Y
			//teamB = 4,3,2,8
			
			
			
			// shuffle players
			
			curr_diff = Math.abs(getStA()-getStB()); 
			
			
			min = Math.min(curr_diff, min);
			
			
			int strgest = teamA.get(s);
			int weekest = teamA.get(j);
			
			//swapping
			
			swap(teamA,teamB,s,j);
			s++;
			
			
			
		}
		
		System.out.println("MAX = "+max);
		System.out.println("MIN = "+min);
	}


	private static void swap(List<Integer> teamA, List<Integer> teamB, int s, int j) {
		
		int temp_S = teamA.get(s);
		int week_J = teamB.get(j);
		
		teamA.set(s, week_J);
		teamB.set(j,temp_S);
		
		
	}
		
		
}
