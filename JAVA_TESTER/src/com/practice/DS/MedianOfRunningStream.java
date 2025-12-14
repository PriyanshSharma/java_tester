package com.practice.DS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianOfRunningStream {

	
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 List<Integer> inputArray = new ArrayList<Integer>();
	     System.out.print("Enter Values of the stream.. ");
	    
	     String input = scanner.nextLine();
	     if(input.equalsIgnoreCase("median")) {
	    	 System.out.println(0);
	    	 System.out.println("Enter more values .. ");
	    	 input=scanner.nextLine();
	     }else {
	    	 inputArray.add(Integer.parseInt(input));
	     }
	    
	     while (input!=null) {
	    	 input = scanner.nextLine();
	    	 if(input.equals("median")) {
	    		 getMedian(inputArray);
	    	 }
	    	 else {
	    		 inputArray.add(Integer.parseInt(input));
	    	 	}
	    		 
	     }
	}

	private static void getMedian(List<Integer> inputArray) {

		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		int n = inputArray.size()-1;
		
		for (int i = 0 ; i < inputArray.size(); i ++) {
			if (maxHeap.isEmpty()  || maxHeap.peek()>=inputArray.get(i)) {
				maxHeap.add(inputArray.get(i));
			}
			
			else {
				minHeap.add(inputArray.get(i));
			}
			// Balance the heap -- 
			//maxHeap=size(maxHeap)
			//minHeap=size(minHeap)
			// If maxHeap == minHeap || maxheap=minHeap+1 ok, else - maxheap.add(minHeap.poll())
			//--> remove the element from min heap and insert to maxHeap to maintain the equaltion always 
			// maxHeap=minHeap+1
			
			if(maxHeap.size()>(minHeap.size()+1)) {
				minHeap.add(maxHeap.poll());
				
			}
			else if (maxHeap.size()<minHeap.size()) {
				maxHeap.add(minHeap.poll());
			}
			
		}
		
		if(inputArray.size()%2!=0) {
			System.out.println("Median value == "+maxHeap.peek());
		}
		else {
			float med = ((float)(maxHeap.peek()+minHeap.peek()))/2;
			System.out.println("Median value == "+med);
		}
	}
	
	
}
