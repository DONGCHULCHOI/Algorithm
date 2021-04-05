package leetcode.top100_questions;

public class NumberOfIslands {
    // DFS:
    // T.C: O(M*N) where M is the number of rows and N is the number of columns
    // S.C: O(M*N)
    // Treat the 2d grid map as an undirected graph and there is an edge between two horizontally or vertically adjacent nodes of value '1'
    // Linear scan the 2d grid map, if a node contains a '1', then it is a root node that triggers a Depth First Search.
    // During DFS, every visited node should be set as '0' to mark as visited node.
    // Count the number of root nodes that trigger DFS, this number would be the number of islands
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

    public void dfs(char[][] grid, int rowLen, int colLen, int row, int col) {
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
}
