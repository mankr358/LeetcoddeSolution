class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        backtrack(candidates, target, 0, currentCombination, result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, 
                           List<Integer> currentCombination, List<List<Integer>> result) {
        // Base case: if the target is reached, add the current combination to the result
        if (target == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }
        // If target goes negative, no need to proceed
        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            currentCombination.add(candidates[i]); // Choose the number
            // Recursively call backtrack with reduced target
            backtrack(candidates, target - candidates[i], i, currentCombination, result);
            currentCombination.remove(currentCombination.size() - 1); // Backtrack
        }
    }
}