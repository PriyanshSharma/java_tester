package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class DriverPracticeClass {
public static void main(String[] args) throws CloneNotSupportedException, FileNotFoundException, IOException, ClassNotFoundException {
	SingleTonClassEx obj = SingleTonClassEx.getSingeInstance();
	
	System.out.println(obj.hashCode());
	
//	SingleTonClassEx obj2  = SingleTonClassEx.getSingeInstance();
//	System.out.println(obj2.hashCode());
//	
//	Thread t = new Thread(()-> {SingleTonClassEx objrun  = SingleTonClassEx.getSingeInstance();
//	System.out.println(objrun.hashCode());
//	});
//	
//	t.start();
	
	
	ObjectOutput outObject = new ObjectOutputStream(new FileOutputStream("sing.ser"));
	outObject.writeObject(obj);
	
	outObject.close();
	
	
	 // deserialize from file to object
    ObjectInput in 
        = new ObjectInputStream(new FileInputStream("sing.ser"));
    SingleTonClassEx instance2 = (SingleTonClassEx) in.readObject();
    in.close();
    
//    System.out.println(instance2.hashCode());
  
	DriverPracticeClass d =null  ;
	Object o = new String ("");
	o=null;
	d.m1(null);
	
}

public static void m1 (Object o) {
	System.out.println("Obhject class");
	
}
public static void m1 (String o) {
	System.out.println("String class");
	
}

}
