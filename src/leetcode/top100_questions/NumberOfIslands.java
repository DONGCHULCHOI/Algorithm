package leetcode.top100_questions;

public class NumberOfIslands {
    // DFS:
    // T.C: O(M*N) where M is the number of rows and N is the number of columns
    // S.C: O(M*N)
    // Treat the 2d grid map as an undirected graph and there is an edge between two horizontally or vertically adjacent nodes of value '1'
    // Linear scan the 2d grid map, if a node contains a '1', then it is a root node that triggers a Depth First Search.
    // During DFS, every visited node should be set as '0' to mark as visited node.
    // Count the number of root nodes that trigger DFS, this number would be the number of islands
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int numIslands = 0;
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == '1'){
                    dfs(grid, row, col);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }
    private void dfs(char[][] grid, int row, int col){
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') { // base case
            return;
        }

        grid[row][col] = '0'; // visit

        // loop for unvisited adjacent neighbors
        dfs(grid, row-1, col);
        dfs(grid, row, col-1);
        dfs(grid, row+1, col);
        dfs(grid, row, col+1);
    }
}
