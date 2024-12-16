class Solution {
    public int missingNumber(int[] nums) {
        // int sum = 0;
        // for(int i =0;i<nums.length;i++){
        //     sum ^= i;
        //     sum ^= nums[i];
        // }
        // return sum^nums.length;

        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum = sum + nums[i];
        }
        int n = nums.length;
        int actualSum= n*(n+1)/2;
        int missingno = actualSum - sum;
        return missingno;
    }
}