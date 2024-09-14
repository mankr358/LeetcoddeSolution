class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> charSet = new HashSet<>();
        int palindromeLength = 0;

        for (char c : s.toCharArray()) {
            // If character is already in the set, it means we have seen it before
            if (charSet.contains(c)) {
                // Remove it from the set (this pair can contribute to the palindrome)
                charSet.remove(c);
                // Increase the palindrome length by 2 (this pair is added to both ends)
                palindromeLength += 2;
            } else {
                // If character is not in the set, add it (potential for future pair)
                charSet.add(c);
            }
        }

        // If there are characters left in the set, we can place one in the middle
        if (!charSet.isEmpty()) {
            palindromeLength++;
        }

        return palindromeLength;
    }
}