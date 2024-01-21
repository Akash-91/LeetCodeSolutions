package com.leetCode.dataStructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllOneMap {

    private Map<String, Integer> keyCountMap;
    private Map<Integer, Set<String>> countKeyMap;
    private int minCount;
    private int maxCount;

    public AllOneMap() {
        keyCountMap = new HashMap<>();
        countKeyMap = new HashMap<>();
        minCount = 0;
        maxCount = 0;
    }

    public void inc(String key) {
        int currentCount = keyCountMap.getOrDefault(key, 0); // get the existing count of the key, for new key it will be 0
        int newCount = currentCount + 1; // increase it by 1
        keyCountMap.put(key, newCount); // put it in the map


        // now check if they countKey map has this count  as a key or not , if not than for this count add this input value to hashset
        if (!countKeyMap.containsKey(newCount)) {
            countKeyMap.put(newCount, new HashSet<>());
        }
        countKeyMap.get(newCount).add(key);
        if (currentCount > 0) {
            countKeyMap.get(currentCount).remove(key);
            if (countKeyMap.get(currentCount).isEmpty()) {
                countKeyMap.remove(currentCount);
            }
        }

        if (newCount > maxCount) {
            maxCount = newCount;
        }

        if (currentCount == minCount && countKeyMap.get(currentCount) == null) {
            minCount++;
        }

    }

    public void dec(String key) {
        if (!keyCountMap.containsKey(key)) {
            return;
        }

        int currentCount = keyCountMap.get(key);
        int newCount = currentCount - 1;
        keyCountMap.put(key, newCount);

        if (newCount > 0) {
            if (!countKeyMap.containsKey(newCount)) {
                countKeyMap.put(newCount, new HashSet<>());
            }
            countKeyMap.get(newCount).add(key);
        } else {
            keyCountMap.remove(key);
        }

        countKeyMap.get(currentCount).remove(key);
        if (countKeyMap.get(currentCount).isEmpty()) {
            countKeyMap.remove(currentCount);
        }

        if (currentCount == maxCount && countKeyMap.get(currentCount).isEmpty()) {
            maxCount--;
        }

        if (newCount < minCount) {
            minCount = newCount;
        }
    }

    public String getMaxKey() {
        return maxCount > 0 ? countKeyMap.get(maxCount).iterator().next() : "";
    }

    public String getMinKey() {
        return minCount > 0 ? countKeyMap.get(minCount).iterator().next() : "";
    }

    public static void main(String[] args) {

        AllOneMap allOne = new AllOneMap();
        allOne.inc("hello");
        allOne.inc("hello");
        System.out.println(allOne.getMaxKey()); // return "hello"
        System.out.println(allOne.getMinKey()); // return "hello"
        allOne.inc("leet");
        System.out.println(allOne.getMaxKey()); // return "hello"
        System.out.println(allOne.getMinKey()); // return "leet"

    }
}
