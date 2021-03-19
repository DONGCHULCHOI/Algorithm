package leetcode.top100_questions;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    // Brute force(backtracking):
    // Consider T.C. / S.C next time
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtracking(list, new StringBuilder(), 0, 0, n); // n: the number of pairs of parentheses
        return list;
    }

    public void backtracking(List<String> list, StringBuilder assignment, int numOfOpen, int numOfClose, int numOfPairs){
        if(assignment.length() == 2 * numOfPairs){ // *****
            list.add(assignment.toString());
            return;
        }

        if(numOfOpen < numOfPairs){ // *****
            assignment.append('(');
            backtracking(list, assignment, numOfOpen + 1, numOfClose, numOfPairs);
            assignment.deleteCharAt(assignment.length() - 1);
        }

        if(numOfClose < numOfOpen){ // *****
            assignment.append(')');
            backtracking(list, assignment, numOfOpen, numOfClose + 1, numOfPairs);
            assignment.deleteCharAt(assignment.length() - 1);
        }
    }
}
