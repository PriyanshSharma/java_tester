package com.practice.DS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.practice.utility.InputfromConsole;

public class Tekion_GetMaxFromStream {

	List<Integer> inputContainer = new ArrayList<Integer>(); 
	
	public static void main(String[] args) {
		Tekion_GetMaxFromStream obj = new Tekion_GetMaxFromStream();

		int ans=-1;
		while (true) {
			
		
		String s = InputfromConsole.getInputFromConsole();
		
		String[] arr = s.split(",");
		if(arr[0].equals("1")) {
			obj.inputContainer.add(Integer.parseInt(arr[1]));
		}
		else if(arr[0].equals("2")) {
			int sub = Integer.parseInt(arr[1]);
			obj.inputContainer= obj.inputContainer.stream().map(i -> Math.abs(i-sub)).collect(Collectors.toList());
		}
		else if (arr[0].equals("3")) {
			ans =obj.inputContainer.stream().collect(Collectors.summarizingInt(i->i)).getMax();
			System.out.println(ans);
		}
	}
	}
	
}
