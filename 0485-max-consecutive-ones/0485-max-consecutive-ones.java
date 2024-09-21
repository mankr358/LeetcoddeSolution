class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int maxone = 0;
        for(int num : nums){
            if(num ==1){
                ans++;
                maxone = Math.max(maxone,ans);
            }else
            ans =0;
        }
        return maxone;
    }
}