package leetcode.top100_questions;

public class HouseRobber {
    // DP:
    // T.C: O(n)
    // S.C: O(n)
    // opt(i) = max robbed money from the houses from nums[0] to nums[i]
    //        = max(nums[i] + opt(i-2), opt(i-1));
    //                if rob nums[i]   if not robbed
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return nums[0];
        }
        if(n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] opt = new int[n];
        opt[0] = nums[0];
        opt[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < n; i++) {
            opt[i] = Math.max(nums[i] + opt[i-2], opt[i-1]);
        }

        return opt[n-1];
    }

    /*
    Recursion: => Time exceeded
    T.C: O(2^n)
    S.C: O(n)
    solve subproblems recursively, use those to build upper level problem's solution
    think the given node as root node first, but also consider the given node is one of the subtrees
    related problems: House Robber, House Robber III
    public int rob(int[] nums) {
        return robHelper(0, false, nums);
    }

    public int robHelper(int idx, boolean isLeftRobbed, int[] nums) {
        if(idx == nums.length) {
            return 0;
        }

        if(isLeftRobbed == true) {
            return robHelper(idx+1, false, nums);
        }
        else {
            int rob = nums[idx] + robHelper(idx+1, true, nums);
            int notRob = robHelper(idx+1, false, nums);
            return Math.max(rob, notRob);
        }
    }
    */
}
