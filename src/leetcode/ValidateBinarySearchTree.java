package leetcode;

import com.company.TreeNode;

public class ValidateBinarySearchTree {
    // Consider iteration later
    public boolean isValidBST(TreeNode root) {
        // T.C: O(N)
        // S.C: O(N)
        // assume the following:
        // The left subtree of a node contains only nodes with keys less than the node's key
        // The right subtree of a node contains only nodes with keys greater than the node's key
        return isValidBSTHelper(root, null, null);
    }

    public boolean isValidBSTHelper(TreeNode node, Integer lower, Integer upper){
        if(node == null){
            return true;
        }
        // visit
        if(lower != null && node.val <= lower){ // *****
            return false;
        }
        if(upper != null && node.val >= upper){ // *****
            return false;
        }

        return isValidBSTHelper(node.left, lower, node.val) && isValidBSTHelper(node.right, node.val, upper); // *****
    }
}
