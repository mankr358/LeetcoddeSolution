import java.util.Deque;
import java.util.HashMap;
import java.util.ArrayDeque;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>(); // More efficient stack implementation

        // Traverse through nums2 to populate the map with next greater elements
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        // Elements left in the stack have no greater element, map them to -1
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        // Build the result array based on the mapped next greater elements
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }
}
