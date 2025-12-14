package com.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AtlassianKarat {


		  public static void main(String[] argv) {
		    String[] teleporters1 = {"3,1", "4,2", "5,10"};
		    String[] teleporters2 = {"5,10", "6,22", "39,40", "40,49", "47,29"};
		    String[] teleporters3 = {"6,18", "36,26", "41,21", "49,55", "54,52",
		                            "71,58", "74,77", "78,76", "80,73", "92,85"};
		    String[] teleporters4 = {"97,93", "99,81", "36,33", "92,59", "17,3",
		                            "82,75", "4,1", "84,79", "54,4", "88,53",
		                            "91,37", "60,57", "61,7", "62,51", "31,19"};
		    String [] teleporters5 = {"3,8", "8,9", "9,3"};
		    
		    
		   
		   
		    getfinalPossibleTiles(teleporters1,  6,    0,  12) ;//=> [1, 2, 10, 6]
		    getfinalPossibleTiles(teleporters2,  6,   46, 100) ;//=> [48, 49, 50, 51, 52, 29]
		    getfinalPossibleTiles(teleporters2, 10,    0,  50) ;// => [1, 2, 3, 4, 7, 8, 9, 10, 22]
		    getfinalPossibleTiles(teleporters3, 10,   95, 100) ;//=> [96, 97, 98, 99, 100]
		    getfinalPossibleTiles(teleporters3, 10,   70, 100) ;//=> [72, 73, 75, 76, 77, 79, 58]
		    getfinalPossibleTiles(teleporters4,  6,    0, 100) ;//=> [1, 2, 3, 5, 6]
		    getfinalPossibleTiles(teleporters5,  7,    2,  20) ;//=> [3, 4, 5, 6, 7, 8, 9]

		    
		    
		    
		  }
		  
		  public static void getfinalPossibleTiles (String[] teleporters, int die, int startTile, int n){
		    
		    
		    
		    Map<String,String> teleportersMap =populateTeleportersMap(teleporters);
		    Set<Integer> resultant = new HashSet<Integer>();
		   //
		   
		   for (int i = 1 ; i <= die ; i ++){
		     int nextMove= startTile+i;
		     if (nextMove <= n){
		       String val=nextMove+"";
		       if (teleportersMap.containsKey(val)){
		         resultant.add(Integer.parseInt(teleportersMap.get(val)));
		       }
		       else {
		         resultant.add(Integer.parseInt(val));
		         
		       }
		       
		     }
		   }
		    System.out.println(resultant);;
		    
		  }
		  
		  
		  private static Map<String,String> populateTeleportersMap(String [] teleporters){
		     
		     Map<String,String> teleportersMap = new HashMap<String, String>();
		     for (String s : teleporters) {
		      
		      String arr[] = s.split(",");
		      teleportersMap.put(arr[0],arr[1]);
		      
		    }
		    
		    return teleportersMap;
		    
		  }
		}

