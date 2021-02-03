package leetcode.top100_questions;

public class MoveZeroes {
    // T.C: O(n)
    // S.C: O(1)
    public void moveZeroes(int[] nums) {
        int lastNonZeroFoundIdx = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[lastNonZeroFoundIdx++] = nums[i];
            }
        }

        for(int i = lastNonZeroFoundIdx; i < nums.length; i++) {
            nums[i] = 0;
        }

    }
}
