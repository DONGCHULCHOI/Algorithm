package leetcode.top100_questions;

import com.company.TreeNode;

public class SymmetricTree {
    // Recursion:
    // T.C: O(n)
    // S.C: O(n)
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2){
        // base case
        if(t1 == null && t2 == null){
            return true;
        }
        if(t1 == null || t2 == null || t1.val != t2.val){
            return false;
        }

        boolean isLeftSubtreeMirror = isMirror(t1.right, t2.left);
        boolean isRightSubtreeMirror = isMirror(t1.left, t2.right);

        return isLeftSubtreeMirror && isRightSubtreeMirror;
    }
}
