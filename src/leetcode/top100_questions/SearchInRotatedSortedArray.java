package leetcode.top100_questions;

public class SearchInRotatedSortedArray {
    private int [] nums;
    private int target;

    public int search(int[] nums, int target) {
        // T.C: O(log n)
        // S.C: O(1)
        this.nums = nums;
        this.target = target;

        int n = nums.length;
        if (n == 0)
            return -1;
        if (n == 1)
            return this.nums[0] == target ? 0 : -1;

        int rotateIndex = findRotateIndex(0, n - 1);
        if (nums[rotateIndex] == target){ // if target is the smallest element
            return rotateIndex;
        }

        if (rotateIndex == 0){ // if array is not rotated
            return binarySearch(0, n - 1);
        }
        else{ // if array is rotated // compare with 1st element of array // *****
            if (target >= nums[0]){ // *****
                return binarySearch(0, rotateIndex-1); // search in the left side of rotateIndex
            }
            else{
                return binarySearch(rotateIndex+1, n-1); // search in the right side of rotateIndex
            }
        }
    }

    public int findRotateIndex(int low, int high) {
        // Find a pivot // *****
        // Binary search
        // nums[mid] > nums[mid+1] && compare mid with low is two key point // *****
        if (nums[low] < nums[high]){ // the case of not rotated
            return 0;
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[mid + 1]){ // e.g. [4,5,6,1,2,3]
                return mid + 1;
            }
            if (nums[mid] < nums[low]){ // e.g. [5,6,1,2,3,4]
                high = mid - 1;
            }
            else{ // e.g. [3,4,5,6,1,2]
                low = mid + 1;
            }
        }
        return -1;
    }

    public int binarySearch(int low, int high) {
        // Binary search
        while (low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if (nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}
