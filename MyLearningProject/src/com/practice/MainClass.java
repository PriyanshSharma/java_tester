package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {
	
public static void main(String[] args) {
	
int [][] arr = new int[3][5];

String s="Hello";

String nullStr = null;

if(s.equalsIgnoreCase(nullStr)) {
	System.out.println("asasdas");
}
/*
 * 01234 12345 23456
 */
long sum = 0l;
for(int i = 0 ; i < 3 ; i ++) {
	for(int c = 0 ; c<5 ; c++) {
		arr[i][c]= i+c;
	}
}
List<Double> listDoub = new ArrayList<Double>();
for(int i = 0 ; i < 3 ; i ++) {
	for(int c = 0 ; c<5 ; c++) {
		sum = sum+arr[i][c];
	}
	double avg = sum/3;
	listDoub.add(avg);
	
}
listDoub.forEach(System.out::println);
}
}
