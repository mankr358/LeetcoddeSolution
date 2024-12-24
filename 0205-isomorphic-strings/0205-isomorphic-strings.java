class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // Two maps for forward and reverse mapping
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);

            // Check if mapping exists in mapST
            if (mapST.containsKey(chS)) {
                // If it exists, it must match the corresponding character in t
                if (mapST.get(chS) != chT) {
                    return false;
                }
            } else {
                // Create a new mapping
                mapST.put(chS, chT);
            }

            // Check if mapping exists in mapTS
            if (mapTS.containsKey(chT)) {
                // If it exists, it must match the corresponding character in s
                if (mapTS.get(chT) != chS) {
                    return false;
                }
            } else {
                // Create a new mapping
                mapTS.put(chT, chS);
            }
        }

        return true; // Passed all checks
    }
}
