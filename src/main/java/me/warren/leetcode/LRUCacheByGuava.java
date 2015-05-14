package me.warren.leetcode;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * Created by warzhou1 on 4/19/15.
 * Problem 146
 * Make use of Guava CacheBuilder to implement a LRUCache
 */
public class LRUCacheByGuava {

    private Cache<Integer, Integer> cache;

    public LRUCacheByGuava(int capacity) {
        cache = CacheBuilder.newBuilder().maximumSize(capacity).build();
    }

    public int get(int key) throws Exception {
        Object value = cache.getIfPresent(key);
        if (value == null) {
            return -1;
        }
        return (Integer) value;
    }

    public void set(int key, int value) {
        cache.put(key, value);
    }

}

