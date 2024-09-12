class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Create a HashMap where the key is a sorted string, and the value is a list of 
        Map<String, List<String>> map = new HashMap<>();
        
        // Loop through each string in the input array
        for (String str : strs) {
            // Convert the string into a char array, sort it, and then convert it back to a 
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            
            // If the sorted string is not in the map, add it with a new list
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            
            // Add the original string to the corresponding list in the map
            map.get(sortedStr).add(str);
        }
        
        // Return the list of grouped anagrams
        return new ArrayList<>(map.values());
    } 
    }
