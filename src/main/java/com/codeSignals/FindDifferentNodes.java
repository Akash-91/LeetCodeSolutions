package com.codeSignals;

import java.util.HashMap;

public class FindDifferentNodes {
    long solution(int[] a, int k) {
        long count = 0;

        // Create a HashMap to store remainders and their frequencies
        HashMap<Integer, Integer> remainderFrequency = new HashMap<>();

        for (int num : a) {
            int remainder = num % k;
            int complement = (k - remainder) % k;

            // Check if the complement exists in the HashMap
            if (remainderFrequency.containsKey(complement)) {
                count += remainderFrequency.get(complement);
            }

            // Update the frequency of the current remainder
            remainderFrequency.put(remainder, remainderFrequency.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        FindDifferentNodes solution = new FindDifferentNodes();
        int[] a = {1, 2, 3, 4, 5};
        int k = 2;
        long result = solution.solution(a, k);
        System.out.println(result);
    }
}
