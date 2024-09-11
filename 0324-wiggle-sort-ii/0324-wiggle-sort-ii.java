class Solution {
    public void wiggleSort(int[] nums) {
      int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        
        int mid = (n - 1) / 2;  // Middle index of the sorted array
        int end = n - 1;  // End of the sorted array
        
        // Fill odd indices with larger half and even indices with smaller half
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = sorted[mid--];  // Fill smaller half at even indices
            } else {
                nums[i] = sorted[end--];  // Fill larger half at odd indices
            }
        }   
    }
}