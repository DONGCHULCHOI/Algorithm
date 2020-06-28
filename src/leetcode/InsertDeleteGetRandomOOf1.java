package leetcode;

import java.util.*;

public class InsertDeleteGetRandomOOf1 {
    // T.C:
    //  GetRandom is always O(1) because this is done by arraylist
    //  Insert and Delete both have average O(1) because this is done together by map,
    //  and Insert and Delete in the worst case, O(N) because when exceeds the capacity of currently allocated array/hashmap and invokes space reallocation
    // S.C: O(N) where N is the number of elements

    // The idea of GetRandom is to choose a random index and then to retrieve an element with that index.
    // Hashmap provides Insert and Delete in average constant time, although has problems with GetRandom because there is no indexes in hashmap
    // Array List has indexes and could provide Insert and GetRandom in average constant time, though has problems with Delete.
    // To delete a value at arbitrary index takes linear time. The solution here is to always delete the last value
    // has to compute an index of each element in constant time, and hence needs a hashmap which stores element -> its index dictionary.
    // 1st. Swap the element to delete with the last one.
    // 2nd. Pop the last element out.
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random rand;
    /** Initialize your data structure here. */
    public InsertDeleteGetRandomOOf1() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) { // O(1)
        if (map.containsKey(val))   return false;
        map.put(val, list.size()); // list.size() is index of val // order is important // *****
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) { // O(1)
        if(!map.containsKey(val))   return false;
        // 1st. Swap the element to delete with the last one.
        // 2nd. Pop the last element out.
        int last = list.get(list.size() - 1);
        int idx = map.get(val);
        // swap // don't have to update last with the val // anyway, it will be gone
        list.set(idx, last);
        map.put(last, idx);
        // remove
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() { // O(1)
        return list.get(rand.nextInt(list.size())); // *****
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
