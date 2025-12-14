package com.practice;




import java.util.*;
public class Praticer {
public static void main(String[] args) {
	Another a = new Another();
	if(true);
}
}


class Another {
	public int i;
	 public Another() {
		 i=20;
		// TODO Auto-generated constructor stub
	}
	
	 class InnerC extends Another{
		 static final int i =10;
		 
		 int getI() {
			 return super.i++;
		 }
		 
		 public InnerC createIns () {
			 
			 return new InnerC();
			// TODO Auto-generated constructor stub
		}
	 }
	 
}
