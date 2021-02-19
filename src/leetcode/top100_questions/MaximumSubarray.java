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
}
