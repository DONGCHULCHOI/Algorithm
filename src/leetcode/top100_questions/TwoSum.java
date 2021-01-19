package leetcode.top100_questions;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target){
        // one pass hash table
        // T.C: O(n)
        // S.C: O(n) *1)
        // 1) The extra space required depends on the number of items stored in the hash table, which stores at most n elements
        // assume that each input would have exactly one solution
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int complement = target - nums[i]; // *****
            if(map.containsKey(complement)){ // *****
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i); // key: nums[i], value: index // *****
        }
        return null;
    }
}
