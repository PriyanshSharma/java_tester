package com.practice;

public class EquilibriumIndex {
	static int equilibrium(int a[], int n)
	{ 
	    if (n == 1)
	        return (0);
	      
	    int[] front = new int[n];
	    int[] back = new int[n];
	  
	    // Taking the prefixsum from front end array
	    for (int i = 0; i < n; i++)
	    {
	        if (i != 0)
	        {
	            front[i] = front[i - 1] + a[i];
	        }
	        else 
	        {
	            front[i] = a[i];
	        }
	    }
	    
	    // Taking the prefixsum from back end of array
	    for (int i = n - 1; i > 0; i--) 
	    {
	        if (i <= n - 2) 
	        {
	            back[i] = back[i + 1] + a[i];
	        }
	        else 
	        {
	            back[i] = a[i];
	        }
	    }
	      
	    // Checking for equilibrium index by
	    //compairing front and back sums 
	    for(int i = 0; i < n; i++) 
	    {int f=front[i];
	    int b = back[i];
	        if (f == b)
	        {
	            return i;
	        }
	    }
	      
	    // If no equilibrium index found,then return -1
	    return -1;
	}
	  
	// Driver code
	public static void main(String[] args)
	{
	    int arr[] = { 9,2,3,1,4,2};
	    int arr_size = arr.length;
	      
//	    System.out.println("First Point of equilibrium " +
//	                       "is at index " + 
//	                       equilibrium(arr, arr_size));
	    
	    binarySortWAY(arr);
//	    equilibriumPrefixPostfix(arr);
	}
	
	public static void binarySortWAY(int[] arr) {
		
		int midIndex = arr.length/2;
		int lhs=0,rhs=0;
		for(int i = 0 ; i < midIndex ; i ++) {
			lhs=lhs+arr[i];
		}
		for(int i = arr.length-1 ; i>midIndex; i--) {
			rhs +=arr[i];
		}
		
		System.out.println(lhs);
		System.out.println(rhs);
		
		
		while (rhs!=lhs) {
			if(lhs>rhs && midIndex>0) {
				rhs = rhs+arr[midIndex--];
				lhs = lhs -arr[midIndex];
			}else if(lhs<rhs) {
				lhs = lhs+arr[midIndex++];
				rhs = rhs -arr[midIndex];
			}else {
				break;
			}
		}
		if(lhs==rhs) {
			System.out.println("Equilibrium is "+midIndex);
		}
		
		
	}
	
	public static void equilibriumPrefixPostfix(int arr[]) {
		
		int prefixArr[]= new int[arr.length];
		int suffixArr[] = new int [arr.length];
		int sum=0;
		
		for(int i = 0 ; i < arr.length;i++) {
			 sum = sum+arr[i];
			 prefixArr[i]=sum;
		}
		sum=0;
		for(int i = arr.length-1 ; i>=0;i--) {
			sum = sum+arr[i];
			suffixArr[i]=sum;
		}
		
		for(int i =0;i<arr.length;i++) {
			if(prefixArr[i]==suffixArr[i]) {
				System.out.println("Equilibrium is "+i);
				break;
			}
		}
	}
	}

