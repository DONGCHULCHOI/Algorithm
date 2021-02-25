package leetcode.top100_questions;

public class JumpGame {
    public boolean canJump(int[] nums) {
        // Greedy:
        // T.C: O(n)
        // S.C: O(1)
        // Find the largest subset of indexes where it is possible to get to last from the index
        // Choose the last index considering i + nums[i] >= last
        // After all greedy steps, the result should contain all the indexes in nums and last becomes 0
        int last = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--){
            if(i + nums[i] >= last)
                last = i;
        }
        return last == 0; // when the last becomes 0, then we can jump
    }
}
