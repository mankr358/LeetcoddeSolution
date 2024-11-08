class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int left = 0; // Initialize the left pointer
        char[] arr = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < arr.length; right++) {
            int idx = map.getOrDefault(arr[right], -1);
            if (idx != -1 && idx >= left) {
                left = idx + 1;
            }
            res = Math.max(res, right - left + 1); // Update res after each iteration
            map.put(arr[right], right);
        }

        return res; 
    }
}