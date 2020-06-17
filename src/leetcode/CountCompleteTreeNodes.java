package leetcode;

import com.company.TreeNode;

public class CountCompleteTreeNodes {
    // T.C: O(d^2)
    // S.C: O(1)
    // compute the depth of the tree first
    // then, compute the number of nodes in all levels except the last one: ∑(2^k) where d is depth of the tree and k is from 0 to d-1 = 2^d - 1
    // then, compute the number of the nodes on last level: 2^d, T.C is O(log N) where N is the number of nodes = O(log 2^d) = O(d) using binary search
    // use binary search again to determine whether a specific node is in the last level in the first binary search
    // return the sum of 2^d - 1 + the number of the nodes in the last level
    public int countNodes(TreeNode root) {
        if(root == null) // when a tree is empty
            return 0;

        int d = computeDepth(root);

        if(d == 0) // when a tree is only one node
            return 1;

        // Perform binary search to check how many nodes exist // ******
        // Last level nodes are enumerated from 0 to 2^d - 1
        // binary search done on the indexes on the last level
        // left becomes the number of the nodes on last level // *****
        // T.C: O(d)
        int left = 0; // *****
        int right = (int)Math.pow(2, d) - 1;
        while(left <= right){ // *****
            int mid = left + (right - left) / 2; // = (left + right) / 2  because to avoid overflow // *1) // *****
            if(exists(mid, d, root)){ // *****
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        return (int)Math.pow(2, d) - 1 + left;
    }

    public boolean exists(int idx, int d, TreeNode node){ // ******
        // Last level nodes are enumerated from 0 to 2^d - 1
        // binary search done on the indexes on the last level
        // Return True if last level node idx exists
        // T.C: O(d)
        int left = 0;
        int right = (int)Math.pow(2, d) - 1;
        for(int i = 0; i < d; ++i) { // *****
            int mid = left + (right - left) / 2;
            if (idx <= mid) { // *****
                node = node.left; // *****
                right = mid-1;
            }
            else {
                node = node.right; // *****
                left = mid + 1;
            }
        }
        return node != null; // *****
    }

    public int computeDepth(TreeNode node){
        int d = 0;

        while(node.left != null){
            d++;
            node = node.left;
        }
        return d;
    }
}
// 1) https://ai.googleblog.com/2006/06/extra-extra-read-all-about-it-nearly.html