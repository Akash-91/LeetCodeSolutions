package com.algorithm;

import java.util.*;

class Server2 {
    int index;
    int availableAt;

    Server2(int index, int availableAt) {
        this.index = index;
        this.availableAt = availableAt;
    }
}


/**
 * It doesn't work
 */
public class RoundRobinLoadBalancer2 {

    public static List<Integer> roundRobinLoadBalancing(int n, int m, int[] arrival, int[] burstTime) {
        List<Integer> result = new ArrayList<>();
        List<Server2> servers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            servers.add(new Server2(i, 0));
        }

        for (int i = 0; i < m; i++) {
            int currentRequestArrival = arrival[i];
            int currentRequestBurstTime = burstTime[i];
            boolean assigned = false;

            for (Server2 server : servers) {
                if (server.availableAt <= currentRequestArrival) {
                    result.add(server.index);
                    server.availableAt = currentRequestArrival + currentRequestBurstTime;
                    assigned = true;
                    break;
                }
            }

            if (!assigned) {
                result.add(-1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 2;
        int[] arrival = {2, 2, 2, 3};
        int[] burstTime = {1, 3, 1, 2};

        List<Integer> output = roundRobinLoadBalancing(n, 4, arrival, burstTime);
        System.out.println(output);  // Output: [1, 2, 1, 3, 2]
    }
}
