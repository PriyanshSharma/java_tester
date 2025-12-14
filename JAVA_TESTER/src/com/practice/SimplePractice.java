package com.practice;

public class SimplePractice {

	 public static void main(String[] args) {

		   	String s1 = new String("SBER");
	        String s2 = "SBER";
	        String s3 = "SBER";
	        
	       

	        System.out.println();
	        System.out.println(s1 == s2); //false
	        System.out.println(s2 == s3); // false
	        System.out.println(s1.equals(s3)); //true
	    }
	 
	 
	 static int getvalue() {
	        try {
	            System.out.println("Try Block"); //1
	            throw new Exception("Exception Occured in Try Block");
	        }catch (Exception e) {
	            System.out.println("Catch Block : "+e.getMessage()); 
	            throw new RuntimeException("Exception.....");
	            // Catch Bloack: Exception Occured in Try Block
	        }finally {
	            if (true) {
	                return 20;
	            }
	        }
	    }

}



    
   

