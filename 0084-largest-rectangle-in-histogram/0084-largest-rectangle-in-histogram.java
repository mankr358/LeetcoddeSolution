class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        // Fill left boundaries
        left[0] = -1;  // First element has no left boundary
        for (int i = 1; i < n; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i]) {
                p = left[p];  // Move to the left boundary of the previous bar
            }
            left[i] = p;
        }
        
        // Fill right boundaries
        right[n - 1] = n;  // Last element has no right boundary
        for (int i = n - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < n && heights[p] >= heights[i]) {
                p = right[p];  // Move to the right boundary of the next bar
            }
            right[i] = p;
        }
        
        // Calculate the largest rectangle area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }
}