package com.practice.Singleton;

public class AccessSingletonClass {
	
	public static void main(String[] args) {
	SingleTonClass instance = SingleTonClass.getINSTANCE();
	SingleTonClass instance2 = SingleTonClass.getINSTANCE();
	
		System.out.println(instance.hashCode()==instance2.hashCode());

	}
}
