class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = Arrays.stream(nums).max().getAsInt(); // Max element in nums
        
        // Binary search for the smallest divisor
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (computeSum(nums, mid) > threshold) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left; // Smallest divisor that meets the condition
    }
    
    // Helper function to compute the sum of division results
    private int computeSum(int[] nums, int divisor) {
        int sum = 0;
        for (int num : nums) {
            sum += (num + divisor - 1) / divisor; // Equivalent to Math.ceil(num / divisor)
        }
        return sum;
    }
}
