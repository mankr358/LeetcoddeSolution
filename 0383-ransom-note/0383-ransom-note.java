class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Create an array of size 26 for counting the frequency of letters
        int[] charCount = new int[26];
        
        // Count the frequency of each character in magazine
        for (char c : magazine.toCharArray()) {
            charCount[c - 'a']++;
        }
        
        // Check if ransomNote can be constructed
        for (char c : ransomNote.toCharArray()) {
            if (charCount[c - 'a'] == 0) {
                // If the character is not available in magazine, return false
                return false;
            }
            charCount[c - 'a']--; // Use one occurrence of the character
        }
        
        // If we can construct the ransomNote, return true
        return true;
    }
}