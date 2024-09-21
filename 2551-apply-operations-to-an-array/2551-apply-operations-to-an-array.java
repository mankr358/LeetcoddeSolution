class Solution {
    public int[] applyOperations(int[] nums) {

for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int pos =0;
        for(int num : nums){
            if(num != 0){
                nums[pos] = num;
            pos++;
            }
        }
        while(pos< nums.length){
            nums[pos] = 0;
            pos++;
        }
        return nums;
    }
}