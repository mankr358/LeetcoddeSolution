class Solution {
    public int maxScore(String s) {
         int totalOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') totalOnes++;
        }

        int leftZeros = 0;
        int rightOnes = totalOnes;
        int maxScore = 0;

        // Iterate through the string (excluding the last character for valid splits)
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                leftZeros++;
            } else {
                rightOnes--;
            }

            // Calculate score and update maxScore
            maxScore = Math.max(maxScore, leftZeros + rightOnes);
        }

        return maxScore;
    }
}