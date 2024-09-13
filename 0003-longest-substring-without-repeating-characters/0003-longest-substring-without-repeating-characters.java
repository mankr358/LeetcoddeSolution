class Solution {
    public int lengthOfLongestSubstring(String s) {
           // Base case: if string is empty, return 0
        if (s == null || s.length() == 0) {
            return 0;
        }

        // HashSet to store unique characters in the current window
        Set<Character> uniqueChars = new HashSet<>();

        int maxLength = 0;
        int left = 0; // Left pointer of the window

        // Move the right pointer to expand the window
        for (int right = 0; right < s.length(); right++) {
            // If the character is already in the set, remove characters from the left side until it's unique
            while (uniqueChars.contains(s.charAt(right))) {
                uniqueChars.remove(s.charAt(left));
                left++; // Shrink the window
            }

            // Add the current character to the set
            uniqueChars.add(s.charAt(right));

            // Update the maximum length of the substring found so far
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}