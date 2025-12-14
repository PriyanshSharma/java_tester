package com.practice;

public class HellOWorld {
	
	
	public static void main(String[] args) {
		  // 1. String Literals
        String s1 = "Test";
        String s2 = "Test";
        System.out.println("1. s1 == s2: " + (s1 == s2)); //true

        // 2. String Object vs. Literal
        String s3 = new String("Test");
        System.out.println("2. s1 == s3: " + (s1 == s3)); //false

        // 3. Concatenated Literal
        String s4 = "Te" + "st";
        System.out.println("3. s1 == s4: " + (s1 == s4)); //false

        // 4. Concatenated with a variable
        String part = "Te";
        String s5 = part + "st";
        System.out.println("4. s1 == s5: " + (s1 == s5));  //false

        // 5. Concatenated with a FINAL variable
        final String finalPart = "Te";
        String s6 = finalPart + "st";
        System.out.println("5. s1 == s6: " + (s1 == s6));

        // 6. Using the intern() method
        String s7 = s5.intern();
        System.out.println("6. s1 == s7: " + (s1 == s7)); //true

	}
	
	
}
