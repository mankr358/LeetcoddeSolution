class Solution {
    public double findMaxAverage(int[] nums, int k) {
         // Step 1: Calculate the sum of the first k elements
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        // Step 2: Initialize maxSum with the sum of the first k elements
        double maxSum = sum;

        // Step 3: Slide the window over the array
        for (int i = k; i < nums.length; i++) {
            // Update the sum: subtract the element going out of the window and add the new one
            sum = sum - nums[i - k] + nums[i];
            // Update maxSum if the current sum is larger
            maxSum = Math.max(maxSum, sum);
        }

        // Step 4: Return the maximum average
        return maxSum / k;
    }
}