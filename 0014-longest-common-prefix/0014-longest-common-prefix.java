class Solution {
    // Method to find the common prefix between two strings
    public String common(String s1, String s2) {
        int n = Math.min(s1.length(), s2.length()); // Take the smaller length
        StringBuilder sb = new StringBuilder(); // For building the common prefix
        
        for (int i = 0; i < n; i++) { // Compare characters
            if (s1.charAt(i) == s2.charAt(i)) {
                sb.append(s1.charAt(i)); // Append if characters match
            } else {
                break; // Stop when characters differ
            }
        }
        return sb.toString(); // Return the common prefix
    }

    // Method to find the longest common prefix in an array of strings
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return ""; // Handle edge cases
        }
        
        String res = strs[0]; // Start with the first string
        
        for (int i = 1; i < strs.length; i++) { // Compare with each string
            res = common(res, strs[i]);
        }
        return res; // Return the final longest common prefix
    }
}
