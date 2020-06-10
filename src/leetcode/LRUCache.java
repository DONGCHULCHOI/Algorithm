package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    // a hashmap that keeps track of the keys and its values in the double linked list
    // results in O(1) time for put and get operations
    // head direction is MRU, tail direction is LRU
    // T.C: O(1) for both put and get
    // S.C: O(capacity) for both map and linkedlist
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        tail = new DLinkedNode();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // T.C: O(1)
        DLinkedNode node = cache.get(key); // O(1)
        if (node == null) return -1;

        // move the accessed node to the head => MRU // *****
        moveToHead(node); // O(1)

        return node.value;
    }

    public void put(int key, int value) {
        // T.C: O(1)
        DLinkedNode node = cache.get(key); // O(1)

        if(node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode); // O(1)
            addNode(newNode); // O(1)

            size++;

            if(size > capacity) { // when full, delete the LRU
                // pop the tail == LRU
                DLinkedNode tail = popTail(); // O(1)
                cache.remove(tail.key); // O(1)
                size--;
            }
        } else {
            // update the value to head
            node.value = value;
            moveToHead(node); // O(1)
        }
    }

    private void addNode(DLinkedNode node) {
        // T.C: O(1)
        // Always add the new node right after head
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node){
        // T.C: O(1)
        // Remove an existing node from the linked list
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DLinkedNode node){
        // T.C: O(1)
        // Move certain node in between to the head
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail() {
        // T.C: O(1)
        // Pop the current tail.
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */










