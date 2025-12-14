package com.practice;

import java.util.HashMap;
import java.util.Map;

public final class Employee1 {

	private final int empid;
	private final String empnamel;
	private final Map<Integer, String> metadataMap ;
	private Map<Integer, String> noFinalmetadataMap ;
	
	public Employee1(int id, String name, Map<Integer,String> metadata) {
		this.empid = id;
		this.empnamel=name;
		
		Map<Integer,String> tempMap = new HashMap<Integer, String>();
		
//		for(Map.Entry<Integer, String> ent:metadata.entrySet()) {
//			tempMap.put(ent.getKey(), ent.getValue());
//		}
		
		metadata.entrySet().forEach(ent->tempMap.put(ent.getKey(),ent.getValue()));
		this.metadataMap=tempMap;
		this.noFinalmetadataMap=metadata;
		
		System.out.println("Construcotr");
	}

	public int getEmpid() {
		System.out.println("Get ID");
		return empid;
	}

	public String getEmpnamel() {
		
		System.out.println("Get EMP Name");
		return empnamel;
	}

	public Map<Integer, String> getMetadataMap() {
		
//		 Map<Integer, String> tempMap = new HashMap<>();
//		 
//	        for (Map.Entry<Integer, String> entry :
//	             this.metadataMap.entrySet()) {
//	            tempMap.put(entry.getKey(), entry.getValue());
//	        }
//	        return tempMap;
		System.out.println("Get Map");
		System.out.println("Map printing in getter------>>>> "+noFinalmetadataMap);
		return this.metadataMap;
	}

	@Override
	public String toString() {
		return "Employee1 [empid=" + empid + ", empnamel=" + empnamel + ", metadataMap=" + metadataMap + "]";
	}
	
	
}
