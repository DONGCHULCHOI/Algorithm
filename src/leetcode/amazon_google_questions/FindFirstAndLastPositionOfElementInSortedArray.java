package leetcode.amazon_google_questions;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        // T.C: O(log N)
        // S.C: O(1)
        // do binary search to find the leftmost once
        // do binary search to find the rightmost once
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
            if(nums[mid] >= target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
            if(nums[mid] == target) idx = mid; // ***** // to find the leftmost
        }
        return idx;
    }

    private int findRightMost(int[] nums, int target){
        int idx = -1;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] <= target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
            if(nums[mid] == target) idx = mid; // ***** // to find the rightmost
        }
        return idx;
    }
}