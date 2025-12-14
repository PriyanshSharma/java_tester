package com.practice;




import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
Game of snake

The snake can move up, down, left or right in a 2-dimensional board of arbitrary size.

Let’s try to implement the base logic of this game.

Rules:

Every time moveSnake() is called, the snake moves up, down, left or right

The snake’s initial size is 3 and grows by 1 every 5 moves

The game ends when the snake hits itself

We can use the following as a starting point (pseudo-code):

interface SnakeGame {
    moveSnake(snakeDirection);
    isGameOver();
}
R, R ,r r 

0,0 -> 0,1

[][]

1 1 1 1 0
0 0 1 1 0
0 0 1 1 0
0 0 0 0 0
0 0 0 0 0

0,0 0,1 0,2 1,2 

**/



public class AtlassianSecondround {

    public static void main(String[] args) {  
        
        int rowSize=4;
        int colSize=4;
        String moves = "R,R,R,L";
        List<String>  snakeDirection= Arrays.asList(moves.split(","));
        
        Queue<String> queue = new LinkedList<>(); // FIFO Queue

        // Adding elements
        queue.add("Alice");
        queue.add("Bob");
        queue.add("Charlie");
        System.out.println(snakeDirection);
        moveSnake(snakeDirection,rowSize,colSize);
    }
    
    
    public static void moveSnake(List<String> snakeDirection, int maxRow, int maxCol){
        
        Queue<String> coordinates = new LinkedList<>();
        // Entry -- 00,01,02,03,11
        coordinates.add("00");
        coordinates.add("01");
        coordinates.add("02");
        
        int r=0;
        int c=2;
        int movecounter=1;
        int snakeSize=3;
        for(String m : snakeDirection){
             StringBuffer buff = new StringBuffer();
            if(m.equalsIgnoreCase("R")){
                c++;
                if(c>maxCol){
                    c=0;
                }
                buff.append(r);
                buff.append(c);
                
            }
            
            else if(m.equalsIgnoreCase("L")){
                c--;
                if(c==-1){
                    c=maxCol;
                }
                buff.append(r);
                buff.append(c);
            }
            else if(m.equalsIgnoreCase("U")){
                r--;
                if(r==-1){
                    r=maxRow;
                }
                buff.append(r);
                buff.append(c);
            }
            else if(m.equalsIgnoreCase("D")){
                r++;
                if(r>maxRow){
                    r=0;
                }
                buff.append(r);
                buff.append(c);
            }
            
            
            if(gameOver(coordinates,buff.toString())){
               System.out.println("Game Over");
                break;
            }
            
            movecounter++;
            coordinates.add(buff.toString());
            if(movecounter<5){
                coordinates.poll();
            }
            if (movecounter==5){
                movecounter=0;
            }
            System.out.println("Snake coordinates  -- ");
        
            for(String s1:coordinates){
                System.out.print(s1+" ");
            }
        }
        
    
        
    }
     public static boolean gameOver(Queue<String> coordiantes, String current){
        if(coordiantes.contains(current)){
            return true;
        }
        else {
            return false;
        }
     }
    
}
