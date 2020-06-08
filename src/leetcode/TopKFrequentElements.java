package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    // Consider Quickselect next
    public int[] topKFrequent(int[] nums, int k) {
        // T.C: O(NlogK) when K < N / O(N) where N=k // these are much better than O(NlogN)
        // S.C: O(N+K)
        if(k == nums.length){
            return nums;
        }
        // build hash map : character and how often it appears
        // T.C: O(N)
        // S.C: O(N)
        Map<Integer, Integer> map = new HashMap();
        for (int elem: nums) {
            map.put(elem, map.getOrDefault(elem, 0) + 1);
        }
        // min frequency heap
        PriorityQueue<Integer> heap = new PriorityQueue<>(
                k,
                new Comparator<Integer>(){
                    public int compare(Integer n1, Integer n2){
                        return map.get(n1) - map.get(n2); // *****
                    }
                }
        );

        // keep k top frequent elements in the heap
        // T.C: O(NlogK) < O(NlogN) where K is the size of heap
        // S.C: O(K)
        for (int elem: map.keySet()) {
            heap.add(elem);
            if (heap.size() > k){
                heap.poll();
            }
        }

        // build an output array
        // T.C: O(KlogK)
        // S.C: O(K)
        int[] output = new int[k];
        for(int i=0; i<k; i++){
            output[i] = heap.remove();
        }

        return output;
    }
}
