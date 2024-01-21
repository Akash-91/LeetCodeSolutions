package com.caching.maxIdleTime;

class CacheEntry<K, V> {
    private final K key;
    private final V value;
    private long lastAccessTime;

    public CacheEntry(K key, V value) {
        this.key = key;
        this.value = value;
        this.lastAccessTime = System.currentTimeMillis();
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public long getLastAccessTime() {
        return lastAccessTime;
    }

    public void updateAccessTime() {
        lastAccessTime = System.currentTimeMillis();
    }
}
