package leetcode;

public class MaximumProductSubarray {
    // Try to understand full next time
    // T.C: O(N)
    // S.C: O(1)
    // Recall what we did in Maximum Subarray Sum (Kadane algorithm)
    public int maxProduct(int[] nums) {
        // store the result that is the max we have found so far
        int prodSoFar = nums[0];
        // Due to negative number and property of multiply, we need max and min curr product // *****
        int prodCurrMax = nums[0], prodCurrMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // multiplied by a negative makes big number smaller, small number bigger
            // so swap them to get the maximum product as a result
            if (nums[i] < 0){ // *****
                int tmp = prodCurrMax;
                prodCurrMax = prodCurrMin;
                prodCurrMin = tmp;
            }
            // prodCurrMax/prodCurrMin stores the max/min product of subarray that ends with the current number A[i]
            // max/min product for the current number is either the current number itself or the max/min by the previous number times the current one
            prodCurrMax = Math.max(nums[i], prodCurrMax * nums[i]); // *****
            prodCurrMin = Math.min(nums[i], prodCurrMin * nums[i]); // *****

            // the newly computed max value is a candidate for our global result
            prodSoFar = Math.max(prodSoFar, prodCurrMax);
        }
        return prodSoFar;
    }
}
