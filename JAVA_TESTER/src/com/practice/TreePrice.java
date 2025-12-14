package com.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class TreePrice {
    static List<List<Integer>> tree;
    static List<Integer> values;
    static List<Long> price;

    
    public static List<Long> findPrice(int tree_nodes, List<Integer> tree_from, List<Integer> tree_to, List<Integer> a) {
        tree = new ArrayList<>();
        values = a;
        price = new ArrayList<>(Collections.nCopies(tree_nodes + 1, 0L)); // 1-based index

        // Initialize adjacency list (1-based index)
        for (int i = 0; i <= tree_nodes; i++) {
            tree.add(new ArrayList<>());
        }

        // Build the tree (1-based indexing)
        for (int i = 0; i < tree_from.size(); i++) {
            int u = tree_from.get(i);
            int v = tree_to.get(i);
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        // Start DFS from root node (1-based index, assuming node 1 is the root)
        dfs(1, -1);

        // Remove 0th index and return result from 1 to n
        return price.subList(1, tree_nodes + 1);
    }

    private static List<Integer> dfs(int node, int parent) {
    	   List<Integer> subtreeValues = new ArrayList<>();
           subtreeValues.add(values.get(node - 1)); // Convert 1-based index to 0-based for values list

           for (int child : tree.get(node)) {
               if (child != parent) { // Avoid revisiting the parent node
                   List<Integer> childValues = dfs(child, node);
                   subtreeValues.addAll(childValues);
               }
           }

           // Compute price for the current node
           if (subtreeValues.size() >= 2) {
               // Sort the values in descending order
               subtreeValues.sort(Collections.reverseOrder());
               price.set(node, (long) subtreeValues.get(0) * subtreeValues.get(1));
           } else {
               price.set(node, 0L);
           }

           return subtreeValues;  // Return the accumulated subtree values
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] treeNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int treeNodes = Integer.parseInt(treeNodesEdges[0]);
        int treeEdges = Integer.parseInt(treeNodesEdges[1]);

        List<Integer> treeFrom = new ArrayList<>();
        List<Integer> treeTo = new ArrayList<>();

        IntStream.range(0, treeEdges).forEach(i -> {
            try {
                String[] treeFromTo = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                treeFrom.add(Integer.parseInt(treeFromTo[0]));
                treeTo.add(Integer.parseInt(treeFromTo[1]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        List<Long> result = TreePrice.findPrice(treeNodes, treeFrom, treeTo, a);
       System.out.println(result);
       

//        bufferedWriter.write(
//            result.stream()
//                .map(Object::toString)
//                .collect(Collectors.joining("\n"))
//            + "\n"
//        );

        bufferedReader.close();
//        bufferedWriter.close();
    }
   }
