package com.practice.DS;

import java.util.ArrayList;
import java.util.List;

public class IncrementNumber {
 
 
 public static void main (String [] args){
     
     
     int arr[] = {1,2,3,4};
     int n = arr.length -1;
     List<Integer> resultant = new ArrayList<Integer>(n+1);
     getIncrementNumber(arr,n,resultant);
     
     System.out.println(resultant);
     
 }
 
 public static void getIncrementNumber(int arr[], int n,List<Integer> resultant ){
     
    int carry = 0 ; 
    int val =0;
    for (int i  = n ;  i>=0 ; i --){
        
        if(arr[i]==9){
            carry=1;
            val = 0;
            
        }
        
        else {
            val = arr[i]+carry;
            carry=0;
            
        }
        
        resultant.add(i,val);
    }
    
    if (carry==1){
        resultant.add(0,carry);
    }
 }
}


