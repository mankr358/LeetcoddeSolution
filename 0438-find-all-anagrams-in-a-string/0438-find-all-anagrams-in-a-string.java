

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // Initialize an array to keep track of character counts
        int[] arr = new int[26];

        int m = s.length();
        int n = p.length();

        // Populate the array with character frequencies from string 'p'
        for (char ch : p.toCharArray()) {
            arr[ch - 'a']++;
        }

        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();

        // Sliding window approach
        while (j < m) {
            arr[s.charAt(j) - 'a']--;

            // When the window size matches the length of 'p'
            if (j - i + 1 == n) {
                // If the array is all zeroes, we found an anagram
                if (Arrays.equals(arr, new int[26])) {
                    result.add(i);
                }

                // Move the window forward
                arr[s.charAt(i) - 'a']++;
                i++;
            }
            j++;
        }

        return result;
    }
}
