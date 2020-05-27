package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        // (!) try to solve approach 3 next time
        // T.C: O(n) because O(2n)=O(n). In the worst case each character will be visited twice by i and j
        // S.C: O(min(m,n)) *1)
        // sliding window [i,j)
        // first, i, j start with same pos
        // then, try to expand j as many as possible adding a character in the set
        // when j reaches its maximum, then i moves to j removing the character in the set
        // repeat
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while(i < n && j < n){ // ***
            if(!set.contains(s.charAt(j))){ // ***
                set.add(s.charAt(j++)); // ***
                ans = Math.max(ans, j-i); // ***
            }
            else{
                set.remove(s.charAt(i++)); // ***
            }
        }
        return ans;
    }
    // 1) we need O(k)O(k) space for checking a substring has no duplicate characters, where kk is the size of the Set.
    // The size of the Set is upper bounded by the size of the string n and the size of the charset/alphabet m.
}
