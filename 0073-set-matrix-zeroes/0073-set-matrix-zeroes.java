class Solution {
   public void setZeroes(int[][] matrix) {
     int n = matrix.length;
        int m = matrix[0].length;

        boolean row = false, col = false;

        // Check if the first column should be set to zero
        for (int i = 0; i < n; i++) 
            if (matrix[i][0] == 0) 
                col = true;

        // Check if the first row should be set to zero
        for (int j = 0; j < m; j++) 
            if (matrix[0][j] == 0) 
                row = true;

        // Use first row and column as markers
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set rows based on markers
        for (int i = 1; i < n; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Set columns based on markers
        for (int j = 1; j < m; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < n; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Set the first row if needed
        if (row) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        // Set the first column if needed
        if (col) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}