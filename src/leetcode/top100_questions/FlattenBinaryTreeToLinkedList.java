package leetcode.top100_questions;

import com.company.TreeNode;

public class FlattenBinaryTreeToLinkedList {
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
    // T.C: O(N)
    // S.C: O(N)
    // main idea behind a recursive solution is that we use the solutions for subproblems to solve an upper level problem
    // Once recursion does the hard work for us and flattens out the subtrees,
    // we will essentially get two linked lists and we need the tail end of the left one to attach it to the right one
    // see what all information we will need in our recursive function at a given node
    /*
        _node_ = The current node
        _leftChild_ = the left child of our current node
        _rightChild_ = the right child of our current node
        _leftTail_ = The tail node of the flattened out left subtree
        _rightTail_ =
                    The tail node of the flattened out right subtree /
                    The tail node of the fully formed tree rooted at _node_(after connection done)
                    This information is needed by the parent recursive calls since the tree rooted at the current node can be some
                    other's node's left subtree or right subtree
    */
    //
    public void flatten(TreeNode root) {
        flattenTree(root);
    }

    private TreeNode flattenTree(TreeNode node) {
        // Handle the null scenario // base case
        if (node == null) {
            return null;
        }

        // For a leaf node, we simply return thenode as it is // base case
        if (node.left == null && node.right == null) {
            return node;
        }

        // Recursively flatten the left subtree
        TreeNode leftTail = flattenTree(node.left);

        // Recursively flatten the right subtree
        TreeNode rightTail = flattenTree(node.right);

        // If there was a left subtree, we shuffle the connections around so that there is nothing on the left side anymore.
        // if the node has a left child, leftTail is not null
        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        // We need to return the "rightmost" node after we are done wiring the new connections.
        // if the node has a right child, rightTail is not null
        return rightTail == null ? leftTail : rightTail;
    }
}
