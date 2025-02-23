class Solution {
    public String intToRoman(int num) {
           // Arrays to store Roman numerals and their corresponding values
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        // Iterate through the values and symbols
        for (int i = 0; i < values.length; i++) {
            // Repeat the current symbol while the number is greater than or equal to the current value
            while (num >= values[i]) {
                sb.append(symbols[i]); // Append the symbol
                num -= values[i];     // Subtract the value from the number
            }
        }
        return sb.toString();
    }
}