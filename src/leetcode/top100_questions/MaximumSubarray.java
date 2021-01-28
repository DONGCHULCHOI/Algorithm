package leetcode.top100_questions;

public class MaximumSubarray {
    // dp problem:
    // opt[i] = the largest sum of contiguous subarray in nums[0] through nums[i]
    //        = nums[i] += nums[i-1] if nums[i-1] > 0 // local max sum // restart if local max sum < 0
    //          max(opt[i-1], nums[i]) // global max sum
    // T.C: O(n)
    // S.C: O(n) -> can be improved to O(1)
    public int maxSubArray(int[] nums) {
        int[] opt = new int[nums.length];
        opt[0] = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(nums[i-1] > 0)
                nums[i] += nums[i-1];
            opt[i] = Math.max(opt[i-1], nums[i]);
        }

        return opt[nums.length-1];
    }
}
