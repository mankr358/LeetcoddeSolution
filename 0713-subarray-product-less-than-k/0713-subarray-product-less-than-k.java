class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
      if (k <= 1) return 0; // If k is 1 or less, no subarray can have product < 1

    int prod = 1, result = 0;
    int left = 0;

    for (int right = 0; right < nums.length; right++) {
        prod *= nums[right]; 
        while (prod >= k && left <= right) {
            prod /= nums[left]; 
            left++;
        }
         result += right - left + 1;
    }

    return result;
    }
}