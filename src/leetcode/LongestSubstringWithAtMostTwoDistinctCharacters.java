package leetcode;

import java.util.Collections;
import java.util.HashMap;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // T.C: O(N) where N is a number of characters in the input string.
        // S.C: O(1) since additional space is used only for a hashmap with at most 3 elements
        // move sliding window along the string, keep not more than 2 distinct characters in the window,
        // and update max substring length at each step
        // hashmap containing all characters in the sliding window as keys and their rightmost positions as values.
        // At each moment, this hashmap could contain not more than 3 elements
        int n = s.length();
        if(n < 3)
            return n;

        int left = 0;
        int right = 0;
        int maxLen = 2; // min
        HashMap<Character, Integer> map = new HashMap<>();
        while(right < n){
            if(map.size() < 3)
                map.put(s.charAt(right), right++);
            if(map.size() == 3){
                int idxTmp = Collections.min(map.values());
                map.remove(s.charAt(idxTmp));
                left = idxTmp + 1;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}
