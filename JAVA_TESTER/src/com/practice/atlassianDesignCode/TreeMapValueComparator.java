package com.practice.atlassianDesignCode;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class TreeMapValueComparator implements Comparator<Map.Entry<Integer, Integer>> {

	@Override
	public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
		
		
		return o1.getValue().compareTo(o2.getValue());
	}

}
