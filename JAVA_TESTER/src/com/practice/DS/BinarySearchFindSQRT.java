	package com.practice.DS;

public class BinarySearchFindSQRT {

	public static void main(String[] args) {
		System.out.println( new BinarySearchFindSQRT().mySqrt(2147483647));
	}
	
	
	 public int mySqrt(int x) {
	        
		 if (x==0) {
			 return 0;	
		 }
		 int ans =1;
		 
		 int low = 1;
		 int high =x;
		 
		 while (low<=high) {
			 
			 long mid = (low+high)/2;
			 long prod = mid*mid;
			 if ((prod)<=(long)x) {
				 ans = (int)(mid);
				 low=(int)(mid+1);
			 }
			 else {
				 high=(int)(mid-1);
			 }
		 }
		 
		 return ans;
	  }
	 
	 public static int floorSqrt(int n) {
	        int low = 1, high = n;
	        //Binary search on the answers:
	        while (low <= high) {
	            long mid = (low + high) / 2;
	            long val = mid * mid;
	            if (val <= (long)(n)) {
	                //eliminate the left half:
	                low = (int)(mid + 1);
	            } else {
	                //eliminate the right half:
	                high = (int)(mid - 1);
	            }
	        }
	        return high;
	    }
}

