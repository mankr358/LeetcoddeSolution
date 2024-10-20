class Solution {
    public String reverseWords(String s) {
        // Step 1: Trim the string and reduce multiple spaces to single spaces
        s = s.trim().replaceAll("\\s+", " ");
        
        // Convert the string to a character array for in-place modifications
        char[] strArray = s.toCharArray();
        
        // Step 2: Reverse the entire string
        reverse(strArray, 0, strArray.length - 1);
        
        // Step 3: Reverse each word in the reversed string
        reverseWordsInArray(strArray);
        
        // Convert the character array back to a string and return
        return new String(strArray);
    }
    
    // Function to reverse a part of the character array using two pointers
    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            // Swap the characters at start and end
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            
            // Move the pointers towards the center
            start++;
            end--;
        }
    }
    
    // Function to reverse each word in the character array
    private void reverseWordsInArray(char[] arr) {
        int n = arr.length;
        int start = 0, end = 0;
        
        while (start < n) {
            // Move end pointer to the end of the current word
            while (end < n && arr[end] != ' ') {
                end++;
            }
            
            // Reverse the current word
            reverse(arr, start, end - 1);
            
            // Move both pointers to the next word
            start = end + 1;
            end = start;
        }
    }
} 