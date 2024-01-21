package com.algorithm;

import java.util.ArrayDeque;
import java.util.Queue;

public class RoundRobinLoadBalancer3 {
    public static int[] roundRobin(int n, int[] arrival, int[] burstTime) {
        int m = arrival.length;
        int[] results = new int[m];
        Queue<Integer> availableServers = new ArrayDeque<>();
        int[] nextAvailableTime = new int[n];

        for (int i = 0; i < n; i++) {
            availableServers.offer(i + 1);
        }

        for (int i = 0; i < m; i++) {
            int requestArrival = arrival[i];
            int requestBurstTime = burstTime[i];

            while (!availableServers.isEmpty() && requestArrival >= nextAvailableTime[availableServers.peek() - 1]) {
                int assignedServer = availableServers.poll();
                results[i] = assignedServer;
                nextAvailableTime[assignedServer - 1] = requestArrival + requestBurstTime;
            }

            if (results[i] == 0) {
                results[i] = -1; // Request dropped
            }
        }

        return results;
    }

    public static void main(String[] args) {
        int n = 2;
        int[] arrival = {2, 2, 2, 3};
        int[] burstTime = {1, 3, 1, 2};

        int[] results = roundRobin(n, arrival, burstTime);

        for (int result : results) {
            System.out.print(result + " ");
        }
        System.out.println();
    }
}
