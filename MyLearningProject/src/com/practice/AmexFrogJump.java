	package com.practice;
	
	
	
	public class AmexFrogJump {
	public static void main(String[] args) {
		int [] arr = {1,5,5,2,6};
		int maxheight =getMaxRight(arr);
		System.out.println(maxheight);
	}
	
	public static int solution(int[] blocks) {
	   int leftShift =0 ;
	   int rightShift =0;
	   
	   for(int i=0 ; i < blocks.length ; i++) {
		   int leftElem=0;
		   int rightElem =0;
		   if(i==0) {
			   rightElem = blocks[1];
		   }else if(i>0) {
			   leftElem= blocks[i-1];
			   rightElem = blocks[i+1];
		   }
		   
		   while(leftElem>blocks[i]) {
			   leftShift=i-1;
		   }
	   }
		
		
		
		return 0;
	}
	
	//{1,5,5,2,6};
	private static int getMaxRight(int[] blocks) {
		int index =0;
		int maxMoved=0;
		for(int i=0 ; i < blocks.length ; i++) {
			
			
				for(int right = i+1 ; right<blocks.length ; right++) {
					int current =blocks[right-1];
					int next =blocks[right];
					if(current<=next) {
						index = right;
						maxMoved++;
					}
					else {
						break;
					}
				}
			
		}
	return 0;
	}
	}
