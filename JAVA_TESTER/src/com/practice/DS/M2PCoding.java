package com.practice.DS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M2PCoding {

	
	/*
	 * blocks = [
		1{ 'school': true, 'grocery': false, 'hospital': false },
		2{ 'school': false, 'grocery': false, 'hospital': false },
		3{ 'school': true, 'grocery': true, 'hospital': false },
		4{ 'school': true, 'grocery': false, 'hospital': false },
		5{ 'school': true, 'grocery': false, 'hospital': true },
		6{ 'school': false, 'grocery': true, 'hospital': false },
		7{ 'school': false, 'grocery': false, 'hospital': false },
		8{ 'school': true, 'grocery': false, 'hospital': true },
		9{ 'school': true, 'grocery': false, 'hospital': true },

	]
		schoool + hospital+ grocery - mandatory for a user.
 
	 */
	public static void main(String[] args) {
		List<Map<String,Boolean>> blocks = new ArrayList<Map<String,Boolean>>();
		String userIp = "schoool,hospital,grocery";
		for (String s : userIp.split(",")) {
			Map<String, Integer> amenityMap = findNearestDistance(blocks, s);
			
		}
		
	}
	
	
	public static Map<String, Integer> findNearestDistance (List<Map<String,Boolean>> blocks, String amenity) {
		
		int n = blocks.size();
		Map<String, Integer> amenityMap = new HashMap<String, Integer>();
		for(int i = 0 ; i <n ; i ++) {
			for(int j = 0 ; j < n ; j ++) {
				if (blocks.get(j).get(amenity)) {
					String distanceBlock = i+"-"+j;
					int distance = Math.abs(i-j);
					amenityMap.put(distanceBlock, distance);
				}
			}
			
			
		}
		
		return amenityMap;
	}
}
