class Solution {
    public int hIndex(int[] citations) {
          // Sort the citations array in ascending order
        Arrays.sort(citations);
        int n = citations.length;

        // Traverse the sorted array and find the h-index
        for (int i = 0; i < n; i++) {
            // The h-index is the largest number h such that citations[i] >= h
            int h = n - i;  // h represents the number of papers with citations >= citations[i]
            if (citations[i] >= h) {
                return h;
            }
        }
        
        // If no valid h-index found, return 0
        return 0;
    }
}