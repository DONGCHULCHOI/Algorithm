package leetcode.top100_questions;

public class WordSearch {
    // DFS:
    // has to recover the visited mark // *****
    // because we need to do dfs from new start point again // *****
    // use new ver. because the case: [[a]], a -> in this case, cannot get to the base case
    char[][] board;
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 0: 'up', 1: 'right', 2: 'down', 3: 'left'

    public boolean exist(char[][] board, String word) {
        this.board = board;

        // trigger for start point, compared to robot room clear, here, all point in grid can be start point // *****
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if(board[row][col] == word.charAt(0)) {
                    if (dfs2(row, col, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // new ver.
    boolean dfs(int row, int col, String word, int start) {
        if(start == word.length()) {
            return true;
        }

        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(start)) {
            return false;
        }

        board[row][col] = '#'; // for visited

        for(int i = 0;  i < 4; i++) {
            int newRow = row + dirs[i][0];
            int newCol = col + dirs[i][1];

            if(dfs(newRow, newCol, word, start + 1))
                return true;
        }

        board[row][col] = word.charAt(start); // ***** // because we need to do dfs from new start point again

        return false;
    }

    // orig ver.
    // (!) case: [[a]], a -> in this case, cannot get to the base case
    boolean dfs2(int row, int col, String word, int start) {
        if(start == word.length()) {
            return true;
        }

        if(board[row][col] != word.charAt(start)) {
            return false;
        }

        board[row][col] = '#'; // for visited

        for(int i = 0;  i < 4; i++) {
            int newRow = row + dirs[i][0];
            int newCol = col + dirs[i][1];

            if(newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length)
                continue;
            if(board[newRow][newCol] == '#')
                continue;

            if(dfs(newRow, newCol, word, start + 1))
                return true;
        }

        board[row][col] = word.charAt(start);

        if(board[row][col] == word.charAt(start) && start == word.length() - 1)
            return true;
        return false;
    }
}
