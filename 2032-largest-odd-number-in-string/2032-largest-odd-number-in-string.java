class Solution {
    public String largestOddNumber(String num) {
         // Start from the end of the string
        for (int i = num.length() - 1; i >= 0; i--) {
            // Check if the current digit is odd
            if ((num.charAt(i) - '0') % 2 != 0) {
                // Return the substring from 0 to i+1 as the largest odd number
                return num.substring(0, i + 1);
            }
        }
        // If no odd digit is found, return an empty string
        return "";
    }
}