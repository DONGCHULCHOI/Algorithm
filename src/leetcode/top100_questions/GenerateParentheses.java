package leetcode.top100_questions;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    // Backtracking:
    // Consider T.C. / S.C next time
    // T.C: 4^n / square root of n
    // S.C: 4^n / square root of n
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0, 0, n); // n: the number of pairs of parentheses
        return res;
    }

    public void backtrack(List<String> res, String assignment, int open, int close, int numOfPairs){
        if(assignment.length() == 2 * numOfPairs){ // *****
            res.add(assignment);
            return;
        }

        if(open < numOfPairs){ // *****
            backtrack(res, assignment + "(", open + 1, close, numOfPairs);
        }

        if(close < open){ // *****
            backtrack(res, assignment + ")", open, close + 1, numOfPairs);
        }
    }
}
