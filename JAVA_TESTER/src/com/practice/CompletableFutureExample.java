package com.practice;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {

	
	
	public static void main(String[] args) {
		
		CompletableFuture<String> m1Invoker = CompletableFuture.supplyAsync(()-> "This is my m1 task");
		CompletableFuture<String> m2Invoker = CompletableFuture.supplyAsync(()-> "This is my m2 task");
		CompletableFuture<String> m3Invoker = CompletableFuture.supplyAsync(()-> "This is my m3 task");
		
		
		CompletableFuture.allOf(m1Invoker,m2Invoker,m3Invoker).join();
		
		System.out.println("Completed...");
		
		
		
	}
}
