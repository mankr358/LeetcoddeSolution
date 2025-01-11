class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0; // Pointer for the next non-zero element
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) { // Only swap when nums[j] is non-zero
                swap(nums, i, j);
                i++; // Increment i only after a successful swap
            }
        }
    }

    // Swap two elements in the array
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
