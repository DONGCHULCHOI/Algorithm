package leetcode.amazon_google_questions;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    // T.C: O(N) where n is the length of s/t
    // S.C: O(1)
    // assume both s and t have the same length
    // The idea is that we need to map a char to another one, for example, "egg" and "add", we need to map 'e' -> 'a' and 'g' -> 'd'.
    // Instead of directly mapping 'e' to 'a', another way is to mark them with same value, for example, 'e' -> 1, 'a'-> 1, and 'g' -> 2, 'd' -> 2, this works same
    // The reason why using 512 may be there are 256 characters in ASCII, 0-127 for basic ASCII, 128-255 for extended ASCII
    // m1, m2 are initialized as 0, to avoid putting 0 into the array (which is the initial value), just put i+1
    // and also, don't have to worry about the increasing index even though the same mapped character pairs
    // e.g. fooo, baar -> f = 1, b = 1, o = 2, a = 2, o = 3, a = 3
    public boolean isIsomorphic(String s, String t) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        return true;
    }
    public boolean isIsomorphicUsingMapClass(String s, String t) {
        // T.C: O(N)
        // S.C: O(N)
        Map<Character, Character> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                if(!map.get(s.charAt(i)).equals(t.charAt(i)))
                    return false;
            }
            map.put(s.charAt(i), t.charAt(i));
        }
        return true;
    }

}
