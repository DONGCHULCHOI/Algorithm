package leetcode.amazon_google_questions;

public class JumpGame {
    public boolean canJump(int[] nums) {
        // T.C: O(n)
        // S.C: O(1)
        // Greedy
        // Iterating right-to-left, for each position check if we can reach a currPosition + nums[currPosition] >= last
        // if possible, update the last, repeat till the last becomes 0
        int last = nums.length - 1;
        for(int i=nums.length-1; i>=0; i--){
            if(i+nums[i] >= last)
                last = i;
        }
        return last == 0; // when the last becomes 0, then we can jump
    }
}
