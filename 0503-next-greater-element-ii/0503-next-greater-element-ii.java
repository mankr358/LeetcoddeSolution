class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];  // Array to store the results
        Stack<Integer> stack = new Stack<>();  // Stack to store indices
        
        // Initialize all elements in result as -1
        Arrays.fill(result, -1);
        
        // Loop through the array twice (to simulate the circular nature)
        for (int i = 0; i < 2 * n; i++) {
            int currentIndex = i % n;  // This helps in simulating the circular array
            while (!stack.isEmpty() && nums[stack.peek()] < nums[currentIndex]) {
                result[stack.pop()] = nums[currentIndex];  // Set the next greater element
            }
            if (i < n) {
                stack.push(i);  // Push the current index onto the stack
            }
        }
        
        return result;
    }
}