class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        
        // If lengths of pattern and words do not match, return false
        if (pattern.length() != words.length) {
            return false;
        }
        
        HashMap<Character, String> charToWordMap = new HashMap<>();
        HashMap<String, Character> wordToCharMap = new HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            
            // Check if the character already has a mapping to a different word
            if (charToWordMap.containsKey(c)) {
                if (!charToWordMap.get(c).equals(word)) {
                    return false;
                }
            } else {
                charToWordMap.put(c, word);
            }
            
            // Check if the word already has a mapping to a different character
            if (wordToCharMap.containsKey(word)) {
                if (wordToCharMap.get(word) != c) {
                    return false;
                }
            } else {
                wordToCharMap.put(word, c);
            }
        }
        
        return true;
    }
}