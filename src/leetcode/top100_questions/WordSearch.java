package leetcode.top100_questions;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {
    // Backtracking:
    // consider how to improve time complexity
    // 1st. calculate domains at given point
    // 2nd. if it is consistent
    // 3rd. assign the value to assignment, and move the point corresponding to the value
    // the recursion tree starts with start point
    private char[][] board;
    private int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 0: 'up', 1: 'right', 2: 'down', 3: 'left' // *****

    public boolean exist(char[][] board, String word) {
        if(word.length() == 0) {
            return false;
        }

        this.board = board;

        // trigger for start point, compared to robot room clear, here, all point in grid can be start point
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if(word.length() == 1) {
                    if(board[row][col] == word.charAt(0)) {
                        return true;
                    }
                }
                // the below, assume the word is at least 2 length
                if(board[row][col] == word.charAt(0)) {
                    Set<Pair<Integer, Integer>> visited = new HashSet<Pair<Integer, Integer>>();
                    StringBuilder assignment = new StringBuilder();
                    assignment.append(board[row][col]);
                    visited.add(new Pair<>(row, col));

                    if (backtracking(assignment, row, col, visited, word, 1)) {
                        return true;
                    }
                }

            }
        }

        return false;
    }



    private boolean backtracking(StringBuilder assignment, int row, int col, Set<Pair<Integer, Integer>> visited, String word, int start) {
        if(assignment.toString().equals(word)) {
            return true;
        }

        for(int i = 0; i < 4; i++) { // calculate domains at given point, then iterate domain values
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];

            // if consistent
            if(newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length // in proper range
                    && board[newRow][newCol] == word.charAt(start) // for time complexity
                    && !visited.contains(new Pair<>(newRow, newCol))) { // for preventing visiting already visited point

                assignment.append(board[newRow][newCol]); // assign the value to assignment
                visited.add(new Pair<>(newRow, newCol));

                boolean result = backtracking(assignment, newRow, newCol, visited, word, start + 1); // and move the point
                if(result == true) { // for time complexity
                    return true;
                }

                assignment.deleteCharAt(assignment.length() - 1);
                visited.remove(new Pair<>(newRow, newCol)); // because if we do not remove it, then it can iterate other domains, just finished one route
            }
        }
        return false;
    }
}
