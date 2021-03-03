package leetcode.top100_questions;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    // Backtracking:
    // consider time complexity later
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>()); // for the empty case: []

        backtracking(list, new ArrayList<>(), nums, 0);

        return list;
    }

    public void backtracking(List<List<Integer>> list, List<Integer> assignment, int[] nums, int start) {
        if(start == nums.length) {
            return;
        }

        for(int i = start; i < nums.length; i++) { // if it is consistent == make it consistent
            assignment.add(nums[i]);
            backtracking(list, assignment, nums, i+1);
            list.add(new ArrayList<>(assignment));
            assignment.remove(assignment.size() - 1);
        }
    }
}
