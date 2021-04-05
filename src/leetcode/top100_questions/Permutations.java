package leetcode.top100_questions;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    // Brute force(backtracking):
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtracking(new ArrayList<>(), nums, 0);
        return res;
    }

    public void backtracking(List<Integer> assignment, int[] nums, int start) {
        if(start == nums.length) {
            res.add(new ArrayList<>(assignment));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!assignment.contains(nums[i])) {
                assignment.add(nums[i]);
                backtracking(assignment, nums, start + 1);
                assignment.remove(assignment.size() - 1);
            }
        }
    }
}
