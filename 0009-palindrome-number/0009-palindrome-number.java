class Solution {
    public boolean isPalindrome(int x) {
          // Negative numbers and numbers ending with 0 (except for 0 itself) are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10; // Add the last digit to the reversedHalf
            x /= 10; // Remove the last digit from x
        }

        // Check if the original number (x) is equal to the reversedHalf or if it is equal after removing the middle digit (for odd lengths)
        return x == reversedHalf || x == reversedHalf / 10;
    }
}