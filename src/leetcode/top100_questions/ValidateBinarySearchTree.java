package leetcode.top100_questions;

import com.company.TreeNode;

public class ValidateBinarySearchTree {
    // Recursion:
    // T.C: O(N)
    // S.C: O(N)
    // assume the following:
    // The left subtree of a node contains only nodes with keys less than***** the node's key
    // The right subtree of a node contains only nodes with keys greater than***** the node's key
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }

    public boolean isValidBSTHelper(TreeNode node, Integer lower, Integer upper){
        // base case
        if(node == null){
            return true;
        }
        if(lower != null && node.val <= lower){ // *****
            return false;
        }
        if(upper != null && node.val >= upper){ // *****
            return false;
        }

        boolean isLeftSubtreeValid = isValidBSTHelper(node.left, lower, node.val);
        boolean isRightSubtreeValid = isValidBSTHelper(node.right, node.val, upper);

        return  isLeftSubtreeValid && isRightSubtreeValid;
    }
}
