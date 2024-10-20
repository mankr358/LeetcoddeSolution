class Solution {
    public int strStr(String haystack, String needle) {
           int m = haystack.length(); // Length of the haystack string
        int n = needle.length();   // Length of the needle string

        // Edge case: If needle is empty, return 0 (as per problem statement)
        if (n == 0) {
            return 0;
        }

        // Iterate over haystack from index 0 to (m-n), so we have enough characters left for comparison
        for (int i = 0; i <= m - n; i++) {
            
            // Check each character of needle against the corresponding characters in haystack
            for (int j = 0; j < n; j++) {
                
                // If characters don't match, break the inner loop and try the next position in haystack
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                
                // If we've reached the end of the needle, it means the entire needle was found
                if (j == n - 1) {
                    return i; // Return the starting index of the match
                }
            }
        }

        // If no match is found, return -1
        return -1;
    
    }
}