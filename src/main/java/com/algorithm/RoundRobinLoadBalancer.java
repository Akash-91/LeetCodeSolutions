package com.algorithm;

import java.util.LinkedList;
import java.util.Queue;

class Server {
    int index;
    int availabilityTime;

    public Server(int index, int availabilityTime) {
        this.index = index;
        this.availabilityTime = availabilityTime;
    }
}


/**
 * It works
 */
public class RoundRobinLoadBalancer {
    public static int[] roundRobin(int n, int[] arrival, int[] burstTime) {
        Queue<Server> servers = new LinkedList<>();
        int[] results = new int[arrival.length];

        for (int i = 1; i <= n; i++) {
            servers.add(new Server(i, 0));
        }

        for (int i = 0; i < arrival.length; i++) {
            int currentArrival = arrival[i];
            int currentBurstTime = burstTime[i];

            while (!servers.isEmpty() && servers.peek().availabilityTime <= currentArrival) {
                Server server = servers.poll();
                results[i] = server.index;
                server.availabilityTime = currentArrival + currentBurstTime;
                servers.add(server);
            }

            if (servers.isEmpty()) {
                results[i] = -1;
            } else {
                Server server = servers.poll();
                results[i] = server.index;
                server.availabilityTime = currentArrival + currentBurstTime;
                servers.add(server);
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
