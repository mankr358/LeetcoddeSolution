class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle cases where k > n
        
        // Reverse the first part
        swap(nums, 0, n - k - 1);
        // Reverse the second part
        swap(nums, n - k, n - 1);
        // Reverse the entire array
        swap(nums, 0, n - 1);
    }
    
    public void swap(int[] nums, int start, int end) {
        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++; // Move start forward
            end--;   // Move end backward
        }
    }
}
