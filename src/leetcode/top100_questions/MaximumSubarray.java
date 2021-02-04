package leetcode.top100_questions;

public class MaximumSubarray {
    // Kadane's algorithm:
    // go through array from left to right
    // and calculate local(current) max sum(nums[i]) of subarray at given point; if (nums[i-1] > 0) nums[i] += nums[i-1] // if (nums[i-1] < 0) restart
    // update global max sum of subarray: Math.max(maxSoFar, nums[i])
    // T.C: O(n)
    // S.C: O(1)
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(nums[i-1] > 0)
                nums[i] += nums[i-1];
            maxSoFar = Math.max(maxSoFar, nums[i]);
        }

        return maxSoFar;
    }

    // dp problem:
    // opt[i] = the largest sum of contiguous subarray in nums[0] through nums[i]
    //        = nums[i] += nums[i-1] if nums[i-1] > 0 // local max sum at given index // restart if local max sum < 0
    //          max(opt[i-1], nums[i]) // global max sum
    // T.C: O(n)
    // S.C: O(n) -> can be improved to O(1)
    /*
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
    */
}
