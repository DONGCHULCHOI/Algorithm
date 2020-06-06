package leetcode;

import java.util.*;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        // T.C: O(nlog n)
        // S.C: O(n) if merge sort / O(log n) if quick sort
        Collections.sort(Arrays.asList(intervals), new IntervalComparator()); // *****

        List<int[]> merged = new LinkedList<>();
        for(int[] interval : intervals){ // *****
            int lastIdx = merged.size()-1;
            if(merged.isEmpty() || merged.get(lastIdx)[1] < interval[0]){
                merged.add(interval);
            }
            else{
                merged.get(lastIdx)[1] = Math.max(merged.get(lastIdx)[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]); //  *****
    }
    private class IntervalComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b){
            return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1; // *****
        }
    }
}
