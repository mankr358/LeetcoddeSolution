class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Boolean> set = new HashMap<>();
    
    // Add elements of num2 to the HashMap
    for (int n2 : nums2) {
        set.put(n2, true); // Using a HashMap to track presence
    }
    
    ArrayList<Integer> list = new ArrayList<>();
    
    // Check for common elements
    for (int n1 : nums1) {
        if (set.containsKey(n1)) {
            list.add(n1);
            set.remove(n1); // Remove to avoid duplicates in the result
        }
    }
    
    // Convert ArrayList to an array
    int[] res = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
        res[i] = list.get(i);
    }
    
    return res;
    }
}