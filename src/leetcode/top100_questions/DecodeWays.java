package leetcode.top100_questions;

import java.util.HashSet;
import java.util.Set;

public class DecodeWays {
    // Recursion(backtracking):
    private int count = 0;
    private Set<String> set;

    public int numDecodings(String s) {
        char[] domain = s.toCharArray();
        set = new HashSet<>();
        for(int i = 1; i <= 26; i++) {
            set.add(Integer.toString(i));
        }
        backtracking(s, 0);

        return count;
    }

    private void backtracking(String s, int start) {
        if(start == s.length()) {
            count++;
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = start; i <= start + 1 && i < s.length(); i++) {
            if(i < s.length()) {
                sb.append(s.charAt(i));
            }

            if(set.contains(sb.toString())) {
                backtracking(s, i + 1);
            }
        }
    }
}
