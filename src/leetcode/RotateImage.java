package leetcode;

public class RotateImage {
    public int[][] rotate(int[][] matrix) {
        // T.C: O(N^2)
        // S.C: O(1)
        // assume N * N array
        // transpose matrix -> reverse each row
        int n = matrix.length;

        // tranpose matrix // ***
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){ // ***
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }

        // reverse each row // ***
        for(int i=0; i<n; i++){
            for(int j=0; j<n/2; j++){ // reverse only the half of the array // ***
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1]; // ***
                matrix[i][n-j-1] = tmp;
            }
        }
        return matrix;
    }
}
