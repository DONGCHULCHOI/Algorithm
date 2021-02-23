package leetcode.top100_questions;

public class UniquePaths {
    // DP:
    // T.C: O(mn)
    // S.C: O(mn)
    // related problem: Unique Paths, Maximal Square, Minimum Path Sum
    // opt(i,j) = ways from (m-1,n-1) to (0,0)
    //          = opt(i,j-1) + opt(i-1,j)
    //        ^
    //        |
    //        | j
    //        |
    // <-------
    //    i
    // fill the array row by row, and in the row, from right to left
    public int uniquePaths(int m, int n) {
        int[][] opt = new int[m][n];

        for(int i = 0; i < m; i++) {
            opt[i][0] = 1;
        }
        for(int j = 0; j < n; j++) {
            opt[0][j] = 1;
        }

        for(int j = 1; j < n; j++){
            for(int i = 1; i < m; i++) {
                opt[i][j] = opt[i][j-1] + opt[i-1][j];
            }
        }

        return opt[m-1][n-1];

    }
}
