package leetcode.top100_questions;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        // Binary Search:
        // related problems: Two Sum II, Three Sum
        // T.C: O(n)
        // S.C: O(1)
        // two pointer // *****
        // only when sorted // *****
        // assume that each input would have exactly one solution
        // r.f.
        // Two Sum solution can be used
        // but Two Sum time complexity : T.C: O(n) S.C: O(n)
        int low = 0;
        int high = numbers.length-1;
        while(low < high){ // ***** // don't have to go through the sum of the same position
            int sum = numbers[low] + numbers[high];
            if(sum == target){
                return new int[]{low+1, high+1};
            }
            if(sum < target){ // ***
                low++;
            }
            else{ // ***
                high--;
            }
        }
        return null;
    }
}
