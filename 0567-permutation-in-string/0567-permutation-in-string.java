class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(); // Fix: Use length() method for strings
        int len2 = s2.length();
        
        if (len1 > len2) return false; // If s1 is longer than s2, it's impossible to find a permutation
        
        int[] count = new int[26];
        
        // Initialize count array with the frequency of characters in s1
        for (char ch : s1.toCharArray()) { // Fix: Use toCharArray() to loop through string
            count[ch - 'a']++;
        }
        
        // Traverse the string s2 with a sliding window of size len1
        for (int i = 0; i < len2; i++) {
            // Decrease the count for the current character
            count[s2.charAt(i) - 'a']--;
            
            // When the window size exceeds len1, increment the count for the character that is sliding out of the window
            if (i >= len1) {
                count[s2.charAt(i - len1) - 'a']++;
            }
            
            // After adjusting the counts, check if all counts are zero
            if (allZero(count)) {
                return true;
            }
        }
        
        // If no permutation match was found, return false
        return false;
    }

    // Helper method to check if all counts are zero
    private boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
