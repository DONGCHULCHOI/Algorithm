package leetcode;

import com.company.TreeNode;

public class LowestCommonAncestorOfABinaryTree {
    // Consider iteration later
    private TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // T.C: O(N)
        // S.C: O(N)
        // Use DFS; post order
        // The flag helps to determine if we found the required nodes in any of the paths
        // The least common ancestor would then be the node for which both the subtree recursions return a True flag
        // can also be the node which itself is one of p or q and for which one of the subtree returns a True flag
        dfs(root, p, q);
        return this.ans;
    }

    private boolean dfs(TreeNode currentNode, TreeNode p, TreeNode q) {
        // dfs - post order
        if (currentNode == null) {
            return false; // ***
        }

        int left = dfs(currentNode.left, p, q) ? 1 : 0; // *****
        int right = dfs(currentNode.right, p, q) ? 1 : 0; // *****
        // visit
        int mid = (currentNode == p || currentNode == q) ? 1 : 0; // the case where the current node is either p or q
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        return (mid + left + right > 0);
    }
}
