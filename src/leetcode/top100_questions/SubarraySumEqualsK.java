package leetcode.top100_questions;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    // Set/Map:
    // T.C: O(n)
    // S.C: O(1)
    // https://www.youtube.com/watch?v=NqZl2U5MI1Y
    // sum[i,j](k) = sum[0,j] - sum[0,i-1]
    // sum[0,i-1] = sum[0,j] - sum[i,j](k)
    // iterate from left to right, calculate and save sum[0,j]
    // cuz i-1 < j, when iteration done, we can also get sum[0,i-1]
    // e.g. [9, -9(i-1), 8(i), 1(j)], k = 9
    // sum[0,j] = 9
    // map(sum[0,j] => sum[0,i-1]) = {9, 0(v), 8}
    // if there is sum[0,i-1] = sum[0,j] - sum[i,j](k) = 9 - 9 = 0 in the map, there is subarray sum equals k though we don't know the index
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1); // for edge case: sum is equal to k // *****

        for(int j = 0; j < nums.length; j++) {
            sum += nums[j];

            if(map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1); // <K, V> = <sum, count>
        }
        return count;
    }
}
