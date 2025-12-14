package com.practice.DS.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphBasicOperations {

	
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
		
		List<List<Edge>> graph = createGraph();
		
		
		for (int i = 0 ; i <=6 ; i++) {
			List<Edge> getEdgeForVert = graph.get(i);
			
			System.out.print("All neighbors for vertex .. "+i);
			
			getEdgeForVert.forEach(e-> System.out.print("  "+e.dest()+" "));
			
			System.out.println();
		}
		
		
		boolean visitedarray [] = new boolean[graph.size()];
		bfsTraversalGraph(graph);
		
		System.out.println("DFS traversal...");
		dfsTraversal(graph, visitedarray, 0);
		
	}
	
	
	public static List<List<Edge>> createGraph() {
		
		List<List<Edge>> graph = new ArrayList<List<Edge>>();
		List<Edge> edgeList = new ArrayList<Edge>();
		
		edgeList.add(new Edge(0, 1));
		edgeList.add(new Edge(0, 2));
		
		// All edges list for 0 vertex added
		graph.add(edgeList);
		
		
		//New list to be created for vertex 1
		edgeList = new ArrayList<Edge>();
		edgeList.add(new Edge(1, 3));
		edgeList.add(new Edge(1, 0));
		// Edge list created for vertex 1
		graph.add(edgeList);
		
		
		
		edgeList = new ArrayList<Edge>();
		edgeList.add(new Edge(2, 0));
		edgeList.add(new Edge(2, 4));
		graph.add(edgeList);
		

		edgeList = new ArrayList<Edge>();
		edgeList.add(new Edge(3, 1));
		edgeList.add(new Edge(3, 4));
		edgeList.add(new Edge(3, 5));
		graph.add(edgeList);
		
		
		edgeList = new ArrayList<Edge>();
		edgeList.add(new Edge(4, 2));
		edgeList.add(new Edge(4, 3));
		edgeList.add(new Edge(4, 5));
		graph.add(edgeList);

		
		
		edgeList = new ArrayList<Edge>();
		edgeList.add(new Edge(5, 3));
		edgeList.add(new Edge(5, 4));
		edgeList.add(new Edge(5, 6));
		graph.add(edgeList);
		
		
		edgeList = new ArrayList<Edge>();
		edgeList.add(new Edge(6, 5));
		graph.add(edgeList);
		

		return graph;
	}
	
	
	
	public static void bfsTraversalGraph(List<List<Edge>> graph) {
		
		
		System.out.println("Starting BFS traversael ---");
		Queue<Integer> verticesQue = new LinkedList<Integer>();
		
		verticesQue.add(0) ;
		System.out.println("Node - "+verticesQue.peek());
	
		boolean visitedArray[]  = new boolean[graph.size()];
		visitedArray[verticesQue.peek()]=true;
		
		
		while (!verticesQue.isEmpty()) {
			int vertex = verticesQue.poll();
			List<Edge> edListForVertex = graph.get(vertex);
			edListForVertex.forEach(e-> {
					if(!visitedArray[e.dest()]) {
						System.out.println("Node - "+e.dest());
						verticesQue.add(e.dest());
						visitedArray[e.dest()]=true;
					}
						
				});
		}
		
	}
	
	
	public static void dfsTraversal(List<List<Edge>> graph , boolean visited[] , int vertex) {
		
		System.out.print(vertex+" ");
		visited[vertex]=true;
	
		for (Edge e : graph.get(vertex)) {
			
			if (!visited[e.dest()]) {
				dfsTraversal(graph, visited, e.dest());
			}
		}
	}
	
	
}

