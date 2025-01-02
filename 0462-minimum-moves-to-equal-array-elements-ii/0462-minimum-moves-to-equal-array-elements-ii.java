class Solution {
    public int minMoves2(int[] nums) {
          Arrays.sort(nums); // Sort the array
        int start = 0;
        int end = nums.length - 1;
        int count = 0;

        while (start <= end) {
            count += nums[end] - nums[start]; // Add the difference
            start++;
            end--;
        }

        return count;
    }
}