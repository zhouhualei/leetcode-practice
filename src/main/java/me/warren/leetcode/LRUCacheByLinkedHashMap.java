package me.warren.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by warzhou1 on 4/19/15.
 * Problem 146
 * Make use of LinkedHashMap to implement a LRUCache
 */
public class LRUCacheByLinkedHashMap {

    private Map linkedMap;

    public LRUCacheByLinkedHashMap(final int capacity) {
        linkedMap = new LinkedHashMap<Integer, Integer>(capacity, 1, true) {
            protected boolean removeEldestEntry (Map.Entry<Integer, Integer> eldest){
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        Object value = linkedMap.get(key);
        if (value == null) {
            return -1;
        }
        return (Integer)value;
    }

    public void set(int key, int value) {
        linkedMap.put(key, value);
    }

}

