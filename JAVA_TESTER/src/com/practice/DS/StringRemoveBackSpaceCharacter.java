
package com.practice.DS;

public class StringRemoveBackSpaceCharacter {

	public static void main(String[] args) {
		boolean flag = new StringRemoveBackSpaceCharacter().backspaceCompare("ab##", "c#d#");
		System.out.println(flag);
	}
	
public boolean backspaceCompare(String s, String t) {
        
        System.out.println(s);
        System.out.println(t);
        String res =getbackSpaceRemovedString(s);

        String res2 = getbackSpaceRemovedString(t);


        return res.equals(res2);
    }

    private String getbackSpaceRemovedString(String s){
        
        
        int n = s.length();
        if(n==1 && s.charAt(0)=='#'){
            return "";
        }
     
        char[] arr = new char[n];
        
        int i=0;
        while (s.charAt(i)=='#' ){
            i++;
        }
        int j =-1;
        while(i<n){

            if(s.charAt(i)!='#'){
                j++;
                arr[j]=s.charAt(i);
                
            }
            else {
                if(j>=0){
                    arr[j]=' ';
                    j--;
                }  
            }
            i++;
        }
        String resultant="";
        for (int z = 0 ; z<j+1 ; z ++){
            resultant=resultant+arr[z];
        }
        // System.out.println(s+"-"+resultant);
       
        return resultant;
    }
}
