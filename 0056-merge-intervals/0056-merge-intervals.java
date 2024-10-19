import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // Step 1: Sort the intervals based on the start time
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        // Step 2: Initialize the result list to store merged intervals
        List<int[]> result = new ArrayList<>();

        // Step 3: Use the first interval as the base interval for comparison
        int[] currentInterval = intervals[0];
        result.add(currentInterval);

        // Step 4: Iterate through the intervals and merge overlapping intervals
        for (int[] interval : intervals) {
            int currentStart = currentInterval[0];
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (nextStart <= currentEnd) {
                // If intervals overlap, merge them by updating the end time
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // If intervals do not overlap, add the new interval to the result
                currentInterval = interval;
                result.add(currentInterval);
            }
        }

        // Step 5: Convert the result list to a 2D array and return
        return result.toArray(new int[result.size()][]);
    }
}
