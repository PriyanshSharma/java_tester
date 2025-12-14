package com.practice.multiThreading;

import java.util.concurrent.ConcurrentHashMap;

public class VolatileVariableEx {

	public static void main(String[] args) {
		
		
	    ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // Thread 1: Writer
        new Thread(() -> map.put("key", 100)).start();

        // Thread 2: Reader (Will see updated value immediately)
        new Thread(() -> System.out.println(map.get("key"))).start();
    
	}
}
class SingletonWithVolatileEx {
	
	// - Making here the object as volatile to ensure all the threads will get notified if the instance is already created and won't
	//	be needing and additional instruction reordering.
	private static volatile SingletonWithVolatileEx INSTANCE;
	
	private SingletonWithVolatileEx() {
		
	}
	
	
	/*
	 * Without volatile, instance = new Singleton(); could be partially completed (reordered operations),
	 * leading to other threads seeing an uninitialized instance.
	 */
	
	public static SingletonWithVolatileEx getSingletonWithVolatileEx() {
		
		if(INSTANCE==null) {
			synchronized (SingletonWithVolatileEx.class) {
				if(INSTANCE==null) {
					INSTANCE = new SingletonWithVolatileEx();
				}
			}
		}
		return INSTANCE;
	}
}