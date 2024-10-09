class Solution {
    public int minAddToMakeValid(String s) {
        int size = 0; // Tracks unmatched opening parentheses '('
        int open = 0; // Tracks unmatched closing parentheses ')'
        
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                size++; // Found an unmatched opening parenthesis
            } else if (size > 0) {
                size--; // Match a closing parenthesis with an unmatched opening
            } else {
                open++; // Found an unmatched closing parenthesis
            }
        }
        return size + open; // Total unmatched parentheses
    }
}
