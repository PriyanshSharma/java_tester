package com.practice.DS.graph;

import java.util.List;

public class AllPathFromSrcToDestination {

	public static void main(String[] args) {
		/*
		 * My graph will look like this -->
		 * 
		 * 	  1-----3
		 *	 /		|\
		 * 	0		| 5
		 * 	 \		|/ \
		 * 	  2-----4	6
		 */	
		
		// This graph is my adjacency list
		
		List<List<Edge>> graph = GraphBasicOperations.createGraph();
		
		allPathFromSourceTodestination(graph);
	}
	
	public static void allPathFromSourceTodestination(List<List<Edge>> graph) {
		
		boolean visisted[] = new boolean[graph.size()];
		 int src = 0 ; 
		 int dest = 5;
		 
		 dfsAllPath(graph, 0, 5, "0", visisted);
	}
	
	public static void dfsAllPath(List<List<Edge>> graph, int curr, int target, String paths, boolean viisted[]){
	
		if (curr==target) {
			System.out.println(paths);
			return;
	
	}
		
		for (Edge e : graph.get(curr)) {
			
			if (!viisted[e.dest()]) {
				viisted[curr] = true;
				dfsAllPath(graph, e.dest(), target, paths+e.dest(), viisted);
				viisted[curr]=false;
			}
		}
		
	}
	
}
