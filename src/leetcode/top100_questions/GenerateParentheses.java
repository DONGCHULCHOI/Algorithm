package leetcode.top100_questions;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    // Brute force(backtracking):
    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtracking(new StringBuilder(), 0, 0, n);
        return res;
    }

    public void backtracking(StringBuilder assignment, int numOfClose, int numOfOpen, int numOfPairs) {
        if(assignment.length() == numOfPairs * 2) {
            res.add(assignment.toString());
            return;
        }

        if(numOfOpen < numOfPairs ) {
            assignment.append("(");
            backtracking(assignment, numOfClose, numOfOpen + 1, numOfPairs);
            assignment.deleteCharAt(assignment.length() - 1);
        }

        if(numOfClose < numOfOpen) {
            assignment.append(")");
            backtracking(assignment, numOfClose + 1, numOfOpen, numOfPairs);
            assignment.deleteCharAt(assignment.length() - 1);
        }
    }
}
