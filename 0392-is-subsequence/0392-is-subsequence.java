class Solution {
    public boolean isSubsequence(String s, String t) {
         Map<Character, List<Integer>> mp = new HashMap<>();
        
        // Build the map of character to list of indices in t
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            mp.computeIfAbsent(ch, k -> new ArrayList<>()).add(i);
        }
        
        int prev = -1;
        
        // Check if each character in s is in t in the correct order
        for (char ch : s.toCharArray()) {
            if (!mp.containsKey(ch)) {
                return false;
            }
            
            List<Integer> indices = mp.get(ch);
            int index = Collections.binarySearch(indices, prev + 1);
            
            // Adjust index if necessary
            if (index < 0) {
                index = -index - 1;
            }
            
            // Check if we have a valid index
            if (index == indices.size()) {
                return false;
            }
            
            prev = indices.get(index);
        }
        
        return true;
    }
}