package com.practice.DS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DemandBase {
	
	public static void main(String[] args) {
		List<Float> input = new ArrayList<Float>();
		input.add(1.0f);
		input.add(2.0f);
		input.add(-0.2f);
		input.add(2.1f);
		getMinDiff(input);
	}
	
	public static void getMinDiff(List<Float> input){

		float minVal = Float.MAX_VALUE;
		Collections.sort(input);

		for (int i =1 ; i < input.size();i++){
			minVal = Math.min (minVal, Math.abs(input.get(i)-input.get(i-1)));
	}

		System.out.println("Min = "+minVal);


	}

}
