class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0; // Already at the end
        if (nums[0] == 0) return -1; // Cannot move from the start

        int jumps = 0;
        int pos = 0, des = 0;

        for (int i = 0; i < n - 1; i++) {
            des = Math.max(des, i + nums[i]);

            if (pos == i) { // Need to jump
                if (pos == des) return -1; // Stuck, cannot proceed further
                pos = des;
                jumps++;
            }

            if (pos >= n - 1) return jumps; // Reached the last index
        }
        return -1; // If loop exits without reaching the end
    }
}
