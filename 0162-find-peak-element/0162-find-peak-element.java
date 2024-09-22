class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Compare mid with its next element
            if (nums[mid] < nums[mid + 1]) {
                // If the next element is greater, move to the right half
                left = mid + 1;
            } else {
                // Otherwise, move to the left half
                right = mid;
            }
        }
        return left; // left will be the index of a peak element
    }
}
