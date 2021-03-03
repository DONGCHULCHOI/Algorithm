package leetcode.top100_questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    // Backtracking:
    // time complexity
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        backtracking(list, new LinkedList<>(), candidates, 0, target);
        return list;
    }

    public void backtracking(List<List<Integer>> list, List<Integer> assignment, int[] candidates, int start, int remain) {
        if(remain == 0) {
            list.add(new ArrayList<Integer>(assignment));
            return;
        }

        for(int i = start; i < candidates.length; i++) { // not to be duplicated // *****
            if(remain - candidates[i] >= 0) { // if it is consistent
                assignment.add(candidates[i]); // assign the domain value to unassigned var
                backtracking(list, assignment, candidates, i, remain - candidates[i]); // not to be duplicated // *****
                assignment.remove(assignment.size() - 1); // remove the value
            }
        }
    }
}
