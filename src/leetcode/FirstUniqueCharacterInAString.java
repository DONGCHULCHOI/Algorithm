package leetcode;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        // T.C: O(N), N is the length of string
        // S.C: O(N)
        Map<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();

        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c,0)+1); // *****
        }

        for(int i=0; i<n; i++){
            if(count.get(s.charAt(i)) == 1){ // don't have to worry about the order // *****
                return i;
            }
        }

        return -1;
    }
}
