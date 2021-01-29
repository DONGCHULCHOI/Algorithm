package leetcode.top100_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // T.C: O(n^2)
        // S.C: O(log n) if quick / O(n) if merge
        // use Two Sum II // *****
        // should be sorted // *****
        // The answer is not unique compared TwoSum, TwoSumII // *****
        // Triplet should be unique // *****
        // Have to consider two cases: // *****
        // case 1: pivot can be repeated; ex. [0(pivot) 0 -1 -1]
        // case 2: based on one pivot, low and high can be repeated; ex.[-2(pivot),0,0,2,2]
        Arrays.sort(nums); // *****
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length && nums[i] <= 0; i++){ // ***** // if nums[i] > 0, then the sum cannot be zero -> for the performance
            if(i == 0 || nums[i] != nums[i-1]){ // *****
                // prevent the repetition, e.g. [0,0,-1,1]
                // i == 0 is required to prevent out of index exception, and also trigger the first case of i = 0
                twoSumII(nums, i, res);
            }
        }
        return res;
    }

    void twoSumII(int[] nums, int i, List<List<Integer>> res){
        int lo = i+1;
        int hi = nums.length - 1;
        while(lo < hi){
            int sum = nums[i] + nums[lo] + nums[hi];
            if(sum < 0) {
                lo++;
            }
            else if(sum > 0) {
                hi--;
            }
            else{ // prevent the repeition // compared to Two Sum II, it should be located here because there is no return, which triggers Time Exceeded
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--])); // *****
                while (lo < hi && nums[lo] == nums[lo - 1]) lo++; // ***** // [-2,0,0,2,2]
            }
        }
    }
}
