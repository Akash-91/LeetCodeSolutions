package com.top150.arrays;

public class JumpGame {


    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 1, 4, 3};
        System.out.println(canJump(nums));
    }


    public static boolean canJump(int[] nums) {

        int maxReachable = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReachable) {
                return false; // Current index is not reachable
            }

            maxReachable = Math.max(maxReachable, i + nums[i]);

            if (maxReachable >= nums.length - 1) {
                return true; // Reached the last index
            }
        }
        return false;
    }
}
