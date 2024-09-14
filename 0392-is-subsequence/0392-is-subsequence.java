class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true; // An empty string is always a subsequence
        if (t.length() == 0) return false; // If s is not empty and t is empty, s can't be a subsequence of t
        
        int sIndex = 0;
        int tIndex = 0;
        
        // Traverse through both strings
        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++; // Move to the next character in s
            }
            tIndex++; // Always move to the next character in t
        }
        
        // If sIndex has reached the length of s, it means we found all characters of s in t
        return sIndex == s.length(); 
}
}