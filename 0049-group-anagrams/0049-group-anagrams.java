class Solution {
   // Function to group anagrams together
    public List<List<String>> groupAnagrams(String[] strs) {
        // Step 1: Create a HashMap where each key will represent a unique character count signature,
        // and the value will be a list of strings that match this signature (i.e., anagrams).
        Map<String, List<String>> map = new HashMap<>();

        // Step 2: Loop over each string in the input array.
        for (String s : strs) {
            // Step 3: Create an array to count the frequency of each letter (from 'a' to 'z').
            int[] count = new int[26];

            // Step 4: For each character in the string, increment the corresponding index in the count array.
            for (char c : s.toCharArray()) {
                count[c - 'a']++;  // Count the frequency of each character
            }

            // Step 5: Create a unique key based on the character count array.
            // Use StringBuilder to efficiently create this key, adding a "#" between each count for distinction.
            StringBuilder sb = new StringBuilder();
            for (int i : count) {
                sb.append("#").append(i);  // Example: "aab" -> "#2#1#0#0..."
            }
            String key = sb.toString();  // This key uniquely represents the character counts of the string

            // Step 6: If the map does not contain this key, create a new entry.
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }

            // Step 7: Add the string to the list of anagrams corresponding to this key.
            map.get(key).add(s);
        }

        // Step 8: Return the list of grouped anagrams (the values of the map).
        return new ArrayList<>(map.values());
    }
}