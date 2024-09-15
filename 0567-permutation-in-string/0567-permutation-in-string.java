public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Edge case: if s1 is longer than s2, it's impossible for s2 to contain any permutation of s1
        if (s1.length() > s2.length()) {
            return false;
        }
        
        // Arrays to store frequency of characters in s1 and the current window in s2
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        
        // Fill the s1Count with the frequency of characters in s1
        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }
        
        // Traverse the string s2 using a sliding window of size s1.length()
        int windowSize = s1.length();
        for (int i = 0; i < s2.length(); i++) {
            // Add current character to the window's character count
            s2Count[s2.charAt(i) - 'a']++;
            
            // If window size exceeds, remove the character that is out of the window
            if (i >= windowSize) {
                s2Count[s2.charAt(i - windowSize) - 'a']--;
            }
            
            // Compare the two frequency arrays. If they are the same, return true
            if (matches(s1Count, s2Count)) {
                return true;
            }
        }
        
        return false;
    }
    
    // Helper method to check if the frequency arrays match
    private boolean matches(int[] s1Count, int[] s2Count) {
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] != s2Count[i]) {
                return false;
            }
        }
        return true;
    }
}
