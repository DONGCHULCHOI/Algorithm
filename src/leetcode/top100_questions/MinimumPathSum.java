package leetcode.top100_questions;

public class MinimumPathSum {
    // DP:
    // T.C: O(n*m)
    // S.C: O(n*m)
    // related problem: Unique Paths, Maximal Square, Minimum Path Sum
    // opt(i,j) = minimum cost from (i,j) to (m-1,n-1)
    //          = grid[i][j] + opt(i,j+1) if i == m - 1 && j != n - 1
    //          = grid[i][j] + opt(i+1,j) if i != m - 1 && j == n - 1
    //          = grid[i][j] + Min(opt(i+1,j), opt(i,j+1))
    //      j
    //   ------->
    //   |
    // i |
    //   |
    //   V
    // (i,j) -> (row,col) cuz we use the value of the grid, have to follow the index of the grid(array) // *****
    // fill the array row by row from bottom to top, and in the row, from right to left
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] opt = new int[m][n];

        opt[m-1][n-1] = grid[m-1][n-1];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(i == m - 1 && j != n - 1) {
                    opt[i][j] = grid[i][j] + opt[i][j+1];
                }
                else if(i != m - 1 && j == n - 1) {
                    opt[i][j] = grid[i][j] + opt[i+1][j];
                }
                else if(i != m - 1 && j != n - 1){
                    opt[i][j] = grid[i][j] + Math.min(opt[i+1][j], opt[i][j+1]);
                }
            }
        }
        return opt[0][0];
    }
}
