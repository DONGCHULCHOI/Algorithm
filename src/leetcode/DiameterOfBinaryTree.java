package leetcode;

import com.company.TreeNode;

public class DiameterOfBinaryTree {
    // consider converting from recursion to iteration next time
    // use Maximum Depth of Binary Tree
    // T.C: O(N)
    // S.C: O(N)
    int ans = 1; // when leafnode, ans = Math.max(1,0) = 1 // *****
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null || root.left == null && root.right == null){ // null or only root node // *****
            return 0;
        }
        maxDepth(root);
        return ans;
    }
    public int maxDepth(TreeNode node) {
        if (node == null){
            return 0;
        }
        int L = maxDepth(node.left);
        int R = maxDepth(node.right);
        ans = Math.max(ans, L+R); // add up max depth of sub left, and right == diameter, and update for each recursive // *****
        return Math.max(L, R) + 1;
    }
}
