class Solution {
    public void nextPermutation(int[] nums) {
       int n = nums.length;
    int gola_index = -1;

    // Step 1: Find the first decreasing pair from the right
    for (int i = n - 1; i > 0; i--) {
        if (nums[i] > nums[i - 1]) {
            gola_index = i - 1;
            break;
        }
    }

    // If a decreasing pair was found
    if (gola_index != -1) {
        int swap_index = gola_index;

        // Step 2: Find the element just larger than nums[gola_index]
        for (int j = n - 1; j > gola_index; j--) {
            if (nums[j] > nums[gola_index]) {
                swap_index = j;
                break;
            }
        }

        // Step 3: Swap the elements
        swap(nums, gola_index, swap_index);
    }

    // Step 4: Reverse the part of the array after gola_index
    reverse(nums, gola_index + 1, n - 1);
}

// Helper function to swap two elements
private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}

// Helper function to reverse the array from index 'start' to 'end'
private void reverse(int[] nums, int start, int end) {
    while (start < end) {
        swap(nums, start, end);
        start++;
        end--;
    }
}
}