package com.practice;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class SingleTonClassEx implements Cloneable,Serializable {

	private SingleTonClassEx () {
		
	}
	
	private static class SingleTonClassHelper {
		static SingleTonClassEx object = new SingleTonClassEx();
	}
	
	public static SingleTonClassEx getSingeInstance () {
		
		return SingleTonClassHelper.object;
	}
	 protected Object readResolve() { 
		 System.out.println("Called..");
         return SingleTonClassHelper.object; 
   } 
	
//	private Object readObject(ObjectInputStream ois) throws IOException, ClassCastException{
//		System.out.println("Called deserialize...");
//		return SingleTonClassHelper.object;
//	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		throw new CloneNotSupportedException();
//		return super.clone();
	}
	
	
	
}
