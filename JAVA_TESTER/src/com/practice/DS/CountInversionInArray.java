package com.practice.DS;

import java.util.ArrayList;

public class CountInversionInArray {

	public static void main(String[] args) {
		int arr[] = {5,4,3,2,1};
		System.out.println(inversionCount(arr));
		
		
		
		 int[] a = {5, 4, 3, 2, 1};
	        int n = 5;
	        int cnt = numberOfInversions(a, n);
	        System.out.println("The number of inversions are: " + cnt);
	}

	public static int inversionCount(int arr[]) {
        
         return mergeSortDivide(arr, 0, arr.length-1);
         
     }
	
	
	
public static int mergeSortDivide (int arr[], int low, int high) {
		int count = 0 ;
		if (low>=high) {
			return count;
		}
		int mid = (low+high)/2;
		count+= mergeSortDivide(arr, low, mid);
		count+=  mergeSortDivide(arr, mid+1, high);
		count+= mergeBack(arr, low, mid, high);
		
		return count;
	}
	
	public static int mergeBack (int arr[], int low, int mid, int high) {
		int count =0;
		int left = low;
		int right = mid+1;
		int index=0;
		int tempArr[] = new int [high-low+1];
		while (left<=mid && right <=high) {
			if(arr[left]<arr[right]) {
				tempArr[index++]=arr[left];
				left++;
			}
			else {
				tempArr[index++]=arr[right];
				count+= (mid-low+1);
				right++;
			}
		}
		while (left <=mid) {
			tempArr[index++] = arr[left++];
		}
		while (right <=high) {
			tempArr[index++] = arr[right++];
		}
		
		// Copy this temp array in main array ==
		
		for (int i =0,j=low ;i<tempArr.length ; i++) {
			arr[j++]=tempArr[i];
		}
		
		return count;
		
	}
	
	 private static int merge(int[] arr, int low, int mid, int high) {
	        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
	        int left = low;      // starting index of left half of arr
	        int right = mid + 1;   // starting index of right half of arr

	        //Modification 1: cnt variable to count the pairs:
	        int cnt = 0;

	        //storing elements in the temporary array in a sorted manner//

	        while (left <= mid && right <= high) {
	            if (arr[left] <= arr[right]) {
	                temp.add(arr[left]);
	                left++;
	            } else {
	                temp.add(arr[right]);
	                cnt += (mid - left + 1); //Modification 2
	                right++;
	            }
	        }

	        // if elements on the left half are still left //

	        while (left <= mid) {
	            temp.add(arr[left]);
	            left++;
	        }

	        //  if elements on the right half are still left //
	        while (right <= high) {
	            temp.add(arr[right]);
	            right++;
	        }

	        // transfering all elements from temporary to arr //
	        for (int i = low; i <= high; i++) {
	            arr[i] = temp.get(i - low);
	        }
	        return cnt; // Modification 3
	    }

	    public static int mergeSort(int[] arr, int low, int high) {
	        int cnt = 0;
	        if (low >= high) return cnt;
	        int mid = (low + high) / 2 ;
	        cnt += mergeSort(arr, low, mid);  // left half
	        cnt += mergeSort(arr, mid + 1, high); // right half
	        cnt += merge(arr, low, mid, high);  // merging sorted halves
	        return cnt;
	    }

	    public static int numberOfInversions(int[] a, int n) {
	        // Count the number of pairs:
	        return mergeSort(a, 0, n - 1);
	    }
}
