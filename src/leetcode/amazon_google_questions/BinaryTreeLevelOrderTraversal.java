package leetcode.amazon_google_questions;

import com.company.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    // T.C: O(N) where N is the number of nodes
    // S.C: O(N)
    // list idx == tree level, level starting from 0 // *****
    // first entry of the level == list's size // *****
    List<List<Integer>> levels = new ArrayList<>(); // *****

    public List<List<Integer>> levelOrderRecursion(TreeNode root) {
        if(root == null){
            return levels;
        }
        helper(root, 0);
        return levels;
    }
    public void helper(TreeNode node, int level){
        if(node == null ){ // base case
            return;
        }
        // visit
        if(levels.size() == level){ // *****
            levels.add(new ArrayList<Integer>());
        }
        levels.get(level).add(node.val);
        // recursive case
        helper(node.left, level+1);
        helper(node.right, level+1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        // iteration - BFS
        // T.C: O(N) since each node is processed exactly once // ***
        // S.C: O(N)
        // Use level
        // (!) level starts with 0
        if(root == null){
            return levels;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while(queue.size() != 0){
            levels.add(new ArrayList<Integer>()); // when level increas, add new arraylist // *****

            int level_length = queue.size(); // to proceed by level // *****
            for(int i=0; i<level_length; i++){ // *****
                TreeNode node = queue.remove();
                // visit
                levels.get(level).add(node.val);
                // enqeue the childs(neighbors)
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }

            level++; // *****
        }
        return levels;
    }
}
