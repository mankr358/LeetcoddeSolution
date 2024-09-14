

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        int pLength = p.length();
        int sLength = s.length();

        if (sLength < pLength) {
            return result; // No valid anagrams if s is shorter than p
        }

        // Count frequency of characters in p
        for (char ch : p.toCharArray()) {
            pCount[ch - 'a']++;
        }

        // Initial window
        for (int i = 0; i < pLength; i++) {
            sCount[s.charAt(i) - 'a']++;
        }

        // Slide the window over s
        if (matches(pCount, sCount)) {
            result.add(0);
        }

        for (int i = pLength; i < sLength; i++) {
            // Add the next character to the window
            sCount[s.charAt(i) - 'a']++;
            // Remove the character going out of the window
            sCount[s.charAt(i - pLength) - 'a']--;

            // Check if current window matches
            if (matches(pCount, sCount)) {
                result.add(i - pLength + 1);
            }
        }

        return result;
    }

    // Helper method to compare two frequency arrays
    private boolean matches(int[] pCount, int[] sCount) {
        for (int i = 0; i < 26; i++) {
            if (pCount[i] != sCount[i]) {
                return false;
            }
        }
        return true;
    }
}
