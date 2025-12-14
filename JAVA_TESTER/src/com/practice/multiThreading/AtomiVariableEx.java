package com.practice.multiThreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomiVariableEx {

	AtomicInteger counter = new AtomicInteger(1);
	public AtomiVariableEx() {
		
	}

	public void incrementVal() {
		counter.incrementAndGet();
	}

	public static void main(String[] args) {
		AtomiVariableEx ex = new AtomiVariableEx();
		
		int existingVAl = ex.counter.get();
		int updateVale = ex.counter.incrementAndGet();
		int val = 3;

		System.out.println(existingVAl);
		System.out.println(updateVale);

		// 
		ex.counter.compareAndSet(existingVAl, val);
		System.out.println(ex.counter.get());
	}
}
