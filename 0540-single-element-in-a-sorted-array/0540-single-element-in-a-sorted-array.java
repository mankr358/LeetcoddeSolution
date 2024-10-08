class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int mid;
        
        while (l < r) {
            mid = l + (r - l) / 2;
            boolean isEven = (r - mid) % 2 == 0;

            // Check if mid is equal to the next element
            if (nums[mid] == nums[mid + 1]) {
                if (isEven) {
                    l = mid + 2;  // Move left pointer
                } else {
                    r = mid - 1;  // Move right pointer
                }
            } 
            // Check if mid is equal to the previous element
            else if (nums[mid] == nums[mid - 1]) {
                if (isEven) {
                    r = mid - 2;  // Move right pointer
                } else {
                    l = mid + 1;  // Move left pointer
                }
            } else {
                return nums[mid];  // Single element found
            }
        }
        
        return nums[l];  // The single element will be at l (or r)
    }
}
