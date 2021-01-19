package leetcode.amazon_google_questions;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    // Consider make this follow Substring template, especially, Longest Substring with At Most Two Distinct Characters
    // T.C: O(N)
    // S.C: O(1)
    // Same as 159. Longest Substring with At Most Two Distinct Characters
    // Expand till a window is invalid
    // When invalid, Contract the window till valid
    // https://www.youtube.com/watch?v=za2YuucS0tw for the question explaination
    // https://leetcode.com/problems/fruit-into-baskets/discuss/170740/JavaC%2B%2BPython-Sliding-Window-for-K-Elements
    public int totalFruit(int[] tree) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        int res = 0, i = 0;
        for (int j = 0; j < tree.length; j++) {
            count.put(tree[j], count.getOrDefault(tree[j], 0) + 1);
            while (count.size() > 2) {
                count.put(tree[i], count.get(tree[i]) - 1);
                if (count.get(tree[i]) == 0)
                    count.remove(tree[i]);
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
