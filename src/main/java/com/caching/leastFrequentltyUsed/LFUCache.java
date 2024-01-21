package com.caching.leastFrequentltyUsed;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

class LFUCache<K, V> {
    private final int capacity;
    private Map<K, V> cache;
    private Map<K, Integer> keyFrequency;
    private Map<Integer, LinkedHashSet<K>> frequencyLists;
    private int minFrequency;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.keyFrequency = new HashMap<>();
        this.frequencyLists = new HashMap<>();
        this.minFrequency = 0;
    }

    public V get(K key) {
        if (!cache.containsKey(key)) {
            return null;
        }
        int frequency = keyFrequency.get(key);
        keyFrequency.put(key, frequency + 1);

        // Update the frequency list
        frequencyLists.get(frequency).remove(key);
        if (frequency == minFrequency && frequencyLists.get(frequency).isEmpty()) {
            minFrequency++;
        }
        frequencyLists.computeIfAbsent(frequency + 1, k -> new LinkedHashSet<>()).add(key);

        return cache.get(key);
    }

    public void put(K key, V value) {
        if (capacity <= 0) {
            return;
        }

        if (cache.containsKey(key)) {
            cache.put(key, value);
            get(key); // Update the frequency
            return;
        }

        if (cache.size() >= capacity) {
            evictLFU();
        }

        cache.put(key, value);
        keyFrequency.put(key, 1);
        frequencyLists.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        minFrequency = 1;
    }

    private void evictLFU() {
        LinkedHashSet<K> minFreqList = frequencyLists.get(minFrequency);
        K evictKey = minFreqList.iterator().next();
        minFreqList.remove(evictKey);
        cache.remove(evictKey);
        keyFrequency.remove(evictKey);
    }
}
