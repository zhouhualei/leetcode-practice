package me.warren.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by warzhou1 on 4/18/15.
 * Problem 146
 */
public class LRUCache {

    private Map hash;
    private int capacity;

    private LinkedNode head;
    private LinkedNode tail;

    public LRUCache(int capacity) {
        this.hash = new HashMap<Integer, LinkedNode>(capacity);
        this.head = null;
        this.tail = null;
        this.capacity = capacity;
    }

    public int get(int key) {
        LinkedNode node = (LinkedNode) this.hash.get(key);
        if (node != null) {
            moveToHead(node);

            return node.value;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if (size() > 0 && size() == capacity && this.hash.get(key) == null) {
            // remove the tail node
            this.hash.remove(this.tail.key);
            this.tail = this.tail.prev;
        }

        if (size() > 0) {
            if (this.hash.get(key) == null) {
                LinkedNode newNode = new LinkedNode(key, value);
                this.hash.put(key, newNode);
                addToHead(newNode);
            } else {
                LinkedNode oldNode = (LinkedNode) this.hash.get(key);
                oldNode.value = value;
                moveToHead(oldNode);
            }
        } else {
            LinkedNode newNode = new LinkedNode(key, value);
            this.head = newNode;
            this.tail = newNode;
            this.hash.put(key, newNode);
        }
    }

    private int size() {
        return this.hash.size();
    }

    private void addToHead(LinkedNode node) {
        node.next = this.head;
        this.head.prev = node;
        this.head = node;
    }

    private void moveToHead(LinkedNode node) {
        if (node != this.head) {

            // remove from old position
            node.prev.next = node.next;
            if (node == this.tail) {
                this.tail = node.prev;
            } else {
                node.next.prev = node.prev;
            }

            addToHead(node);
        }
    }

}

class LinkedNode {
    int key;
    int value;
    LinkedNode prev;
    LinkedNode next;

    public LinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}


