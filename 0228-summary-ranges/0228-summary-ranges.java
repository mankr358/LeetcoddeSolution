class Solution {
    public List<String> summaryRanges(int[] nums) {
    
        int n = nums.length;
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int start = nums[i];
            
            // Keep increasing i while the current element is consecutive with the next one
            while (i + 1 < n && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            
            // Check if the range has more than one number
            if (start != nums[i]) {
                result.add(start + "->" + nums[i]);
            } else {
                result.add(String.valueOf(start));
            }
        }
        
        return result;
    }
}