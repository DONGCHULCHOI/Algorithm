package leetcode;

import java.util.LinkedList;

public class NumberOfIslands {
    // Consider iteration-BFS next time
    public int numIslands(char[][] grid) {
        // DFS
        // T.C: O(M*N) where M is the number of rows and N is the number of columns
        // S.C: O(M*N)
        if(grid == null){
            return 0;
        }

        int numIslands = 0;
        for(int row=0; row<grid.length; row++){ // trigger for the case of the isolated islands // *****
            for(int col=0; col<grid[0].length; col++){
                if(grid[row][col] == '1'){
                    dfs(grid, row, col);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }
    private void dfs(char[][] grid, int row, int col){
        // No need to mark visited // *****
        // because when visited, the value becomes 0, and the 0 means visited
        if(grid[row][col] == '0'){
            return;
        }
        // visit
        grid[row][col] = '0';
        // if not visited, do recursion for neighbors
        if(row-1 >= 0 && grid[row-1][col] == '1'){
            dfs(grid, row-1, col);
        }
        if(col-1 >= 0 && grid[row][col-1] == '1'){
            dfs(grid, row, col-1);
        }
        if(row+1 < grid.length && grid[row+1][col] == '1'){
            dfs(grid, row+1, col);
        }
        if(col+1 < grid[0].length && grid[row][col+1] == '1'){
            dfs(grid, row, col+1);
        }
    }

    public int numIslandsIteration(char[][] grid) {
        // BFS
        // T.C: O(M*N)
        // S.C: O(min(M,N))
        int numRow = 0;
        int numCol = 0;
        if(grid == null || grid.length ==0){
            return 0;
        }

        numRow = grid.length;
        numCol = grid[0].length;
        int numIslands = 0;

        for(int r=0; r<numRow; r++){
            for(int c=0; c<numCol; c++){
                if(grid[r][c] == '1'){
                    numIslands++;
                    LinkedList<Integer> queue = new LinkedList<>();
                    grid[r][c] = '0';
                    queue.add(r * numCol + c); // id = row * numCol + col

                    while(queue.size()!=0){
                        int id = queue.poll();
                        int row = id / numCol;
                        int col = id % numCol;

                        if(row-1 >= 0 && grid[row-1][col] == '1'){
                            grid[row-1][col] = '0';
                            queue.add((row-1) * numCol + col);
                        }
                        if(row+1 < numRow && grid[row+1][col] == '1'){
                            grid[row+1][col] = '0';
                            queue.add((row+1) * numCol + col);
                        }
                        if(col-1 >= 0 && grid[row][col-1] == '1'){
                            grid[row][col-1] = '0';
                            queue.add(row * numCol + (col-1));
                        }
                        if(col+1 < numCol && grid[row][col+1] == '1'){
                            grid[row][col+1] = '0';
                            queue.add(row * numCol + (col+1));
                        }
                    }

                }
            }
        }
        return numIslands;
    }
}
