package leetcode.top100_questions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FindAllNumbersDisappearedInAnArray {
        // Set/Map:
        // T.C: O(n)
        // S.C: O(n)
        public List<Integer> findDisappearedNumbers(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < nums.length; i++) {
                set.add(nums[i]);
            }

            List<Integer> result = new LinkedList<>();
            for(int i = 1; i <= nums.length; i++) {
                if(!set.contains(i))
                    result.add(i);
            }
            return result;
        }
}
