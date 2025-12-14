package com.practice.multiThreading;

public class MyCustomBlockingQueue {

	static int arr[] ;
	int front=0;
	int rear=-1;
	static int maxCount =0;
	public MyCustomBlockingQueue(int capacity) {
		
		arr = new int[capacity];
	}
	public void add(int data) {
		
		synchronized (arr) {
			System.out.println((arr.length==maxCount));
			if(arr.length==maxCount) {
				System.out.println("OverFlow");
				try {
					arr.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			rear++;
			arr[rear]=data;
			maxCount++;
			
			System.out.println("Producing element..");
			arr.notifyAll();
			
		}
	}
	
	public int removeData() {
		
		int element;
		System.out.println(arr.length);
		synchronized (arr) {
			if(maxCount==0) {
				try {
					arr.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			element=arr[front];
			System.out.println("Consuming .. "+element);
			for(int i = 0 ; i < maxCount-1 ; i ++) {
				arr[i]=arr[i+1];
			}
			rear--;
			maxCount--;
			arr.notifyAll();
		}
		return element;
	}
	
	public static void main(String[] args) {
		int capacity=10;
		MyCustomBlockingQueue queue = new MyCustomBlockingQueue(capacity+1);
		Runnable prod = new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0 ; i <capacity ; i ++) {
					queue.add(i);
				}
			}
		};
		
		Runnable consumer=new Runnable() {
			
			@Override
			public void run() {
				while(maxCount>=0) {
				int ele = queue.removeData();
				System.out.println("Removed - "+ele);
				}
			}
		};
	
	new Thread(prod).start();
	new Thread(consumer).start();
	}
}
