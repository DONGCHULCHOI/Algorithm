package leetcode.top100_questions;

public class TargetSum {
    // Brute force(backtracking):
    // T.C: O(2^n) because 2-nary tree and the depth is n which is the size of nums
    // S.C: O(n) because the depth of recursion tree is n
    // e.g. [1,1] S=0
    //                  O []
    //                /   \
    //          [+1] O     O [-1] ...
    //              / \
    //    [+1, +1] O   O [+1, -1]
    private int count = 0;

    public int findTargetSumWays(int[] nums, int S) {
        calculate(nums, 0, 0, S);
        return count;
    }

    public void calculate(int[] nums, int idx, int sum, int target) {
        if(idx == nums.length) { // base case
            if(sum == target) {
                count++;
                return;
            }
            return;
        }

        calculate(nums, idx + 1, sum + nums[idx], target);
        calculate(nums, idx + 1, sum - nums[idx], target);
    }
}
