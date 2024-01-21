package com.caching.maxIdleTime;


import java.util.LinkedHashMap;
import java.util.Map;

class MaxIdleTimeCache<K, V> {
    private int capacity;
    private long maxIdleTime;
    private LinkedHashMap<K, CacheEntry<K, V>> cache;

    public MaxIdleTimeCache(int capacity, long maxIdleTime) {
        this.capacity = capacity;
        this.maxIdleTime = maxIdleTime;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, CacheEntry<K, V>> eldest) {
                long currentTime = System.currentTimeMillis();
                long lastAccessTime = eldest.getValue().getLastAccessTime();
                return (size() > capacity) || (currentTime - lastAccessTime > maxIdleTime);
            }
        };
    }

    public V get(K key) {
        CacheEntry<K, V> entry = cache.get(key);
        if (entry != null) {
            entry.updateAccessTime();
            return entry.getValue();
        }
        return null;
    }

    public void put(K key, V value) {
        cache.put(key, new CacheEntry<>(key, value));
    }
}
