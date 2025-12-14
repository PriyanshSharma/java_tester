package com.practice;

public class MainClass {

	int a =10;
	public static void main(String[] args) {
//		  Person person = new Person();
//		  System.out.println(person.ab);
//		  person.sayHow(getHow());
//		  Person employee = new Employee();
//		  employee.sayHow(getHow());
//		  User user = employee;
//		  user.sayHow(getHow());
		  
		   int i = 0;

	        for(i++; i++ < 10; i++) {
	            System.out.println(i + " ");
	        }

	        System.out.println("\nFinal i : "+i);
		  
	        
	        
	        String s1 = new String("SBER").intern();
	        String s2 = "SBER";
	        String s3 = "SBER";

	        System.out.println(s1 == s2); //false
	        System.out.println(s2 == s3); // false
	        System.out.println(s1.equals(s3)); //true
		}

	private static String getHow() {
	  return null;
	}
}
	interface How {
	  public default void sayHow(String how) throws RuntimeException {
	    sayHow(how, 1);
	    try {
	      if (null == how) throw new RuntimeException("again");
	    } catch (RuntimeException rte) {
	    }
	  }
	  public void sayHow(String how, int n);
	}

	class User implements How {
	  @Override
	  public void sayHow(String how, int n) {
	    try {
	      if (null == how) throw new RuntimeException("again user");
	    } catch (Exception rte) {
	      System.out.println("user");
	    }
	  }
	}

	class Person extends User {
		int ab=20;
	  public void start() {
	    sayHow(null);
	  }
	  @Override
	public void sayHow(String how, int n) {
	    try {
	      if (null == how) throw new RuntimeException("again person");
	    } catch (RuntimeException rte) {
	      System.out.println("person");
	    }
	  }
	}

	class Employee extends Person {
	  public void start() {
	    sayHow(null);
	  }
	  @Override
	  public void sayHow(String how, int n) {
	    try {
	      if (null == how) throw new RuntimeException("again employee");
	    } catch (RuntimeException rte) {
	      System.out.println("employee");
	    }
	  }
	}