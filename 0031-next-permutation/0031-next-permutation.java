class Solution {
    public void nextPermutation(int[] nums) {
         int n = nums.length;

        // Step 1: Find the first index from the end where nums[i] > nums[i-1]
        int i = n - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }

        // Step 2: If the sequence is not in descending order
        if (i > 0) {
            int index = i;

            // Step 3: Find the first number larger than nums[i-1]
            for (int j = n - 1; j >= i; j--) {
                if (nums[j] > nums[i - 1]) {
                    index = j;
                    break;
                }
            }

            // Step 4: Swap nums[i-1] with the number found at 'index'
            swap(nums, i - 1, index);
        }

        // Step 5: Reverse the sequence after the index 'i'
        reverse(nums, i, n - 1);
    }

    // Helper function to swap two elements
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Helper function to reverse an array from index 'start' to 'end'
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        
    }
}
}