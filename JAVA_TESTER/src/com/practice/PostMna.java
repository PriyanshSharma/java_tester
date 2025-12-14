package com.practice;

public class PostMna {

	public static void main(String[] args) {
		
		SharedRes s1 = new SharedRes("S1 res");
		SharedRes s2 = new SharedRes("S2 res");

		
		Thread t1 = new Thread1(s1,s2);
		Thread t2 = new Thread2(s1,s2);
		
		t1.start();
		t2.start();
	}
	
}



class SharedRes {
	
	String nameOfResource;
	
	synchronized public void display ( SharedRes res) {
		
		System.out.println("Resoruce Name "+res.nameOfResource);
		
//		display2(res);
	}
	
	
	synchronized public void display2 ( SharedRes res) {
		
		System.out.println("Display two method .. Resoruce Name "+res.nameOfResource);
		
	}
	
	public SharedRes(String name) {
		this.nameOfResource = name;
	}
}



class Thread1 extends Thread {
	
	
	
	SharedRes s1 ;
	SharedRes s2;
	
	public Thread1(SharedRes s1, SharedRes s2) {
		// TODO Auto-generated constructor stub
		
		this.s1=s1;
		this.s2=s2;
	}
	@Override
	public void run() {
		
		// TODO Auto-generated method stub
		super.run();
		

		s1.display(s2 );
		
//		System.out.println("Pausing Thread");
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}


class Thread2 extends Thread {
	

	SharedRes s1 ;
	SharedRes s2;
	
	public Thread2(SharedRes s1, SharedRes s2) {
		// TODO Auto-generated constructor stub
		
		this.s1=s1;
		this.s2=s2;
	}
	
	
	@Override
	public void run() {
		
		// TODO Auto-generated method stub
		super.run();
		
		s2.display(s1);		
		
		try {
			Thread.sleep(200000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		
	}
	
	