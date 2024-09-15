class Solution {
    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> stable_moutain = new ArrayList<>();
        for(int i = 1; i<height.length;i++){
            if(height[i-1] > threshold){
                stable_moutain.add(i);
            }
        }
        return stable_moutain;
    }
}