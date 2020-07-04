package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // T.C: O(n^2)
        // S.C: O(log n) if quick / O(n) if merge
        // use Two Sum II // *****
        // should be sorted // *****
        // If the current value is greater than zero, break from the loop. Remaining values cannot sum to zero // *****
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length && nums[i] <= 0; i++){ // ***** // if nums[i] > 0, then the sum cannot be zero -> for the performance
            if(i == 0 || nums[i] != nums[i-1]){ // *****
                // prevent the repetition, e.g. 0 0 -1 1
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
            if(sum < 0 || (lo > i+1 && nums[lo] == nums[lo-1])){ // ***** // right part condition occurs when sum is 0 // prevent the repeition // e.g -2 0 0 2 2
                lo++;
            }
            else if(sum > 0){ // hi < nums.length-1 && nums[hi] == nums[hi+1]) -> don't have to deal with it, because the above did it // *****
                hi--;
            }
            else{ // compared to Two Sum II, it should be located here because there is no return, which triggers Time Exceeded
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--])); // *****
            }
        }
    }
}
