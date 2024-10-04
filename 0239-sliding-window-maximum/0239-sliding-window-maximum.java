class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> q = new ArrayDeque<>(); // Deque to store indices
        int i = 0, j = 0, ptr = 0; // i: window start, j: window end, ptr: result index
        int n = nums.length; // Length of the input array
        int[] res = new int[n - k + 1]; // Result array to store max of each window

        while (j < n) {
            // Remove elements smaller than the current element nums[j] from the back of the deque
            while (!q.isEmpty() && nums[q.peekLast()] < nums[j]) {
                q.pollLast();
            }
            
            // Add current element's index to the deque
            q.add(j);

            // Check if the current window size is less than k
            if (j - i + 1 < k) {
                j++; // Expand the window by moving the end pointer j
            } else if (j - i + 1 == k) {
                // Window size is k, so add the max (front of deque) to the result
                res[ptr++] = nums[q.peek()];

                // If the element leaving the window is the max (front of deque), remove it
                if (nums[i] == nums[q.peek()]) {
                    q.pollFirst();
                }
                
                // Slide the window: increment both start (i) and end (j) pointers
                i++;
                j++;
            }
        }

        return res; // Return the result array containing the max of each window
    }
}
