package leetcode.top100_questions;

public class MaximalSquare {
    // DP:
    // T.C: O(m*n)
    // S.C: O(m*n)
    // related problem: Unique Paths, Maximal Square, Minimum Path Sum
    // opt(i,j) = the side length of the maximum square whose bottom right corner is the cell with index (i,j) // *****
    //          = min(opt(i-1,j), opt(i-1,j-1), opt(i,j-1)) + 1 // *****
    //      j
    //   ------->
    //   |
    // i |
    //   |
    //   V
    // (i,j) -> (row,col) cuz we use the value of the matrix, have to follow the index of the matrix(array)
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] opt = new int[m][n];

        int maxLen = 0;

        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == '1') {
                opt[i][0] = 1;
                maxLen = Math.max(maxLen, opt[i][0]);
            }
        }
        for(int i = 0; i < n; i++) {
            if(matrix[0][i] == '1') {
                opt[0][i] = 1;
                maxLen = Math.max(maxLen, opt[0][i]);
            }
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == '1') {
                    opt[i][j] = Math.min(opt[i-1][j], Math.min(opt[i-1][j-1], opt[i][j-1])) + 1;
                    maxLen = Math.max(maxLen, opt[i][j]);
                }
            }
        }

        return maxLen * maxLen;
    }
}
