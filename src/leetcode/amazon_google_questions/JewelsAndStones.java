package leetcode.amazon_google_questions;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        // O(J + S) where J is the length of J, S is the length of S
        // O(J)
        Set<Character> types = new HashSet<>();
        for(char j : J.toCharArray())
            types.add(j);

        int ans = 0;
        for(char s : S.toCharArray()){
            if(types.contains(s))
                ans++;
        }
        return ans;
    }
}
