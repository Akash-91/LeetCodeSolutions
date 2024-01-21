package com.top150.arrays;

public class GasStation {


    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int result = canCompleteCircuit(gas, cost);
        System.out.println(result);
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = 0;
        int currentGas = 0;
        int startingStation = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i] - cost[i];
            currentGas += gas[i] - cost[i];

            // If running out of gas, reset the starting station to the next station
            if (currentGas < 0) {
                currentGas = 0;
                startingStation = i + 1;
            }
        }

        // If totalGas is non-negative, there exists a solution; return the starting station
        return totalGas >= 0 ? startingStation : -1;
    }
}
