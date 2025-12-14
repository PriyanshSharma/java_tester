package com.practice;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImmutableClassDriver {
	
		public static void main(String[] args) {
			
//			Map<Integer,String> map = new HashMap<>();
//			
//			map.put(1, "Processed");
//			map.put(2, "calculating");
//			Employee1 e = new Employee1(1, "Priyansh", map);
//			
//			System.out.println("Immutable Object -->> "+e.getEmpid()+"---"+e.getEmpnamel()+"-----"+e.getMetadataMap());
//			
//			map.put(3,"Incoming new");
//			
//			System.out.println("Chnaged object == "+e.getEmpid()+"---"+e.getEmpnamel()+"-----"+e.getMetadataMap());
			
			List l = Collections.EMPTY_LIST;
			
			l.add("asd");
			
			System.out.println(l);
		}
}
