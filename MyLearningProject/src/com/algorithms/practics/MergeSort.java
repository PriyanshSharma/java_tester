package com.algorithms.practics;

public class MergeSort {
	public static void main(String[] args) {
		  int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
		  
		  myMergeSort(intArray, 0, intArray.length-1);

//	        mergeSort(intArray, 0, intArray.length);

	        for (int i = 0; i < intArray.length; i++) {
	            System.out.println(intArray[i]);
	        }
	    
	}
	
	
	
	 // { 20, 35, -15, 7, 55, 1, -22 }
    public static void mergeSort(int[] input, int start, int end) {
    	
    	System.out.println("Start -- "+start+" End == "+end);
        if (end-start<2) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }

    // { 20, 35, -15, 7, 55, 1, -22 }
    public static void merge(int[] input, int start, int mid, int end) {
    	System.out.println("Merge method --- Strt index - "+start+" Mid index == "+mid+" End index === "+end);
        if (input[mid - 1] <= input[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);


    }
    
   public static void myMergeSort(int arr[] , int start , int end){
    	
	  if(start<end) {
		  
		  int mid = (start+end)/2; 
		  myMergeSort(arr, start, mid);
		  myMergeSort(arr, mid+1, end);
		  merger(arr, start, mid,end);
		   
	  }
	   
	   
    }
   
   public static void merger(int arr[], int start, int mid ,int end) {
	   
	   int ptr1 =start, ptr2=mid+1;
	   int tempArr[] = new int[arr.length];
	   int k =start;
	  
	   while (ptr1<=mid && ptr2<=end) {
		   if(arr[ptr1]<=arr[ptr2]) {
			   tempArr[k++] = arr[ptr1++];
		   }
		   else {
			   tempArr[k++] = arr[ptr2++];
		   }
	   }
	   
	  if(ptr1>mid) {
		  
		  while (ptr2<=end) {
			  tempArr[k++] = arr[ptr2++];
		  }
	  }
	  
	  else {
		  while (ptr1<=mid) {
			  tempArr[k++] = arr[ptr1++];
		  }
	  }
	  
	  
	 for(k = start ; k<=end; k++ ) {
		 arr[k]=tempArr[k];
	 }
   }
}
