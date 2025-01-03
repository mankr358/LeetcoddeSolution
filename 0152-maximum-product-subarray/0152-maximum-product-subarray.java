class Solution {
    public int maxProduct(int[] nums) {
          if (nums.length == 0) return 0;

        int maxProduct = nums[0];
        int minProduct = nums[0];
        int globalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];

            // If current is negative, swap maxProduct and minProduct
            if (current < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            // Update maxProduct and minProduct
            maxProduct = Math.max(current, maxProduct * current);
            minProduct = Math.min(current, minProduct * current);

            // Update the global max
            globalMax = Math.max(globalMax, maxProduct);
        }

        return globalMax;
    }
}