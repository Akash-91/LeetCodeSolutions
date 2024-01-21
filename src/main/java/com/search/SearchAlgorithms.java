package com.search;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SearchAlgorithms {


    /**
     * Linear search is a simple searching algorithm that iterates through an array or a list to find the target element
     * <p>
     * Time Complexity: O(n) - Linear time, where 'n' is the number of elements in the array or list.
     * In the worst case, you might have to examine every element.
     * Space Complexity: O(1) - Constant space. The algorithm only uses a few variables for bookkeeping.
     *
     * @param arr
     * @param target
     * @return
     */
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Element found, return its index
            }
        }
        return -1; // Element not found
    }

    /**
     * Binary search is a more efficient searching algorithm for sorted arrays. It repeatedly divides the search interval in half.
     * <p>
     * Time Complexity: O(log n) - Logarithmic time, where 'n' is the number of elements in the sorted array. Binary search repeatedly divides the search interval in half.
     * Space Complexity: O(1) - Constant space. Similar to linear search, it uses only a few variables for bookkeeping.
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Element found, return its index
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Element not found
    }


    /**
     * DFS : depth first search
     * Time Complexity: O(V + E), where 'V' is the number of vertices (nodes) and 'E' is the number of edges in the graph or tree. In the worst case, DFS can visit all vertices and edges.
     * Space Complexity: O(V) - The space complexity is determined by the maximum depth of the recursion stack, which is equal to the height of the tree or graph.
     * These are graph traversal algorithms used to search for nodes or vertices in a graph or tree structure.
     */
    public void dfs(int start, LinkedList<Integer>[] adjList) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[adjList.length];
        stack.push(start);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                visited[node] = true;
                // Process node
                for (int neighbor : adjList[node]) {
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    /**
     *
     * Binary First search
     * Time Complexity: O(V + E), where 'V' is the number of vertices (nodes) and 'E' is the number of edges in the graph or tree. Similar to DFS, BFS can visit all vertices and edges in the worst case.
     * Space Complexity: O(V) - Similar to DFS, the space complexity is determined by the maximum number of nodes in the queue, which is usually the nodes at the same level.
     *
     * @param start
     * @param adjList
     */
    public void bfs(int start, LinkedList<Integer>[] adjList) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adjList.length];
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            // Process node
            for (int neighbor : adjList[node]) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }


    public static void main(String[] args) {


        int arr[] = {15, 14, 25, 34, 89, 76, 64, 20, 30, 45};


        // Hashing is used to search for elements in a collection,
        // like HashMap or HashSet, using a hash function to determine the location of the element.
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("apple", 10);
        hashMap.put("banana", 5);

        int value = hashMap.getOrDefault("apple", -1); // Get the value associated with "apple"
        System.out.println("Value of apple: " + value);


    }
}
