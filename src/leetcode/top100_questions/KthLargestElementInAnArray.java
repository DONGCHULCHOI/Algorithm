package leetcode.top100_questions;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    // Heap:
    // T.C: O(n log k)
    // S.C: O(k)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(); // Top K -> Min heap of size K

        // make the size of k Min heap, and iterate n-k elements, and compare it with top of the heap, if the element is bigger than top, replace it
        for(int num : nums){
            heap.add(num);
            if(heap.size() > k){
                heap.remove();
            }
        }
        // return Top kth element in the Min heap of Size K
        return heap.remove();
    }
}
