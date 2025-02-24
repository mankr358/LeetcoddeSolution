import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        // Step 1: Sort the intervals based on the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Step 2: Initialize the result list
        List<int[]> result = new ArrayList<>();
        
        // Add the first interval to the result list
        result.add(intervals[0]);
        
        // Step 3: Iterate through the sorted intervals and merge overlapping intervals
        for (int i = 1; i < intervals.length; i++) {
            int[] lastInterval = result.get(result.size() - 1);
            int[] currentInterval = intervals[i];
            
            // Check if the current interval overlaps with the last interval in the result list
            if (currentInterval[0] <= lastInterval[1]) {
                // Merge the intervals by updating the end time of the last interval
                lastInterval[1] = Math.max(lastInterval[1], currentInterval[1]);
            } else {
                // If no overlap, add the current interval to the result list
                result.add(currentInterval);
            }
              }
        
        // Convert the result list to a 2D array and return
        return result.toArray(new int[result.size()][]);
    }
}
