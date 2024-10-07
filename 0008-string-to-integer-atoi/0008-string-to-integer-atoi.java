class Solution {
    public int myAtoi(String s) {
        s = s.trim();  // Remove leading/trailing whitespaces
        if (s.length() == 0) {
            return 0;
        }

        int i = 0;
        boolean neg = false;

        // Handle optional sign
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            neg = s.charAt(i) == '-';
            i++;
        }

        long ans = 0;

        // Process digits
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int dig = s.charAt(i) - '0';
            ans = ans * 10 + dig;

            // Check for overflow
            if (!neg && ans > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (neg && -ans < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }

        // Apply sign if negative
        if (neg) {
            ans = -ans;
        }

        return (int) ans;
    }
}
