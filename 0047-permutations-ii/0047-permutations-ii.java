class Solution {
   public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> resultList = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(resultList, new ArrayList<>(), nums, new boolean[nums.length]);
    return resultList;
}

private void backtrack(List<List<Integer>> resultList, ArrayList<Integer> tempList, int[] nums, boolean[] used) {
    if (tempList.size() == nums.length) {
        resultList.add(new ArrayList<>(tempList));
        return;
    }

    for (int i = 0; i < nums.length; i++) {
        if (used[i]) continue;

        // Skip duplicates
        if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

        used[i] = true;
        tempList.add(nums[i]);
        backtrack(resultList, tempList, nums, used);
        used[i] = false;
        tempList.remove(tempList.size() - 1);
    }
}

}