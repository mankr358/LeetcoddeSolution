class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result, new ArrayList<>(), nums);  // Fix: Correct method call with result and tempList
        return result;  
    }

    private void backtracking(List<List<Integer>> resultList, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            resultList.add(new ArrayList<>(tempList)); 
            return;
        }
        for (int number : nums) {
            if (tempList.contains(number))  
                continue;
            tempList.add(number);  
            backtracking(resultList, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }
}
