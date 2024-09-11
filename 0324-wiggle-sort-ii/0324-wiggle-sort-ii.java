
class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int mid = (n + 1) / 2;  // The middle index of the smaller half
        int j = mid - 1;        // Points to the end of the smaller half
        int k = n - 1;          // Points to the end of the larger half

        // Rearranging the sorted array in wiggle fashion
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = sorted[j--];  // Even index, assign from smaller half
            } else {
                nums[i] = sorted[k--];  // Odd index, assign from larger half
            }
        }
    }
}
