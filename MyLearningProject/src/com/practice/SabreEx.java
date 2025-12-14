package com.practice;

import java.io.IOException;
// Program to invoke other application program from ur program



public class SabreEx {
public static void main(String[] args) throws IOException {
	Runtime runtime = Runtime.getRuntime();
	Process p =runtime.exec("java Emoloyee");
	
}
}

interface SystemClass{
	public void execute1(String cmd);
	public void execute(String cmd,String args);
}

class WindowClass implements SystemClass {

	@Override
	public void execute1(String cmd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute(String cmd, String args) {
		// TODO Auto-generated method stub
		
	}
	
}

class UnixClass implements SystemClass {

	@Override
	public void execute1(String cmd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute(String cmd, String args) {
		// TODO Auto-generated method stub
		
	}
	
}

class FactoryProducer {
	
	public static void main(String[] args) {
		SystemClass s = new WindowClass();
		s.execute1("");
	}
}