package leetcode.top100_questions;

public class ClimbingStairs {
    // DP:
    // T.C: O(n)
    // S.C: O(n) -> can be improved into O(1)
    // opt(i) = ways to get to top i
    //        = opt(i-1) + opt(i-2)
    public int climbStairs(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }

        int[] opt = new int[n+1]; // idx: 0 -> 0, 1 -> 1, ..., n -> n

        opt[0] = 0;
        opt[1] = 1;
        opt[2] = 2;

        for(int i = 3; i < opt.length; i++) {
            opt[i] = opt[i-1] + opt[i-2];
        }

        return opt[n];
    }
}
