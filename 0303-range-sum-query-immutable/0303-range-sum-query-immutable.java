class NumArray {
    private int[] prefixSum;

    public NumArray(int[] nums) {
        int n = nums.length;
        // Initialize the prefixSum array of size n + 1
        prefixSum = new int[n + 1]; 
        prefixSum[0] = 0;  // First element is 0 for handling sum calculation

        // Compute the prefix sum array
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];  // Accumulate sum
        }
    }
    
    // Function to calculate the sum from index left to right
    public int sumRange(int left, int right) {
        // Subtract the prefix sum at left from prefix sum at right+1
        return prefixSum[right + 1] - prefixSum[left];
    }
}


/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */