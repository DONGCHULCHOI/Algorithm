package leetcode.top100_questions;

import com.company.TreeNode;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode node) {
        // DFS
        // T.C: O(N)
        // S.C: O(N)
        if(node == null){
            return 0;
        }

        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }
}
