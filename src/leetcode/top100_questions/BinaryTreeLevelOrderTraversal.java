package leetcode.top100_questions;

import com.company.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    // BFS:
    // T.C: O(N) since each node is processed exactly once
    // S.C: O(N)
    private List<List<Integer>> levels = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null){
            return levels;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while(queue.size() != 0){
            levels.add(new ArrayList<Integer>()); // when level increased, add new arraylist // *****

            int levelSize = queue.size(); // queue include nodes at the same level // *****
            for(int i = 0; i < levelSize; i++){
                // visit
                TreeNode node = queue.remove();
                levels.get(level).add(node.val);

                // for not visited adjacent nodes, enqeue
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
