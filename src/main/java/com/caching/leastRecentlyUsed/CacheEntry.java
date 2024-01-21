package com.caching.leastRecentlyUsed;

class CacheEntry<K, V> {
    private K key;
    private V value;
    private long timestamp;

    public CacheEntry(K key, V value) {
        this.key = key;
        this.value = value;
        this.timestamp = System.currentTimeMillis();
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public long getTimestamp() {
        return timestamp;
    }
}