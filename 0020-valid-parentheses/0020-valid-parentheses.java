class Solution {
    public boolean isValid(String s) {
        // Step 1: Create an empty stack to store closing brackets.
        Stack<Character> stack = new Stack<>();
        
        // Step 2: Iterate through each character in the string `s`.
        for (char ch : s.toCharArray()) {
            // Step 3: If the current character is an opening parenthesis '(', push the corresponding closing parenthesis ')' onto the stack.
            if (ch == '(') {
                stack.push(')');
            }
            // Step 4: If the current character is an opening brace '{', push the corresponding closing brace '}' onto the stack.
            else if (ch == '{') {
                stack.push('}');
            }
            // Step 5: If the current character is an opening bracket '[', push the corresponding closing bracket ']' onto the stack.
            else if (ch == '[') {
                stack.push(']');
            }
            // Step 6: If the current character is a closing bracket (e.g., ')', '}', ']'):
            // - Check if the stack is empty or the top of the stack does not match the current closing bracket.
            // - If either condition is true, return false because it's not a valid match.
            else if (stack.isEmpty() || stack.pop() != ch) {
                return false;
            }
        }
        
        // Step 7: After processing all characters, check if the stack is empty.
        // If the stack is empty, it means all opening brackets had matching closing brackets.
        // If the stack is not empty, return false because some opening brackets did not have corresponding closing brackets.
        return stack.isEmpty();
    }
}
