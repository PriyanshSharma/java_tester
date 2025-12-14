package com.java8.practices;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

	
	public static void main(String[] args) {
		StackContainer mystack = new StackContainer();
		mystack.pushElement(1);
		mystack.pushElement(2);
		mystack.pushElement(3);
		mystack.pushElement(4);
		System.out.println(mystack.popElement());
		
	}
	
}	
class StackContainer {
	
	public StackContainer() {
		
	}
	
	private List<Object> container = new ArrayList<>();
	public void pushElement(Object elem) {
		
		if(container.isEmpty()) {
			container.add(elem);
		}
		else {
			container.add(0, elem);
		}
	}
	
	public Object popElement() {
		Object poppedElem = container.isEmpty()?null : container.get(0);
		container.remove(poppedElem);
		return poppedElem;
	}
}


