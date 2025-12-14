package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SagarSoftEx {
	
	public static void main(String[] args) {
		
		SagarSoftEx object = new SagarSoftEx();
		SagarSoftEx object2 = new SagarSoftEx();

				
		
		
		Runnable r1 = new Runnable() {
			
			@Override
			public void run() {
				
				object.display();
				
			}
		};
		
		
		Runnable r2 = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				object2.displayThread2();
			}
		};
		
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		object.minDiff();
		
	}
	
	
	
	
	public synchronized void display() {
		System.out.println("Display method");
		System.out.println("Ob1 is sleeping");
		try {
			Thread.sleep(200000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		displayThread2();
		
	}
	
	public synchronized void displayThread2() {
		System.out.println("Display 2 method");
		display();
	}

	
	
	public void minDiff() {
		int arr[] = {2,4,6,8,0};
		List<int []> resultSet = new ArrayList<int[]>();
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		
		for (int i = 1 ; i < arr.length ; i ++) {
			int diff = arr[i]-arr[i-1];
			
			if (diff<min) {
				min=diff;
				resultSet.clear();
				resultSet.add(new int []{arr[i-1],arr[i]});
			}
			else if (diff==min) {
				resultSet.add(new int []{arr[i-1],arr[i]});
			}
		}
		
		resultSet.stream().forEach(p -> System.out.println(p[0]+"-"+p[1]));
		
		
	}
	
	
	
	
	
	
	
	
	/**
	 * select max(salary) from employee where sal < (select max(salary) from employee);
	 * 
	 * select distinct salary from employee order by salary desc limit 2
	 */
	
	
	
	
	
	
	
	
}
