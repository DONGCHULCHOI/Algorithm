package leetcode.amazon_google_questions;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    // T.C: O(n) where n is the length of string s
    // S.C: O(m) where m is the size of the charset
    // Follow the substring template
    // the valid window is when one redundant char pair occurs
    // Valid is counter = 1
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        int counter = 0, begin = 0, end = 0, maxLen = 0;

        while (end < s.length()) { // Find a valid window
            if (map[s.charAt(end)] > 0) counter++;
            map[s.charAt(end)]++;
            end++;

            while (counter > 0) { // Contract till the window becomes invalid
                if (map[s.charAt(begin)] > 1)   counter--;
                map[s.charAt(begin)]--;
                begin++;
            }
            maxLen = Math.max(maxLen, end - begin); // ***** // because finding maximum substring
        }
        return maxLen;
    }
}
