package com.practice;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class ValueComparator implements Comparator<Map.Entry<Employee, String>> {

	@Override
	public int compare(Entry<Employee, String> o1, Entry<Employee, String> o2) {
		return o1.getValue().compareTo(o2.getValue());
	}

}
