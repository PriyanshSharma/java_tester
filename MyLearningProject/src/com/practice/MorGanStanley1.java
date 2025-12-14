package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MorGanStanley1 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(12,4,6,13,5,10);
		List<Integer> newL = new ArrayList<Integer>();
		int minLevel=4;
		int maxLevel = 10;
		int minPlayers = 3;
		for(int s : list) {
			if(s<=maxLevel && s>=minLevel) {
				newL.add(s);
			}
		}
		int sum =0;
		int n = newL.size();
		for(int i = minPlayers ; i <=n;i++) {
			long numero = calcFAct(n);
			long deno = calcFAct(minPlayers) * calcFAct(n-minPlayers);
			 sum = sum + (calcFAct(n)/(calcFAct(i) * calcFAct(n-i)));
		}
		
		System.out.println(sum);
	}
	
	public static int calcFAct(int n) {
		
		int fact =1;
		for(int i =1;i<=n ; i++) {
			
			fact = fact*i;
		}
		
		return fact;
	}
}
