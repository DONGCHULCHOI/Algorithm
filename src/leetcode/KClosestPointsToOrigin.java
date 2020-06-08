package leetcode;

import java.util.Arrays;

public class KClosestPointsToOrigin {
    // Consider QuickSelect next time
    public int[][] kClosest(int[][] points, int K) {
        // T.C: O(NlogN)
        // S.C: O(N) > O(N) where merge sort/O(logN) when quick sort
        // Fisrt, find the possible maximum value, Kth distance
        int[] dists = new int[points.length];
        for(int i=0; i< dists.length; i++){
            dists[i] = dist(points[i]);
        }
        Arrays.sort(dists);

        // Then iterate, add the possible values into ans
        int[][] output = new int[K][2]; // S.C: in the worst case, O(2*N)
        int t = 0;
        for(int i=0; i<points.length; i++){
            if(dist(points[i]) <= dists[K-1]){
                output[t++] = points[i];
            }
        }
        return output;
    }
    public int dist(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
}
