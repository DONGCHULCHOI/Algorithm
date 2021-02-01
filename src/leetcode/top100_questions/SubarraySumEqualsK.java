package leetcode.top100_questions;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    // T.C: O(n)
    // S.C: O(1)
    // https://www.youtube.com/watch?v=NqZl2U5MI1Y
    // sum[i,j] = sum[0,j] - sum[0,i-1]
    // sum[0,i-1] = sum[0,j] - sum[i,j]
    // sum[0,i-1] = sum[0,j] - k
    // map.put(sum[0,i-1]) -> map.containsKey(sum[0,j] - k)
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1); // edge case; ex. [9(ptr), -9, 8, 1]

        for(int i=0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
