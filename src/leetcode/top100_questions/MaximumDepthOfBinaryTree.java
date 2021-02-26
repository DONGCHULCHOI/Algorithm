package leetcode.top100_questions;

import com.company.TreeNode;

public class MaximumDepthOfBinaryTree {
    // Recursion:
    // T.C: O(n)
    // S.C: O(n)
    public int maxDepth(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int depthLeftSubtree = maxDepth(node.left);
        int depthRightSubtree = maxDepth(node.right);

        return Math.max(depthLeftSubtree, depthRightSubtree) + 1;
    }
}
