package leetcode.top100_questions;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    // Brute force(backtracking):
    // Time complexity
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtracking(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtracking(List<List<Integer>> list, List<Integer> assignment, int [] nums){
        if(assignment.size() == nums.length){
            list.add(new ArrayList<>(assignment));
        }

        for(int i = 0; i < nums.length; i++){
            if(!assignment.contains(nums[i])) {
                assignment.add(nums[i]);
                backtracking(list, assignment, nums);
                assignment.remove(assignment.size() - 1);
            }
        }
    }
}
