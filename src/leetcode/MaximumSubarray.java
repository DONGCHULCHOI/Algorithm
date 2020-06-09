package leetcode;

public class MaximumSubarray {
    public int maxSubArrayBottomUpOriginal(int[] nums) {
        // Tip. draw curr element arr, curr max sum arr, max sum seen so far arr
        // restart if curr max sum < 0
        // in place, curr element arr == nums -> it becomes curr max sum arr
        // T.C: O(N)
        // S.C: O(1)
        int[] memo = new int[nums.length];
        memo[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i-1] > 0){
                nums[i] += nums[i-1];
            }
            memo[i] = Math.max(nums[i], memo[i-1]);
        }
        return memo[nums.length-1];
    }
    public int maxSubArray(int[] nums) {
        // T.C: O(N)
        // S.C: O(1)
        int a = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i-1] > 0){
                nums[i] += nums[i-1];
            }
            a = Math.max(nums[i], a);
        }
        return a;
    }
}
