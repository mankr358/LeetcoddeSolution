class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array

        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicates
            }
            twoSum(nums, i + 1, result, -nums[i]);
        }
        return result;
    }

    private void twoSum(int[] nums, int k, List<List<Integer>> result, int target) {
        int i = k;
        int j = nums.length - 1;

        while (i < j) {
            int sum = nums[i] + nums[j]; // Recalculate sum in each iteration

            if (sum < target) {
                i++; // Move left pointer to the right
            } else if (sum > target) {
                j--; // Move right pointer to the left
            } else {
                result.add(Arrays.asList(-target, nums[i], nums[j]));
                // Skip duplicates for both pointers
                while (i < j && nums[i] == nums[i + 1]) {
                    i++;
                }
                while (i < j && nums[j] == nums[j - 1]) {
                    j--;
                }
                i++;
                j--;
            }
        }
    }
}
