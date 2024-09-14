class Solution {
    public boolean isPalindrome(String s) {
        int p1 = 0, p2 = s.length() - 1;

        while (p1 < p2) {
            char ch1 = s.charAt(p1);
            char ch2 = s.charAt(p2);

            // Check if ch1 is not alphanumeric, if so, move the p1 pointer forward
            if (!(ch1 >= 'a' && ch1 <= 'z' || ch1 >= 'A' && ch1 <= 'Z' || ch1 >= '0' && ch1 <= '9')) {
                p1++;
                continue;
            }

            // Check if ch2 is not alphanumeric, if so, move the p2 pointer backward
            if (!(ch2 >= 'a' && ch2 <= 'z' || ch2 >= 'A' && ch2 <= 'Z' || ch2 >= '0' && ch2 <= '9')) {
                p2--;
                continue;
            }

            // Convert both characters to lowercase for comparison
            if (Character.toLowerCase(ch1) != Character.toLowerCase(ch2)) {
                return false;
            }

            // Move both pointers inward
            p1++;
            p2--;
        }

        // If the loop completes without returning false, it is a palindrome
        return true;
    }
}
