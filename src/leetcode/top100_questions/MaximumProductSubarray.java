package leetcode.top100_questions;

public class MaximumProductSubarray {
    // Kadane's algorithm
    // T.C: O(n)
    // S.C: O(1)
    // based on 'Maximum Subarray'
    // go through from left to right
    // calculate current(local) max product of subarray at given point:
    //      max of the following
    //      case 1: current number; e.g. [0,4], [-3,5]
    //      case 2: product of currMax and current number; when the accumulated product keep increasing
    //      case 3: product of currMin and current number; when the current number is negative, and the product of two becomes the biggest
    // also keep track of current(local) min product of subarray at given point:
    //      simalar to current max product of subarray
    // update global max product of subarray(maxSoFar)
    public int maxProduct(int[] nums) {
        int maxSoFar = nums[0], currMax = nums[0], currMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tmpMax = Math.max(nums[i], Math.max(currMax * nums[i], currMin * nums[i]));
            currMin = Math.min(nums[i], Math.min(currMax * nums[i], currMin * nums[i]));
            currMax = tmpMax;

            maxSoFar = Math.max(maxSoFar, currMax);
        }
        return maxSoFar;
    }
}
