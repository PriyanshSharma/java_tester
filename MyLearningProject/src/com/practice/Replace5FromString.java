package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * replace 5 from string to get the largest string
 */
public class Replace5FromString {

	public static void main(String[] args) {
		int input = 999;
		int result =0;
		String n = input+"";
		
		List<Integer> set = new ArrayList<Integer>();
		for(int i = 0 ; i < n.length() ; i ++) {
			
			if(n.charAt(i)=='5') {
				String s1 = null;
				StringBuilder s=new StringBuilder(n);
				
				s1 = s.deleteCharAt(i).toString();
				
				set.add(Integer.parseInt(s1));
				
			}
		}
//		String s = seif(s.co)
		if(set.size()>0) {
			Collections.sort(set);
		}
		
		else 
			result =input;
	}
}
