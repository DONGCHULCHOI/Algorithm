package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        // T.C: O(n) where n is the length of the nums
        // S.C: O(1)
        // https://leetcode.com/problems/missing-ranges/discuss/50468/Accepted-Java-solution-8-lines-and-0ms
        // 1st. Iterate a elem, then compare it with lower, if the elem is bigger than the lower, then it finds the missing ranges, if not, skip it
        // 2nd. Update the lower with the elem + 1
        // 3rd. After the iteration, deal with the last missing ranges
        // (!) the case of last elem is upper bound
        // (!) the case of last elem is 2^31 -1
        // when less than the elem, add it to the res list // *****
        // deal with the upper after the loop // *****
        List<String> res = new ArrayList<>();

        for(int elem : nums) {
            if(elem > lower) // *****
                res.add(lower + ((elem-1 > lower) ? "->" + (elem-1) : ""));
            if(elem == upper) // To Avoid overflow and deal with the case when the last element is upper bound // *****
                return res;
            lower = elem+1; // ***** // overflow could be caused here
        }
        res.add(lower + ((upper > lower) ? "->" + (upper) : "")); // *****
        return res;
    }
}