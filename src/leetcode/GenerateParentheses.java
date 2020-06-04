package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    // Consider T.C. / S.C next time
    public List<String> generateParenthesis(int n) {
        // T.C: 4^n / square root of n
        // S.C: 4^n / square root of n
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n); // n: the number of pairs of parentheses
        return ans;
    }
    public void backtrack(List<String> ans, String curr, int open, int close, int max){
        if(curr.length() == 2*max){ // 2*max == the whole length of the pairs on string
            ans.add(curr);
            return;
        }
        if(open < max){
            backtrack(ans, curr+"(", open+1, close, max);
        }
        if(close < open){
            backtrack(ans, curr+")", open, close+1, max);
        }
    }
}