package leetcode;

public class NQueensII {
    public int totalNQueens(int n) {
        // rows and cols
        int[] rows = new int[n];
        // "hill" diagonals
        int[] hills = new int[2 * n - 1];
        // "dale" diagonals
        int[] dales = new int[4 * n - 1];

        return backtrack(0, 0, n, rows, dales, hills);
    }

    public boolean is_not_under_attack(int row, int col, int n,
                                       int[] rows,
                                       int[] dales,
                                       int[] hills) {
        int res = rows[col] + hills[row + col] + dales[row - col + 2 * n];
        return (res == 0) ? true : false;
    }

    public int backtrack(int row, int count, int n,
                         int[] rows,
                         int[] dales,
                         int[] hills) {
        for (int col = 0; col < n; col++) {
            if (is_not_under_attack(row, col, n, rows, dales, hills)) {
                // place_queen
                rows[col] = 1;
                hills[row + col] = 1;   //"hill" diagonals
                dales[row - col + 2 * n] = 1;  // "dale" diagonals

                // backtrack
                // if n queens are already placed
                if (row + 1 == n) count++;
                    // if not proceed to place the rest
                else count = backtrack(row + 1, count, n, rows, dales, hills);

                // remove queen
                rows[col] = 0;
                hills[row + col] = 0;
                dales[row - col + 2 * n] = 0;
            }
        }
        return count;
    }
}
