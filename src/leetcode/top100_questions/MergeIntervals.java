package leetcode.top100_questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        // T.C: O(nlog n)
        // S.C: O(n) if merge sort / O(log n) if quick sort
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); // *****
        List<int[]> merged = new LinkedList<>();

        for(int[] interval : intervals){
            int lastIdx = merged.size()-1;

            if(merged.isEmpty() || merged.get(lastIdx)[1] < interval[0]){ // if there is no interval
                merged.add(interval);
            }
            else{ // if there is interval
                merged.get(lastIdx)[1] = Math.max(merged.get(lastIdx)[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]); // *****
    }
}
