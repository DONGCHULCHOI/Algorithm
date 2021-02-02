package leetcode.top100_questions;

public class RotateImage {
    public void rotate(int[][] matrix) {
        // T.C: O(N^2)
        // S.C: O(1)
        // transpose matrix -> reverse each row // *****
        int n = matrix.length;

        // tranpose matrix // *****
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){ // ***** // to avoid tranposed twice
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // reverse each row // *****
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n/2; j++){ // ***** // to avoid reversed twice
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1]; // ***** // n-j-1 means the corresponding elem of j in a row i
                matrix[i][n-j-1] = tmp;
            }
        }
    }
}
