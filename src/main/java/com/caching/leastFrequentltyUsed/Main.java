package com.caching.leastFrequentltyUsed;

public class Main {
    public static void main(String[] args) {
        LFUCache<String, Integer> cache = new LFUCache<>(3);

        cache.put("A", 1);
        cache.put("B", 2);
        cache.put("C", 3);

        System.out.println(cache.get("A")); // Output: 1
        System.out.println(cache.get("B")); // Output: 2

        cache.put("D", 4); // Evicts "C"

        System.out.println(cache.get("C")); // Output: null (evicted)
        System.out.println(cache.get("D")); // Output: 4
    }
}
