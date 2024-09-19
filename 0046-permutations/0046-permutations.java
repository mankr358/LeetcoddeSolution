class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];  // Boolean array to track used elements
        backtracking(result, new ArrayList<>(), nums, used); 
        return result;  
    }

    private void backtracking(List<List<Integer>> resultList, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            resultList.add(new ArrayList<>(tempList)); 
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i])  // If number is already used, skip
                continue;
            used[i] = true;
            tempList.add(nums[i]);  
            backtracking(resultList, tempList, nums, used);
            used[i] = false;  // Backtrack and mark the number as unused
            tempList.remove(tempList.size() - 1);
        }
    }
}
