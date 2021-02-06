package leetcode.top100_questions;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    // bit manipulation
    // T.C: O(n * 2^n)
    // S.C: O(n * 2^n)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();

        // generate bitmask, from 0..00 to 1..11
        int tmp = 1 << nums.length;
        for(int i = 0; i < (int)Math.pow(2, nums.length); i++) { // 0 to 2^n - 1
            String bitmask = Integer.toBinaryString(i | tmp).substring(1); // to cut the leftmost 1

            // append subset corresponding to that bitmask
            List<Integer> curr = new ArrayList<>();
            for(int j = 0; j < nums.length; j++) {
                if(bitmask.charAt(j) == '1')
                    curr.add(nums[j]);
            }
            output.add(curr);
        }
        return output;
    }
}
