package leetcode.amazon_google_questions;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        // T.C: O(N)
        // S.C: O(1)
        // Bascially, the values of the nums are put onto the graph looks like /\ // *****
        // If the given permutation is the last one in lexicographical order, then the graph looks like \ // *****
        // From the end, find the first decreasing elem, a[i] // *****
        // swap this with the smallest one larger than this, a[j] // *****
        // reverse the number from a[i+1] to a[nums.length-1] // *****
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i+1])   i--; // if i == -1 which is the graph looks like \ -> rearrange it as the lowest possible order at (A)
        // conditions' order // *****

        if(i >= 0){
            int j = nums.length - 1; // to find j starting from the end because lexicographically sorted increasingly // *****
            while(nums[j] <= nums[i]){
                j--;
            }
            swap(nums, i, j); // *****
        }
        reverse(nums, i+1); // (A) // *****
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] nums, int start){
        int i = start, j = nums.length-1;
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
