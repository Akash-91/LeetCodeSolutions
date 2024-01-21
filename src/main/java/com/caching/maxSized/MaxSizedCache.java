package com.caching.maxSized;

import java.util.*;


/**
 * The MaxSizeCache class is similar to the LRU cache implementation shared earlier.
 * It uses the removeEldestEntry method of the LinkedHashMap to check the cache's size and evict the oldest entries when the capacity is reached.
 * ---
 * You can use these cache implementations by creating instances of the respective classes and using the put and get methods to store and retrieve values.
 * Remember to specify the required parameters such as capacity, expiration time, max idle time, or max size based on the eviction strategy you choose.
 * ---
 * Apart from LRU (Least Recently Used), LFU (Least Frequently Used), Max Idle Time, and Max Size eviction strategies,
 * there are several other eviction strategies commonly used in cache implementations. Some of these strategies are:
 * --
 * FIFO (First-In-First-Out):
 * This strategy evicts the oldest entry in the cache. It keeps track of the insertion order of entries and removes the entry that has been in the cache the longest.
 * --
 * LIFO (Last-In-First-Out):
 * This strategy evicts the most recently added entry in the cache. It keeps track of the insertion order of entries and removes the entry that was most recently added.
 * --
 * Random Replacement: This strategy randomly selects an entry from the cache for eviction. It does not consider any specific access pattern or frequency.
 *
 * @param <K>
 * @param <V>
 */
class MaxSizeCache<K, V> {
    private int capacity;
    private LinkedHashMap<K, V> cache;

    public MaxSizeCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > capacity;
            }
        };
    }

    public V get(K key) {
        return cache.get(key);
    }

    public void put(K key, V value) {
        cache.put(key, value);
    }
}
