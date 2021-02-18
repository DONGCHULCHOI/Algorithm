package leetcode.top100_questions;

import com.company.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    // BFS:
    // related problem: Binary Tree Level Order Traversal
    // T.C: O(n) where n is the number of nodes
    // S.C: O(d) where d is the diameter of tree, and d is n/2 when complete binary tree
    // The following codes can make level order traversal processed level by level
    // int levelSize = queue.size(); // *****
    // for(int i = 0; i < levelSize; i++) { // *****
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(queue.size() != 0) {
            int levelSize = queue.size(); // *****
            for(int i = 0; i < levelSize; i++) { // *****
                TreeNode node = queue.remove();

                if(i == levelSize-1) {
                    res.add(node.val);
                }

                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return res;
    }
}
