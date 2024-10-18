public class Solution {
    public int findDuplicate(int[] nums) {
        // Step 1: Initialize the slow and fast pointers
        int slow = nums[0];
        int fast = nums[0];

        // Step 2: Find the intersection point of the two runners
        do {
            slow = nums[slow]; // move slow by 1 step
            fast = nums[nums[fast]]; // move fast by 2 steps
        } while (slow != fast);

        // Step 3: Find the entrance to the cycle
        slow = nums[0]; // reset slow to the beginning
        while (slow != fast) {
            slow = nums[slow]; // move one step
            fast = nums[fast]; // move one step
        }

        // The duplicate number is at the intersection point
        return slow;
    }
}
