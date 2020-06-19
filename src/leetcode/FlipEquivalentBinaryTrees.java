package leetcode;

import com.company.TreeNode;

public class FlipEquivalentBinaryTrees {
    // Consider Canonical approach - dfs next time
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // T.C: O(min(N1, N2)) where N1, N2 are the lengths of root1 and root2
        // S.C: O(min(H1, H2)) where H1, H2 are the lengths of root1 and root2
        // If root1 and root2 have the same root value, then we only need to check if their children are equal
        // Also the base case is for the last node which calls the last recursive call
        // But when define the base case, if look at this on the root1, root2 side, it is easy to make the base case // *****
        if (root1 == null && root2 == null) // *****
            return true;
        if (root1 == null || root2 == null || root1.val != root2.val) // *****
            return false;

        return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) // *****
                || flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left); // *****
    }
}
