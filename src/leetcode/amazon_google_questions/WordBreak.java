package leetcode.amazon_google_questions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreakBacktracking(String s, List<String> wordDict) {
        // Backtracking
        // T.C: O(n^n) e.g aaa
        // S.C: O(n)
        return wordBreakBacktrackingHelper(s, new HashSet(wordDict), 0);
    }
    public boolean wordBreakBacktrackingHelper(String s, Set<String> wordDict, int start){
        if(start == s.length()) return true; // *****

        for(int end = start+1; end<=s.length(); end++){ // *****
            if(wordDict.contains(s.substring(start, end))){ // *****
                if(wordBreakBacktrackingHelper(s, wordDict, end)){
                    return true;
                }
            }
        }
        return false;

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        // Backtracking with memoization
        // even though the backtracking, there are redundants
        // T.C: O(n^2) because the the num of childs becomes roughly O(n-1) at each level and the depth is n
        // S.C: O(n) because the depth of recursion tree can go up to nn.
        return wordBreakHelper(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
    }
    public boolean wordBreakHelper(String s, Set<String> wordDict, int start, Boolean[] memo){
        if(start == s.length()) return true;

        if(memo[start] == null){
            for(int end = start+1; end<=s.length(); end++){
                if(wordDict.contains(s.substring(start, end))){
                    if(wordBreakHelper(s, wordDict, end, memo)){
                        return memo[start] = true;
                    }
                }
            }
        }
        return memo[start] = false;
    }
}
