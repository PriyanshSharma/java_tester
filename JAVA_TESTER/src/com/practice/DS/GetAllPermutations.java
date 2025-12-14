package com.practice.DS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetAllPermutations {

	public static void main(String[] args) {
//		String s = "abc";
////		getAllPerm(s, 0, s.length()-1);
		int arr[] = {1,2,3};
		boolean bool[] = new boolean[arr.length];
		Arrays.fill(bool, false);
		List<Integer> list = new ArrayList<Integer>();
		getAllPermRecuWay(arr, 0, bool, list);
		
//		int arr[] = {1,2,3};
//		System.out.println( new GetAllPermutations().permute(arr));
		
	}
	public static void getAllPerm(String s, int left, int right) {
		if(left ==right) {
			System.out.println(s);
			return;
		}
		
		for(int i = left ; i <=right ; i ++) {
			
			s=swap(s,left,i);
			getAllPerm(s, left+1, right);
			s=swap(s,left,i);
		}
	}
	
	
	public static void getAllPermRecuWay(int arr[], int i , boolean bool[],List<Integer> ansList) {
		
		if (arr.length==ansList.size()) {
			System.out.println(ansList);
			return;
		}
		for (int j =0 ; j<arr.length ; j++) {
			if (!bool[j]) {
				bool[j]=true;
				ansList.add(arr[j]);
				getAllPermRecuWay(arr, j, bool, ansList);
				ansList.remove(ansList.size()-1);
				bool[j]=false;
			}
		}
		
		
	}
	
	private static String swap(String s , int l, int r) {
		char c = s.charAt(l);
		char c1 = s.charAt(r);
		StringBuffer sb = new StringBuffer(s);
		sb.setCharAt(l, c1);
		sb.setCharAt(r, c);
		s=sb.toString();
		
		return s;
	}
	
	private void swap(int arr[] , int l, int r) {
		int temp = arr[l];
		arr[l]=arr[r];
		arr[r]=temp;
	}
	
	
	public List<List<Integer>> permute(int[] nums) {
	       List<List<Integer>> result = new ArrayList<>();
	       List<Integer> list = new ArrayList<>();
	        getAllPerm(nums,0,list,result);

	        return result;
	    }


	    public void getAllPerm(int arr[], int idx, List<Integer> list, List<List<Integer>> result) {
			if(idx==arr.length) {
				 List<Integer> l = new ArrayList<>();
				 for (int num:arr) {
					 l.add(num);
				 }
//	             l.addAll(list);
	             result.add(l);
	             System.out.println(l);
				return;
			}
			
			for(int i = idx ; i <arr.length ; i ++) {
				swap(arr,idx,i);
//	            list.add(arr[idx]);
				getAllPerm(arr, idx+1, list,result);
//	            list.remove(list.size()-1);
				swap(arr,idx,i);
			}
		}


}
