package leetcode.top100_questions;

public class SortColors {
    public void sortColors(int[] nums) {
        // Array:
        // related problem: Move Zeroes, Sort Colors
        // T.C: O(n)
        // S.C: O(1)
        int ptr1 = 0; // the right most zeros boundary
        int ptr2 = nums.length - 1; // the left most twos boundary
        int curr = 0;

        while(curr <= ptr2) {
            if(nums[curr] == 0) {
                int tmp = nums[ptr1];
                nums[ptr1++] = nums[curr];
                nums[curr++] = tmp;
            }
            else if(nums[curr] == 2) {
                int tmp = nums[ptr2];
                nums[ptr2--] = nums[curr];
                nums[curr] = tmp; // ***** // do not increase curr to check the swapped one at the pos again
            }
            else {
                curr++;
            }
        }
    }
}
