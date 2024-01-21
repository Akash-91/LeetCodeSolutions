package com.top150.arrays;

import java.util.*;

public class RandomizedSet {


    private ArrayList<Integer> nums;
    private HashMap<Integer, Integer> numToIndex;
    private Random rand;

    public RandomizedSet() {
        nums = new ArrayList<>();
        numToIndex = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {

        if (numToIndex.containsKey(val))
            return false;


        else {
            nums.add(val);
            numToIndex.put(val, nums.size() - 1);
            return true;
        }
    }

    public boolean remove(int val) {

        if (!numToIndex.containsKey(val))
            return false;

        int indexToRemove = numToIndex.get(val);
        int lastElement = nums.get(nums.size() - 1);

        // Swap the element to remove with the last element
        nums.set(indexToRemove, lastElement);
        numToIndex.put(lastElement, indexToRemove);

        // Remove the last element and its index mapping
        nums.remove(nums.size() - 1);
        numToIndex.remove(val);

        return true;
    }

    public int getRandom() {
        if (nums.size() > 0) {
            int randomIndex = rand.nextInt(nums.size());
            return nums.get(randomIndex);
        }
        return 0;
    }

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        int val = 20;
        boolean param_1 = obj.insert(val);
        boolean param_2 = obj.remove(val);
        int param_3 = obj.getRandom();
        System.out.println(param_3);
    }
}

