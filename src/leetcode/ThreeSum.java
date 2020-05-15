package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // T.C: O(n^2)
        // S.C: O(log n) if quick / O(n) if merge
        // use Two Sum II
        // should be sorted
        // diff b\w SumTwoII: not only one solution
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length && nums[i] <= 0; i++){ // ***
            if(i == 0 || nums[i] != nums[i-1]){ // *** because not only one solution
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
            if(sum < 0 || (lo > i+1 && nums[lo] == nums[lo-1])){ // *** because not only one solution
                lo++;
            }
            else if(sum > 0 || (hi < nums.length-1 && nums[hi] == nums[hi+1])){ // *** because not only one solution
                hi--;
            }
            else{
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--])); // Arrays.asList's T.C: O(1)
            }
        }
    }
}
