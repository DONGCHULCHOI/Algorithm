package leetcode;

public class DesignTicTacToe {
    // T.C: O(n)
    // S.C: O(n^2)
    // Keyword: dale, hill, only one dale and one hill
    // assumption that a move is guaranteed to be valid and is placed on an empty block
    // https://leetcode.com/problems/design-tic-tac-toe/discuss/156572/Simple-Java-Solution-(ideas-from-n2-to-n-to-constant-time)
    private int[][] grid;

    /** Initialize your data structure here. */
    public DesignTicTacToe(int n) {
        grid = new int[n][n];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        // place the mark
        grid[row][col] = (player == 1) ? 1 : 2;

        // Check vertically
        boolean isVertical = true;
        for(int i=0; i<grid.length; i++){
            if(grid[i][col] != player)
                isVertical = false;
        }
        if(isVertical)
            return player;

        // Check horizontally
        boolean isHorizontal = true;
        for(int i=0; i<grid.length; i++){
            if(grid[row][i] != player)
                isHorizontal = false;
        }
        if(isHorizontal)
            return player;

        // Check dale // only one dale in square // *****
        if(row == col){ // *****
            boolean isDale = true;
            for(int i=0; i<grid.length; i++){
                if(grid[i][i] != player)
                    isDale = false;
            }
            if(isDale)
                return player;
        }

        // Check hill diagonal // only one hill in square // *****
        if(row+col == grid.length-1){ // ***** // when hill, row + col == constant, especially if the diagonal is located on the main diagonal, the sum is n-1
            boolean isHill = true;
            for(int i=0; i<grid.length; i++){
                if(grid[i][grid.length-1-i] != player)
                    isHill = false;
            }
            if(isHill)
                return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */