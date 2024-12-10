class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int i = 0; // Pointer for the last unique element
        for (int j = 1; j < nums.length; j++) { // Start from the second element
            if (nums[i] != nums[j]) { // Check if the current element is different
                i++; // Move to the next position for the unique element
                nums[i] = nums[j]; // Update the position with the unique element
            }
        }
        
        return i + 1; // Length of the unique elements
    }
}