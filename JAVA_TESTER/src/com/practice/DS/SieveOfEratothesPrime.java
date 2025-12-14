package com.practice.DS;

import java.util.Arrays;

public class SieveOfEratothesPrime {
	
	public static void main(String[] args) {
		System.out.println(new SieveOfEratothesPrime().countPrimes(10));
	}

	public int countPrimes(int n) {
        boolean boolArr[] = new boolean[n+1];
       int count =0;
       
        
        //Marked all as prime initially
        for (int i=2 ; i<=n ; i ++){
            boolArr[i]=true;
        }

        // Marking the real ones -- Using the factors of 2,3,4,5,6 and so   on..

        for (int i = 2; i*i<=n ; i ++){

           
            // j= i*i ?? - ex 2 = 2*2,2*3,2*4 ; for 3 = 3*2 ==> already taken by 2*3, 3*3, 3*4,3*5.. ;
            //4 = 4*2. 4*3, 4*4 => 4*2 amd 4*3 - already done by previous
            //5 = 5*2, 5*3, 5*4, 5*5 => 5*2, 5*3, 5*4 already taken care by above calcualtion
            //6 = we will not mark.
            //7 = 7*2, 7*3, 7*4, 7*5, 7*6, 7*7, 7*8, 7*9 .. =>  7*2, 7*3, 7*4, 7*5, 7*6 already completed by   
            //above calcualtion.
            // j = j+i => becz if let say I have 5 = I have to mark 10, 15, meant I need a jump of current 
            //number = i, i.e. j = j+i
            for (int j = i*i ; j<=n ; j =j+i){

                   
                        boolArr[j]=false;
                    
            }
            

          

       
        }
        System.out.println(Arrays.toString(boolArr));
        
            for (boolean flag : boolArr){
                 if(flag){
                     count++;
                 }
            } 
        return count;
    }
}
