package leetcode.amazon_google_questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    // T.C: O(N log K)
    // S.C: O(K) to build the heap
    // 215. Kth Largest Element in an Array
    // r.f.
    //  Use QuickSelect approach, T.C is O(N) in the average case, O(N^2) in the worst case
    //  Use Heap approach, T.C is O(N log K)
    //  So Mention that QuickSelect is not stable, and also consider the worst case in general, Heap Approach is better
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> heap = new PriorityQueue<>( // max heap // *****
                points.length, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]);
            }
        }
        );

        for (int[] point : points) { // *****
            heap.add(point);
            if (heap.size() > K){
                heap.remove();
            }
        }

        int[][] ans = new int[K][2];
        while (K-- > 0) ans[K] = heap.poll();
        return ans;
    }
}
