package com.caching.leastRecentlyUsed;

public class Main {
    public static void main(String[] args) {
        // Create an LRU cache with a capacity of 3 and an expiration time of 1 minute (60000 milliseconds)
        LRUCache<String, Integer> cache = new LRUCache<>(3, 10000);

        cache.put("A", 1);
        cache.put("B", 2);
        cache.put("C", 3);

        System.out.println("----Data Inserted in Map---- A,B,C,D with a expiration time of 10seconds");
        System.out.println("Getting B: " + cache.get("B"));
        System.out.println("Getting C: " + cache.get("C"));

        System.out.println("-------------");
        // Wait for more than 1 minute (to simulate expiration)
        System.out.println("Wait for 10 seconds");
        try {
            Thread.sleep(10001);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("-------------");
        System.out.println("Getting C: " + cache.get("C"));  // Output: null (expired)

        cache.put("D", 4);  // Entry "A" will be evicted due to LRU eviction strategy

        System.out.println("----Data Inserted in Map---- D with a expiration time of 10seconds");

        System.out.println("Getting A: " + cache.get("A"));  // Output: null (evicted)
        System.out.println("Getting D: " + cache.get("D"));  // Output: 4
    }
}
