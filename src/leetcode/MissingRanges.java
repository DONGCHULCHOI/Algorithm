package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        // T.C: O(n) where n is the length of the nums
        // S.C: O(1)
        // https://leetcode.com/problems/missing-ranges/discuss/50468/Accepted-Java-solution-8-lines-and-0ms
        // iterate a elem and keep updating lower which is the value of the prev of the elem + 1 // *****
        // when less than the elem, add it to the res list // *****
        // deal with the upper after the loop // *****
        List<String> res = new ArrayList<>();

        for(int elem : nums) { // *****
            if(elem > lower) // *****
                res.add(lower + ((elem-1 > lower) ? "->" + (elem-1) : ""));
            if(elem == upper) // Avoid overflow // *****
                return res;
            lower = elem+1; // overflow could be caused here
        }

        res.add(lower + ((upper > lower) ? "->" + (upper) : "")); // the case of e.g. [], 1, 1

        return res;
    }
}