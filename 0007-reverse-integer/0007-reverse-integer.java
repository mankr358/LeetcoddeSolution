class Solution {
    public int reverse(int x) {
        long reversed = 0; // Use long to handle overflow cases
        int sign = (x < 0) ? -1 : 1; // Determine the sign of x
        x = Math.abs(x); // Work with positive numbers

        while (x != 0) {
            int digit = x % 10; // Extract the last digit
            x /= 10; // Remove the last digit from x

            // Check for overflow before updating the reversed number
            if (reversed > (Integer.MAX_VALUE - digit) / 10) {
                return 0; // Return 0 if overflow will occur
            }

            reversed = reversed * 10 + digit; // Build the reversed number
        }

        return (int) reversed * sign; // Restore the original sign
    }
}