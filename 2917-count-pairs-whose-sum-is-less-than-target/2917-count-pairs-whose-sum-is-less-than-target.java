class Solution {
    public int countPairs(List<Integer> nums, int target) {
        nums.sort((a,b) -> (a-b));
        int count =0;
        int i = 0;
        int j = nums.size() -1;
        while(i<j){
if(nums.get(i) + nums.get(j) < target){
    count += (j-i);
    i++;
}else{
    j--;
}
        }
        return count;
    }
}