package leetcode.top100_questions;

import java.util.HashSet;
import java.util.Set;

public class FindTheDuplicateNumber {
        // T.C: O(n)
        // S.C: O(n)
        public int findDuplicate(int[] nums) {
            Set<Integer> seen = new HashSet<>();
            for(int num : nums) {
                if(seen.contains(num))
                    return num;
                seen.add(num);
            }
            return -1;
        }
}
