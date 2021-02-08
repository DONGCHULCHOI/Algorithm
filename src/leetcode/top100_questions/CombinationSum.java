package leetcode.top100_questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    // Backtracking:
    // time complexity
    // backtracking is a general algorithm for finding all solutions to some computational problems
    // The same number may be chosen from candidates an unlimited number of times:
    //      return a list of all unique combinations of candidates:
    //          don't add the precedent numbers into the current node,
    //          since they would have been explored in the nodes in the left part of the subtree
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> assignment = new LinkedList<>();
        backtrack(target, assignment, 0, candidates, res);
        return res;
    }

    public void backtrack(int remain, List<Integer> assignment, int startIdx, int[] candidates, List<List<Integer>> res) {
        if(remain == 0) {
            res.add(new ArrayList<Integer>(assignment));
            return;
        }

        for(int i = startIdx; i < candidates.length; i++) { // not to be duplicated // *****
            if(remain > 0) { // if it is consistent
                assignment.add(candidates[i]); // assign the domain value to unassigned var
                backtrack(remain - candidates[i], assignment, i, candidates, res); // not to be duplicated // *****
                assignment.remove(assignment.size() - 1); // remove the value
            }
        }
    }
}
