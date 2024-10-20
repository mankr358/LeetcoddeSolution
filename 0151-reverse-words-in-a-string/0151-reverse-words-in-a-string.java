import java.util.StringTokenizer;

class Solution {
    public String reverseWords(String s) {
        StringTokenizer st = new StringTokenizer(s);
        StringBuilder result = new StringBuilder();
        
        // By default, StringTokenizer tokenizes on spaces
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            result.insert(0, token + " ");
        }
        
        // Remove the trailing space and return the result
        return result.toString().trim();
    }
}
