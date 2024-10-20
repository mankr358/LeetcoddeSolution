class Solution {
    public String reverseWords(String s) {
        // Step 1: Trim the input string to remove leading and trailing spaces
        // Step 2: Split the string by spaces into an array of words
        String[] words = s.trim().split(" ");
        
        // StringBuilder to construct the reversed string
        StringBuilder sb = new StringBuilder();
        
        // Step 3: Loop through the words array in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            // Check if the current word is not empty
            if (words[i].length() > 0) {
                // Append the word to the StringBuilder
                sb.append(words[i]);
                // Append a space after each word
                sb.append(' ');
            }
        }
        
        // Step 4: Convert the StringBuilder to a string and remove the trailing space
        // Return the resulting string
        return sb.substring(0, sb.length() - 1).toString();
    }
}
