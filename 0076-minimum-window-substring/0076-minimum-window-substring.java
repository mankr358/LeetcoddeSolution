class Solution {
    public String minWindow(String s, String t) {
        
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Dictionary to keep the count of characters in t
        Map<Character, Integer> dictT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            dictT.put(t.charAt(i), dictT.getOrDefault(t.charAt(i), 0) + 1);
        }

        // Number of unique characters in t that must be present in the window
        int required = dictT.size();

        // Left and right pointers
        int left = 0, right = 0;

        // Formed keeps track of how many unique characters in the current window match the required count in t
        int formed = 0;

        // Dictionary to keep the count of characters in the current window
        Map<Character, Integer> windowCounts = new HashMap<>();

        // (window length, left, right)
        int[] ans = {-1, 0, 0};

        while (right < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            // If the frequency of the current character matches the required frequency in t, increase the formed count
            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // Try and contract the window until it ceases to be "desirable"
            while (left <= right && formed == required) {
                c = s.charAt(left);

                // Update the result if this window is smaller than the previous best
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                // The character at the position pointed by the left pointer is no longer a part of the window
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }

                // Move the left pointer ahead to contract the window
                left++;
            }

            // Keep expanding the window by moving right
            right++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    
    }
}