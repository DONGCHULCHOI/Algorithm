package leetcode;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        // Two Sum II
        // T.C: O(n)
        // S.C: O(1)
        // only when sorted
        // assume that each input would have exactly one solution
        // r.f.
        // Two Sum solution can be used
        // but Two Sum time complexity : T.C: O(n) S.C: O(n)
        int low = 0;
        int high = numbers.length-1;
        while(low < high){ // ***
            int sum = numbers[low] + numbers[high];
            if(sum == target){
                return new int[]{low+1, high+1};
            }
            else if(sum < target){ // ***
                low++;
            }
            else{ // ***
                high--;
            }
        }
        throw new IllegalArgumentException();
    }
}
