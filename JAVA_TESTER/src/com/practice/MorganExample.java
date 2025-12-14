package com.practice;

import java.util.ArrayList;
import java.util.List;

public final class MorganExample {

	// fields - set -only once
	// extended - not allowed - final
	// Constructor fied set
	
	
	private String id;
	
	private String name ; 
	
	private List<String> list;
	
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<String> getList(){
		return this.list;
	}
	
	public MorganExample(String id, String name, List<String> list) {
		// TODO Auto-generated constructor stub
		
		this.id=id;
		this.name = name;
		
		List<String> tempList = new ArrayList<String>();
		for (String s : list) {
			tempList.add(s);
		}
		
		this.list = tempList;
	}
///lru	-->> get & save operation - O(1)
	
1.	1->2->3->4->5->NULL = LinkedHashMap().entryset.iterator.next() ==> map.remove()

	update(KEY,VALUE){
	
	map.put(4,"newvalue");
	
}
// HashSet<Employee> = 

//Employee =
//{name,age,salary},{name,age,salary}
//e1,e2

e1---> ADrr1
e2--> addr2

2. add => map.put()
	
	
	
}
