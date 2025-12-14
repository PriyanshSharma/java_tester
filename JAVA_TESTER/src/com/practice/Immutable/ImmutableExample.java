package com.practice.Immutable;

import java.time.temporal.TemporalQuery;
import java.util.HashMap;
import java.util.Map;

public class ImmutableExample {
public static void main(String[] args) {
	Map<Integer, String> map = new HashMap<Integer, String>();
	
	map.put(101, "ABC");
	map.put(201, "DEF");
	EmployeeImmutable imt  = new EmployeeImmutable(1, "FirtName", map);
	System.out.println(imt);
	
	map.put(301, "XYZ");
	System.out.println("Changing immutable class object after changes map vaues - ");
	System.out.println(imt);
}

}

 final class  EmployeeImmutable {
	
	private final int id;
	private final String name;
	private final Map<Integer,String> metaMap ;
	public EmployeeImmutable(int id, String name, Map<Integer, String> metaMap) {
		super();
		this.id = id;
		this.name = name;
		// Below lines are used to make the class immutable by copying the actual values during the Object creation,
		// and thus once object is created can't be changed, maintaining immutability
		
		Map<Integer,String> tempMap = new HashMap<Integer, String>();
		metaMap.forEach((k,v) -> tempMap.put(k, v));
		this.metaMap = tempMap;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Map<Integer, String> getMetaMap() {
		return metaMap;
	}
	@Override
	public String toString() {
		return "ImmutableClass [id=" + id + ", name=" + name + ", metaMap=" + metaMap + "]";
	}
	
}
