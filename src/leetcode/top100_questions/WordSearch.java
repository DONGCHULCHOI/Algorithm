package leetcode.top100_questions;

public class WordSearch {
    // Backtracking:
    // time complexity and need to clear the codes
    private char[][] board;
    private int rows;
    private int cols;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        rows = board.length;
        cols = board[0].length;

        // select an unassigned variable
        for (int row = 0; row < rows; row++)
            for (int col = 0; col < cols; col++)
                if (backtrack(row, col, word, 0))
                    return true;
        return false;
    }

    protected boolean backtrack(int row, int col, String word, int index) { // index for word
        // if assignment is complete; check if we reach the bottom case of the recursion
        if (index >= word.length())
            return true;

        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};
        // iterate domain values, and if the domain value is consistent, assign the value to the variable
        for (int d = 0; d < 4; d++) {
            if (row >= 0 && row < rows && col >= 0 && col < cols && board[row][col] == word.charAt(index)) {
                board[row][col] = '#'; // assign the value to the variable
                boolean result = backtrack(row + rowOffsets[d], col + colOffsets[d], word, index + 1);
                if(result != false)
                    return true;
                board[row][col] = word.charAt(index); // remove the value to the variable
            }
            else {
                break;
            }
        }
        return false;
    }
}
