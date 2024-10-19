import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> numberSet = new HashSet<>();
        for (int num : nums) {
            numberSet.add(num);
        }

        int longestLength = 0;

        // Iterate over each number
        for (int num : numberSet) {
            // Only start counting if `num` is the start of a sequence
            if (!numberSet.contains(num - 1)) {
                int currentLength = 1;
                int currentNum = num;

                // Count consecutive numbers
                while (numberSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                longestLength = Math.max(longestLength, currentLength);
            }
        }

        return longestLength;
    }
}
