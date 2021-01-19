package leetcode.amazon_google_questions;

public class PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        // T.C: O(log N)
        // S.C: O(1)
        int low = 0, high = A.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(A[mid] < A[mid+1]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return low;
    }
}
