class Solution {
    public int longestSubarray(int[] nums) {
         int left = 0;
        int zeroCount = 0; // Number of zeros in the current window
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            // Expand the window by including nums[right]
            if (nums[right] == 0) {
                zeroCount++;
            }

            // Shrink the window from the left if there are more than one zero
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // Update maxLength considering that we have to delete one element
            // The length of the current valid window is (right - left + 1)
            // We subtract 1 because we have to delete one element
            maxLength = Math.max(maxLength, right - left + 1 - 1);
        }

        return maxLength;
    }
}