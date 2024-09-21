class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int maxone = 0;
        for(int i =0; i< nums.length;i++){
            if(nums[i] ==1){
                ans++;
                maxone = Math.max(maxone,ans);
            }else
            ans =0;
        }
        return maxone;
    }
}