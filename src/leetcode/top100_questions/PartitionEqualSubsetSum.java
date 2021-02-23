package leetcode.top100_questions;

public class PartitionEqualSubsetSum {
    // DP:
    // T.C: O(m*n)
    // S.C: O(m*n)
    // opt(i,w) = maximum total sum using a subset of the integers {nums[0] ... nums[nums.length-1]} with max allowed target w
    //          = opt(i-1, w) if w < wi
    //          = Max(opt(i-1, w), wi + opt(i-1, w - wi))
    public boolean canPartition(int[] nums) {
        // get target W = totalSum / 2 when partition is possible
        int totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }
        if(totalSum % 2 != 0) { return false; } // if totalSum is odd, it cannot be partitioned into equal sum subset
        int targetW = totalSum / 2;

        int n = nums.length;
        int[][] opt = new int[n+1][targetW+1];

        // initialize first row and column
        for(int i = 0; i <= n; i++) {
            opt[i][0] = 0;
        }
        for(int w = 0; w <= targetW; w++) {
            opt[0][w] = 0;
        }

        for(int i = 1; i <= n; i++) {
            int currW = nums[i-1]; // wi // cuz i go ahead by +1 idx compared to idx of nums
            for(int w = 1; w <= targetW; w++) {
                if(w < currW) {
                    opt[i][w] = opt[i-1][w];
                }
                else {
                    opt[i][w] = Math.max(opt[i-1][w], currW + opt[i-1][w-currW]);
                }
            }
        }
        return opt[n][targetW] == targetW ? true : false;
    }
}
