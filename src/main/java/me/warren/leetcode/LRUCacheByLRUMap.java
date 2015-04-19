package me.warren.leetcode;

import org.apache.commons.collections4.map.LRUMap;

/**
 * Created by warzhou1 on 4/19/15.
 * Problem 146
 * Make use of LRUMap to implement a LRUCache
 */
public class LRUCacheByLRUMap {

    private LRUMap map;

    public LRUCacheByLRUMap(int capacity) {
        map = new LRUMap(capacity);
    }

    public int get(int key) {
        Object value = map.get(key);
        if (value == null) {
            return -1;
        }
        return (Integer) value;
    }

    public void set(int key, int value) {
        map.put(key, value);
    }

}

