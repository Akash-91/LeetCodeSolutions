package com.top150.arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {


    public static void main(String[] args) {
        int nums[] = {4, 3, 3};
        System.out.println(majorityElement((nums)));

        System.out.println(majorityElement2((nums)));
    }


    public static int majorityElement2(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        // Phase 1: Find a candidate for majority element
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (candidate == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        // Phase 2: Verify if the candidate is the majority element
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        if (count > nums.length / 2) {
            return candidate;
        }

        // The majority element is guaranteed to exist, so we won't reach here
        return -1;
    }


    public static int majorityElement(int[] nums) {

        int me = nums.length / 2;
        int number = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int count = map.get(nums[i]);
                map.put(nums[i], count + 1);
            } else
                map.put(nums[i], 1);
        }


        for (Map.Entry<Integer, Integer> entry :
                map.entrySet()) {
            if (entry.getValue() > me) {
                number = entry.getKey();
            }
        }
        return number;
    }
}
