package leetcode.top100_questions;

import com.company.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
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
// Binary tree:
// T.C: O(n); master Theorem
// S.C: O(n)
// find the root in preorder list
// the root splits the inoder list into left subtree and right subtree
// keep repeating
    int ptrCurrInPre = 0;
    int[] preorder;
    int[] inorder;

    Map<Integer, Integer> inorderIdxMap = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        int idx = 0;
        for(Integer val : inorder) {
            inorderIdxMap.put(val, idx++);
        }

        return helper(0, inorder.length);
    }

    public TreeNode helper(int leftIdxInPre, int rightIdxInPre) {
        // if there is no elements to construct subtrees
        if(leftIdxInPre == rightIdxInPre) // *****
            return null;

        // pick up ptrCurrInPre element as a root
        int rootVal = preorder[ptrCurrInPre];
        TreeNode root = new TreeNode(rootVal);
        ptrCurrInPre++;

        // root splits inorder list into left and right subtrees
        int rootIdxInPre = inorderIdxMap.get(rootVal);
        // build left subtree
        root.left = helper(leftIdxInPre, rootIdxInPre);
        // build right subtree
        root.right = helper(rootIdxInPre + 1, rightIdxInPre);

        return root;
    }
}
