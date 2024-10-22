class Solution {
    public int maxArea(int[] height) {
          int left = 0;
    int right = height.length - 1;
    int maxArea = 0;

    while (left < right) {
        int width = right - left;
        int length = Math.min(height[left], height[right]);
        int area = width * length;
        maxArea = Math.max(maxArea, area);

        // Move the shorter line
        if (height[left] < height[right]) {
            left++;
        } else {
            right--;
        }
    }
    return maxArea;
    }
}