package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    // T.C: O(1) for both put and get
    // S.C: O(capacity) for both map and linkedlist
    // Basically use LinkedList and also use HashMAp // *****
    // This is LRU, so we have to use LinkedList; when access the node, move it to the most front or when add new node, add it to the most front
    //                                            then we don't have sort it, this is automatically sorted
    //                                          ; when the buffer is full, remove the most end
    //                                          ; the direction of the head is MRU, and the direction of the tail is LRU
    //                                          ; The node contains key and value
    // Have to offer the operations in O(1), so the case of get() matters; in the linkedlist, it takes O(n)
    // So use HashMap to store the node, then it can offer O(1) for get()
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

    public int get(int key) { // T.C: O(1)
        DLinkedNode node = cache.get(key); // O(1)
        if (node == null) return -1;

        // move the accessed node to the head => MRU // *****
        moveToHead(node); // O(1)

        return node.value;
    }

    public void put(int key, int value) { // // T.C: O(1)
        DLinkedNode node = cache.get(key); // O(1)

        if(node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode); // O(1)
            addNode(newNode); // add the new node to the most front // ***** // O(1)

            size++;

            if(size > capacity) { // when the buffer is full
                DLinkedNode tail = popTail(); // remove the LRU // ***** // O(1)
                cache.remove(tail.key); // O(1)
                size--;
            }
        } else {
            // update the value move to the most front
            node.value = value;
            moveToHead(node); // O(1)
        }
    }

    // Basic operations needed
    private void addNode(DLinkedNode node) {
        // T.C: O(1)
        // Always add the new node to the most front // *****
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node){
        // T.C: O(1)
        // Remove the node
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node){
        // T.C: O(1)
        // Remove the node and add it to the head // *****
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail() {
        // T.C: O(1)
        // Remove LRU node // *****
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res; // *****
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */




















