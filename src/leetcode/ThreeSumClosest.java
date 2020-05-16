package leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        // T.C: O(n^2)
        // S.C: O(log n) if quick / O(n) if merge
        // use Two Sum II & 3Sum
        // need sorted array
        // assume that each input would have exactly one solution
        // when compare, use absolute, when save, don't use absolute
        Arrays.sort(nums); // ***
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            int lo = i+1;
            int hi = nums.length - 1;
            while(lo < hi){
                int sum = nums[i] + nums[lo] + nums[hi];
                if(Math.abs(target-sum) < Math.abs(diff)){ // ***
                    diff = target - sum; // ***
                }

                if(sum < target){
                    lo++;
                }
                else if(sum > target){
                    hi--;
                }
                else{ // ***
                    break;
                }
            }
            if (target <= nums[i]){ // *** because the array is sorted*1)
                break;
            }
        }
        return target - diff; // == sum
    }
/*
1) Since the array is sorted, and target <= nums[i], the closest you can get to the target is nums[i] + nums[i+1] + nums[i+2]. So, no need to process after nums[i].
*/
}
