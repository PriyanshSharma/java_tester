package com.practice.Singleton;

public class SingleTonClass {

	private SingleTonClass() {
		if (HelperClass.INSTANCE!=null) {
			throw (new IllegalStateException());
		}
	}
	
	
	private static class HelperClass {
		
		private static final SingleTonClass INSTANCE = new SingleTonClass();
	}
	

	public static SingleTonClass getINSTANCE() {
		return HelperClass.INSTANCE;
	}
	
	
}
