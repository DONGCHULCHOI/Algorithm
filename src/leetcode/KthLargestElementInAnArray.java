package leetcode;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    // Consider Quick select next time
    public int findKthLargest(int[] nums, int k) {
        // T.C: O(NlogK) > O(NlogN) where K is as in the Kth largest element, and is also the size of heap
        // S.C: O(K)
        // min heap
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        // keep k largest elements in the heap
        // as a result, the top becomes the k th largest element
        for(int elem : nums){
            heap.add(elem);
            if(heap.size() > k){
                heap.remove();
            }
        }
        return heap.remove();
    }
}
