package leetcode.amazon_google_questions;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {
    // the whole array is [ 0, ..., n ] and the length of the whole array is n+1 // *****
    // the length of given array(which is input) is n // *****
    // the legnth of given array is the last element n in the whole array // *****
    public int missingNumberHashSet(int[] nums) {
        // HashSet
        // T.C: O(n)
        // S.C: O(n)
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        for(int i=0; i<nums.length+1; i++){ // *****
            if(!set.contains(i))
                return i;
        }
        return -1;
    }
    public int missingNumber(int[] nums) {
        // Gauss - Sum of Arithmetic sequence
        // T.C: O(n)
        // S.C: O(1)
        int expectedSum = (nums.length + 1) * nums.length / 2; // (n+1)*(0+n) / 2 // *****
        int actualSum = 0;
        for(int i=0; i<nums.length; i++){
            actualSum += nums[i];
        }
        return expectedSum - actualSum;
    }
}

