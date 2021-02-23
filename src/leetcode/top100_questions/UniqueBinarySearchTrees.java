package leetcode.top100_questions;

public class UniqueBinarySearchTrees {
    // DP:
    // T.C: O(n^2)
    // S.C: O(n)
    // G(n): the number of unique BST for a sequence of length n // *****
    // F(i,n): the number of unique BST, where the number i is served as the root of BST (1 ≤ i ≤ n) // *****
    // G(n) = ∑ F(i,n) from i=1 to n since the BST that we construct as root i are all unique cuz they start from unique roots
    // F(i,n) = G(i−1) * G(n−i)
    //      e.g. 1,2,3,4,5 and pick 3 as root, then, from the left side, there is {[3,1,null,null,2],[3,2,null,null,1]} BSTs,
    //           from the right side, there is {[3,null,4,null,5],[3,null,5,4,null]} BSTs,
    //           all the possible pairs of Cartesian product are possible BSTs when pick 3 as root
    //      r.f. Cartesian product of two sets A and B, denoted A × B, is the set of all ordered pairs (a, b) where a is in A and b is in B
    //      => F(i,n) is the product of the number of BST for its left and right subtrees
    //          1 ... i-1 <i> i+1 ... n -> the length of the left substree is i-1 -1 +1 = i-1, the length of the right subtree is n - (i+1) + 1 = n-1
    // As a result, we can make the combined formula,
    // G(n)=∑ G(i−1)⋅G(n−i) from i=1 to n // *****
    // =>
    // opt(n) = the number of unique BST for a sequence of length n
    //        = ∑ opt(i−1)⋅opt(n−i) from i=1 to n
    public int numTrees(int n) {
        int[] opt = new int[n+1];
        opt[0] = 1; // empty tree
        opt[1] = 1; // tree which only has root node

        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) { // *****
                opt[i] += opt[j-1] * opt[i-j];
            }
        }

        return opt[n];
    }
}
