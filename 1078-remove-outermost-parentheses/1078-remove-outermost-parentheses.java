class Solution {
    public String removeOuterParentheses(String s) {
        // Stack<Character> st = new Stack<>();
        // StringBuilder sb = new StringBuilder();

        // for(int i =0;i<s.length();i++){
        //     char ch = s.charAt(i);
        //     if(sb ='('){
        //         if(st.size() > 0)
        //         sb.append(ch);
        //     }else{
        //         st.pop();
        //         if(sb.size()>0)
        //         sb.append(ch);
        //     }
        // }
        // return sb.toString();


          Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                // Push to stack only if it's not an outermost parenthesis
                if (!st.isEmpty()) {
                    sb.append(ch);
                }
                st.push(ch);
            } else if (ch == ')') {
                st.pop(); // Pop for the matching '('
                // Append to result only if it's not the outermost ')'
                if (!st.isEmpty()) {
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }
}