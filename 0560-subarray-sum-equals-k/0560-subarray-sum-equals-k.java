class Solution {
    public int subarraySum(int[] nums, int k) {
       int res = 0;
       int curr =0;
       Map<Integer,Integer> map = new HashMap();//3
       map.put(0,1);//6
       for(int i : nums){//1
        curr += i;//2
        res += map.getOrDefault(curr - k,0);//4
        map.put(curr,map.getOrDefault(curr,0) +1);//5
       } 
       return res;
    }
}