package com.top150.arrays;

/**
 * Remove Duplicate From Sorted Array II
 * <p>
 * Input: nums = [1,1,1,2,2,3]
 * Output: 5, nums = [1,1,2,2,3,_]
 * <p>
 * at most 2
 */

public class RemoveDuplicate2 {


    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3}; // Input array
        int[] expectedNums = {1, 1, 2, 2, 3, 0}; // The expected answer with correct length

        int k = removeDuplicates(nums); // Calls your implementation
        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }


    /**
     * * Input: nums = [1,1,1,2,2,3]
     * * Output: 5, nums = [1,1,2,2,3,_]
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;

        if (n <= 2) {
            return n; // If array has 2 or fewer elements, no need to modify.
        }

        int k = 2; //
        for (int i = 2; i < n; i++) {
            if (nums[i] != nums[k - 1] || nums[i] != nums[k - 2]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
