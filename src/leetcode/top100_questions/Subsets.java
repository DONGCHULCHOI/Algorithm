package leetcode.top100_questions;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    // Brute force(backtracking):
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>());
        backtracking(new ArrayList<>(), nums, 0);
        return res;
    }

    public void backtracking(List<Integer> assignment, int[] nums, int start) {
        if(start == nums.length) {
            return;
        }

        for(int i = start; i < nums.length; i++) {
            assignment.add(nums[i]);
            backtracking(assignment, nums, i + 1);
            res.add(new ArrayList<>(assignment));
            assignment.remove(assignment.size() - 1);
        }
    }
}
