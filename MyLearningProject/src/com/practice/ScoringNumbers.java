package com.practice;

public class ScoringNumbers {
	private static int cb;
	static int  ca=cb=0;
public static void main(String[] args) {
	long a[] = {1804289384, 846930887, 1681692778};
     long b[] ={1714636916, 1957747794, 424238336};
     for(int i = 0 ; i < a.length ; i ++){
         System.out.println(a[i]+"-"+b[i]);
        
         if(a[i]>b[i]){
             ca++;
         }else if (a[i]<b[i]){
             cb++;
         }
          System.out.println(ca+"-"+cb);
     }
}
}
