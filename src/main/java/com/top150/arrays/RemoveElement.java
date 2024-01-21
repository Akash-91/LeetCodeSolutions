package com.top150.arrays;

import static java.util.Arrays.sort;


public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3}; // Input array
        int val = 3; // Value to remove

        int[] expectedNums = {2, 2}; // The expected answer with correct length.
        // It is sorted with no values equaling val.
        int k = removeElement(nums, val); // Calls your implementation
        assert k == expectedNums.length;
        sort(nums, 0, k); // Sort the first k elements of nums


        int actualLength = nums.length;
        for (int i = 0; i < actualLength; i++) {
            assert nums[i] == expectedNums[i];
        }
    }

    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
