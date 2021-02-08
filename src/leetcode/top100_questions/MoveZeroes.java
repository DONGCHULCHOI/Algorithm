package leetcode.top100_questions;

public class MoveZeroes {
    // T.C: O(n)
    // S.C: O(1)
    public void moveZeroes(int[] nums) {
        int ptr = 0; // the last non zero boundary

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[ptr++] = nums[i];
            }
        }

        for(int i = ptr; i < nums.length; i++) {
            nums[i] = 0;
        }

    }
}
