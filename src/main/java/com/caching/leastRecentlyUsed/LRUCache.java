package com.caching.leastRecentlyUsed;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache<K, V> {
    private long expirationTime;
    private LinkedHashMap<K, CacheEntry<K, V>> cache;

    public LRUCache(int capacity, long expirationTime) {
        this.expirationTime = expirationTime;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            /**
             * without expiration time
             @Override protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
             return size() > capacity;
             }*/

            @Override
            protected boolean removeEldestEntry(Map.Entry<K, CacheEntry<K, V>> eldest) {
                long currentTime = System.currentTimeMillis();
                long entryTime = eldest.getValue().getTimestamp();
                return (size() > capacity) || (currentTime - entryTime > expirationTime);
            }
        };
    }

    public V get(K key) {
        CacheEntry<K, V> entry = cache.get(key);
        if (entry != null) {
            long currentTime = System.currentTimeMillis();
            long entryTime = entry.getTimestamp();
            if (currentTime - entryTime <= expirationTime) {
                return entry.getValue();
            } else {
                cache.remove(key);
            }
        }
        return null;
    }

    public void put(K key, V value) {
        cache.put(key, new CacheEntry<>(key, value));
    }
}