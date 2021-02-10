package leetcode.top100_questions;

import com.company.TreeNode;

public class SymmetricTree {
    // DFS:
    // T.C: O(n)
    // S.C: O(n)
    // Think it as traverseDFS two binary tree at the same time
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null){
            return true;
        }

        if(t1 == null || t2 == null || t1.val != t2.val){
            return false;
        }

        return isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
    }
}
