class Solution {
    public int singleNonDuplicate(int[] nums) {
       int xor_value =0;
       for(int num :  nums){
       xor_value ^= num; 
       }
       return xor_value;
    }
}