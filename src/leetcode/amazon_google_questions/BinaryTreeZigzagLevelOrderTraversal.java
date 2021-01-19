package leetcode.amazon_google_questions;

import com.company.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    // Consider DFS later
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // BFS
        // T.C: O(N)
        // S.C: O(N)
        // Use delimiter, compared to Binary Tree Level Order Traversal which uses level
        // delimiter delimit a level
        // Use local variable to save an arrylist because the order becomes different on each level
        // Use boolean to seperate two ways by level when add each node's value into an arraylist
        if(root == null){
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> levels = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null); // delimiter // *****
        LinkedList<Integer> level = new LinkedList<>();
        boolean isLeftToRight = true; // *****

        while(queue.size() != 0){
            TreeNode curr = queue.remove();

            if(curr != null){ // *****
                // visit
                if(isLeftToRight){ // for zigzag // *****
                    level.add(curr.val);
                }
                else{ // for zigzag // *****
                    level.add(0,curr.val);
                }
                // enqueue childs
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
            else{ // when meet delimiter, level increases // *****
                levels.add(level);
                level = new LinkedList<>();
                if(queue.size() != 0){ // *****
                    queue.add(null);
                }
                isLeftToRight = !isLeftToRight; // *****
            }
        }
        return levels;
    }
}
