package leetcode.top100_questions;

public class LongestIncreasingSubsequence {
    // DP:
    // T.C: O(n^2)
    // S.C: O(n)
    // opt(i) = longest length of increasing subsequence which must include nums[i] in arr[0] ... arr[i] 1)
    //        = max(opt(j)) + 1, 0 <= j < i and nums[i] > nums[j]
    //        = 1, otherwise 2)
    // 1) if opt(i) = longest length of increasing subsequence in arr[0] ... arr[i]
    //              = opt(i-1) + 1 if arr[i-1] < arr[i]
    //              = opt(i-1) otherwise
    //    then we don't know how to fill opt[0] cuz whether nums[0] is included or not
    // 2) e.g. 0, 1, 0(v) -> has to recount from it but there is just this, so 1
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] opt = new int[n];

        opt[0] = 1;

        int maxLen = 1;
        for(int i = 1; i < n; i++) {
            int maxVal = 0; // *****
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    maxVal = Math.max(maxVal, opt[j]); // *****
                }
            }
            opt[i] = maxVal + 1; // *****
            maxLen = Math.max(maxLen, opt[i]);
        }

        return maxLen;
    }
}
