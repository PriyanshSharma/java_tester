package com.practice;

import java.util.*; 
import java.io.*;
import java.util.stream.*;

class SnPOnlineTest {

	final static List<Integer> sumList = new ArrayList<Integer>();
  public static boolean ArrayChallenge(int[] arr) {
    // code goes here  

    List<Integer> resultList = new ArrayList<Integer>();
    int maxSum = IntStream.of(arr).max().getAsInt();

    for(int i = 0 ; i < arr.length ; i ++){

        if(arr[i]!=maxSum){
            resultList.add(arr[i]);

        }

    }
    List<Integer> subsetList = new ArrayList<Integer>();
    calcOperation(resultList,0,maxSum,subsetList);
    return sumList.contains(maxSum);
  }


private static void calcOperation(List<Integer> list,int i,int maxSum, List<Integer> subsetList){


  if(i==list.size()){
   System.out.println(subsetList);
   int sumhere = subsetList.stream().collect(Collectors.summingInt(v->v));
   sumList.add(sumhere);
   return ;
  }

  calcOperation(list,i+1,maxSum,new ArrayList<Integer>(subsetList));
  subsetList.add(list.get(i));
  calcOperation(list,i+1,maxSum,subsetList);

}
  public static void main (String[] args) {  
    // keep this function call here     
    // Scanner s = new Scanner(System.in);
    // System.out.print(ArrayChallenge(s.nextLine())); 
    int[] arr = {1,2,3,4,5};
    ;
    System.out.println(SnPOnlineTest.ArrayChallenge(arr));
    
//    System.out.println();
  }

  

}