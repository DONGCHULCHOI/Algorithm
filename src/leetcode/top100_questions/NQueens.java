package leetcode.top100_questions;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    // Backtracking:
    // time complexity
    // only one domains -> 1, has to iterate for selecting unassinged var -> for
    // assignment is 2D
    // overall process direction: row by row, in the row, col by col
    // for checking consistency:
    //      int[] cols: for check whether new queen is attacked by other queens located on same column
    //                  don't have to consider attacks by other queens located on same row
    //                  cuz we continue to assign the queens row by row
    //      int[] hills / int[] dales: for check whether new quuen is attacked by other queens located on same diagonals
    //          num of diagonals of hill/dale = 2 * n - 1
    //          hill diagonal: row + col = id of the hill diagonal, hills[2 * n - 1]
    //          dale diagonal: row - col = id of the dale diagonal -> cuz there is negative number, it's not proper for the idx, so add 2 * n
    //                         row - col + 2 * n = id of the dale diagonal, dales[4 * n - 1]
    //
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        int[] cols = new int[n];
        int[] hills = new int[2 * n + 1];
        int[] dales = new int[4 * n + 1];
        backtracking(list, new ArrayList<>(), 0, n, cols, hills, dales);

        return list;
    }

    public void backtracking(List<List<String>> list, List<String> assignment, int row, int n, int[] cols, int[] hills, int[] dales) {
        if(row == n) {
            list.add(new ArrayList<>(assignment));
            return;
        }

        for(int col = 0; col < n; col++) { // select unassigned var, don't have to iterate domains cuz domain is 1
            if(cols[col] + hills[row + col] + dales[row - col + 2 * n] == 0) { // if consistence
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < col; i++) {
                    sb.append('.');
                }
                sb.append('Q');
                for(int i = col + 1; i < n; i++) {
                    sb.append('.');
                }
                assignment.add(sb.toString());
                // for consitency check
                cols[col] = 1;
                hills[row + col] = 1;
                dales[row - col + 2 * n] = 1;

                backtracking(list, assignment, row + 1, n, cols, hills, dales);

                for(int i = n - 1; i >= 0; i--) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                assignment.remove(assignment.size() - 1);
                // for consitency check
                cols[col] = 0;
                hills[row + col] = 0;
                dales[row - col + 2 * n] = 0;
            }
        }
    }
}
