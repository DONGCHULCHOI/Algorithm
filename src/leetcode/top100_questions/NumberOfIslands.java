package leetcode.top100_questions;

public class NumberOfIslands {
    // DFS:
    // T.C: O(M*N) where M is the number of rows and N is the number of columns
    // S.C: O(M*N)
    // Treat the 2d grid map as an undirected graph and there is an edge between two horizontally or vertically adjacent nodes
    // in each grid, '0' means not a node, '1' means a node
    // when we do dfs, we need to mark the node visited -> use grid, denote '0' when visited
    // Linear scan the 2d grid map, if a node contains a '1', then it is a root node that triggers a Depth First Search.
    // Count the number of root nodes that trigger DFS, this number would be the number of islands
    // Use new version: there is a reason -> Word Search
    private int count = 0;

    public int numIslands(char[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;

        for(int i = 0; i < rowLen; i++) {
            for(int j = 0; j < colLen; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, rowLen, colLen, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    /*
    new ver.
    */
    public void dfs(char[][] grid, int rowLen, int colLen, int row, int col) {
        if(row < 0 || row >= rowLen || col < 0 || col >= colLen || grid[row][col] == '0')
            return;

        grid[row][col] = '0';

        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for(int i = 0; i < 4; i++) {
            int newRow = row + dirs[i][0];
            int newCol = col + dirs[i][1];

            dfs(grid, rowLen, colLen, newRow, newCol);
        }
    }
    /*
    orig ver.
    public void dfs2(char[][] grid, int rowLen, int colLen, int row, int col) {
        if(grid[row][col] == '0')
            return;

        grid[row][col] = '0';

        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for(int i = 0; i < 4; i++) {
            int newRow = row + dirs[i][0];
            int newCol = col + dirs[i][1];
            if(newRow >= 0 && newRow < rowLen && newCol >=0 && newCol < colLen) {
                if(grid[newRow][newCol] != '0') {
                    dfs(grid, rowLen, colLen, newRow, newCol);
                }
            }
        }
    }
    */
}