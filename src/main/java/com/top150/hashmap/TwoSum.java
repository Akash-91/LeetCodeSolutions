package com.top150.hashmap;

import java.util.HashMap;

public class TwoSum {


    public static void main(String[] args) {


        int[] nums = {3, 2, 4};
        int target = 6;


        int[] result = twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if the complement is already in the map
            if (numMap.containsKey(complement)) {
                // Return the indices of the two numbers
                return new int[]{numMap.get(complement), i};
            }

            // Put the current element and its index into the map
            numMap.put(nums[i], i);
        }

        // No solution found
        throw new IllegalArgumentException("No two sum solution");
    }
}