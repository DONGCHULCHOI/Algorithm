package leetcode.top100_questions;

import com.company.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// Recursion:
// T.C: O(n) since we visit all nodes once
// S.C: O(n)
// related problems: House Robber, House Robber III
// if you have time, consider improving time complexity
// get the upper level's recursion function sol using subproblem's recursion function sol(assume we know subproblem's recursion function sol) // *****
// think the given node as root node first, but also consider the given node is one of the subtrees // *****
// consider base case // *****
/*
    function helper(node, the parent is robbed or not?) {
        tackle basic case...

        if the parent is robbed:
            we can not rob this node.
            return helper(node.left, parent_robbed=False) + helper(node.right, parent_robbed=False)

        if the parent is not robbed:
            two choices: rob this node or not?
                rob = node.val + helper(node.left, parent_robbed=True)
                               + helper(node.right,  parent_robbed=True)
                not_rob = helper(node.left, parent_robbed=False)
                        + helper(node.right, parent_robbed=False)
            return max(rob, not_rob)
    }
*/
class HouseRobberIII {
    public int rob(TreeNode root) {
        return helper(root, false);
    }

    public int helper(TreeNode node, boolean isRobbed) {
        if(node == null) {
            return 0;
        }

        if(isRobbed) { // if the parent is robbed
            return helper(node.left, false) + helper(node.right, false);
        }
        else { // if the parent is not robbed
            int rob = node.val + helper(node.left, true) + helper(node.right, true);
            int notRob = helper(node.left, false) + helper(node.right, false);
            return Math.max(rob, notRob);
        }

    }
}
