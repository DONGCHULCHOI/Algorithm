package leetcode.top100_questions;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    // Heap:
    // T.C: O(n log k)
    // S.C: O(Math.max(n, k))
    public int[] topKFrequent(int[] nums, int k) {
        if(k == nums.length){
            return nums;
        }

        Map<Integer, Integer> map = new HashMap(); // <K,V> = <num, frequency>
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Top K -> need Min heap of size K
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b)); // sort frequency in ascending order
        // make the size of k Min heap, and iterate n-k elements, and compare it with top of the heap, if the element is bigger than top, replace it
        for (int num : map.keySet()) {
            heap.add(num);
            if (heap.size() > k){
                heap.remove();
            }
        }

        int[] output = new int[k];
        for(int i=0; i<k; i++){
            output[i] = heap.remove();
        }

        return output;
    }
}
