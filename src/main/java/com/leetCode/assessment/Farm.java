package com.leetCode.assessment;

import java.util.HashMap;
import java.util.Map;

public class Farm {



    public int totalFruit(int[] fruits) {
        int maxFruits = 0;
        int left = 0;
        Map<Integer, Integer> fruitCount = new HashMap<>(); // Map to store fruit counts

        for (int right = 0; right < fruits.length; right++) {

            fruitCount.put(fruits[right], fruitCount.getOrDefault(fruits[right], 0) + 1);

            while (fruitCount.size() > 2) {
                fruitCount.put(fruits[left], fruitCount.get(fruits[left]) - 1);
                if (fruitCount.get(fruits[left]) == 0) {
                    fruitCount.remove(fruits[left]);
                }
                left++;
            }

            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2};

        System.out.println(new Farm().totalFruit(arr));
    }
}
