class Solution {
    public int removeDuplicates(int[] nums) {
         if (nums.length <= 2) {
            return nums.length; // If length is 2 or less, return it as is.
        }

        int j = 2; // Start placing valid elements from index 2
        for (int i = 2; i < nums.length; i++) {
            // Check if the current element is different from the element two positions before it
            if (nums[i] != nums[j - 2]) {
                nums[j] = nums[i]; // Place the valid element
                j++; // Increment the position for the next valid element
            }
        }
        return j; // Length of the array without duplicates
    }
}