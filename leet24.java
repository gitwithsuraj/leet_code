//867. Transpose Matrix

class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;        // number of rows
        int n = matrix[0].length;     // number of columns
        
        // Initialize the result matrix with dimensions n x m
        int[][] transposed = new int[n][m];
        
        // Transpose the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        
        return transposed;
    }
}
