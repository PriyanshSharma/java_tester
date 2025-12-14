package com.practice;

import java.util.ArrayList;
import java.util.List;

public class CustomeThreadPool {

	
	/*
	 * CTP ctp = new CTP(5);
 
		ctp.submit("Priyanshu");
		ctp.submit("Himanshu");
		
	 */
	int threadCount;
	Thread [] threadArray ;
	static List<String> list = new ArrayList<String>();
	public CustomeThreadPool(int count) {
		this.threadCount=count;
		threadArray = new Thread[this.threadCount];
	}
	public void submit(String str) {
		list.add(str);	
	}	
}
