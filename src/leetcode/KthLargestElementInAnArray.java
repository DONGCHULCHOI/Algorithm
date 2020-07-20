package leetcode;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        // T.C: O(NlogK) where K is as in the Kth largest element, and is also the size of heap
        // S.C: O(K)
        // CSCI 570 Notes has same question
        // r.f.
        //  Use QuickSelect approach, T.C is O(N) in the average case, O(N^2) in the worst case
        //  Use Heap approach, T.C is O(N log K)
        //  So Mention that QuickSelect is not stable, and also consider the worst case in general, Heap Approach is better
        PriorityQueue<Integer> heap = new PriorityQueue<>(); // min heap // *****
        // keep k largest elements in the heap, As a result, the top becomes the k th largest element
        for(int elem : nums){
            heap.add(elem);
            if(heap.size() > k){
                heap.remove();
            }
        }
        return heap.remove();
    }
}
