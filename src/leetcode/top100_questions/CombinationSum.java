package leetcode.top100_questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    // Brute force(backtracking):
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(new ArrayList<>(), candidates, target, 0);
        return res;
    }

    public void backtracking(List<Integer> assignment, int[] candidates, int remain, int start) {
        if(remain <= 0) {
            if(remain == 0) {
                res.add(new ArrayList<>(assignment));
            }
            return;
        }

        for(int i = start; i < candidates.length; i++) {
            assignment.add(candidates[i]);
            backtracking(assignment, candidates, remain - candidates[i], i);
            assignment.remove(assignment.size() - 1);
        }
    }
}
