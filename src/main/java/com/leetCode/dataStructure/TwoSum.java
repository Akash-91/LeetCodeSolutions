package com.leetCode.dataStructure;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numIndices = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (numIndices.containsKey(complement)) {
                return new int[]{numIndices.get(complement), i};
            }

            numIndices.put(nums[i], i);
        }

        throw new IllegalArgumentException("No solution found");

    }

    public static void main(String[] args) {

        int[] nums = {3, 2, 4};
        int target = 6;
        TwoSum obj = new TwoSum();
        int[] arr = obj.twoSum(nums, target);
        System.out.println(Arrays.toString(arr));
    }
}
