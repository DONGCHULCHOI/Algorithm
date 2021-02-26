package leetcode.top100_questions;

public class FindFirstAndLastPositionOfElementInSortedArray {
    // Binary Search:
    // T.C: O(log N)
    // S.C: O(1)
    // do binary search to find the leftmost once
    // do binary search to find the rightmost once
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findLeftMost(nums, target);
        res[1] = findRightMost(nums, target);
        return res;
    }

    private int findLeftMost(int[] nums, int target){
        int idx = -1;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                idx = mid;
            }
            if(nums[mid] >= target) { // ***** // to find the leftmost
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }


        }
        return idx;
    }

    private int findRightMost(int[] nums, int target){
        int idx = -1;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                idx = mid;
            }
            if(nums[mid] <= target) { // ***** // to find the rightmost
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }


        }
        return idx;
    }
}
