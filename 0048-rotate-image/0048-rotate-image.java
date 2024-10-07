class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;  // Get the number of rows (also columns since it's a square matrix)
        
        // Transpose the matrix (swap matrix[i][j] with matrix[j][i])
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                // Swap matrix[i][j] with matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row to get the rotated matrix
        for (int i = 0; i < m; i++) {
            reverseRow(matrix[i]);
        }
    }

    // Helper function to reverse an array (row)
    private void reverseRow(int[] row) {
        int left = 0, right = row.length - 1;
        while (left < right) {
            // Swap row[left] with row[right]
            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }
}
