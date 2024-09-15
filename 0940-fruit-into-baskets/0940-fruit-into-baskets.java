class Solution {
    public int totalFruit(int[] fruits) {
         // HashMap to store fruit type and its count in the current window
        HashMap<Integer, Integer> fruitCount = new HashMap<>();
        int left = 0; // Left pointer for sliding window
        int maxFruits = 0; // To keep track of the maximum number of fruits collected
        
        // Iterate over the array with the right pointer
        for (int right = 0; right < fruits.length; right++) {
            // Add the current fruit to the map and update its count
            fruitCount.put(fruits[right], fruitCount.getOrDefault(fruits[right], 0) + 1);
            
            // If there are more than 2 distinct fruits, shrink the window from the left
            while (fruitCount.size() > 2) {
                fruitCount.put(fruits[left], fruitCount.get(fruits[left]) - 1);
                
                // Remove the fruit from the map if its count becomes zero
                if (fruitCount.get(fruits[left]) == 0) {
                    fruitCount.remove(fruits[left]);
                }
                left++; // Move the left pointer to shrink the window
            }
            
            // Calculate the maximum fruits collected in a valid window
            maxFruits = Math.max(maxFruits, right - left + 1);
        }
        
        return maxFruits;
    }
}