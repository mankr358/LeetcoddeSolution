/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> linkedList = new LinkedList<>();
        if (root == null) return linkedList;  // Base case

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> levelSubList = new LinkedList<>(); // Using LinkedList to use addFirst()

            while (size > 0) {
                TreeNode node = queue.poll();
                
                // Odd level: Insert at the beginning (for zigzag effect)
                if (level % 2 != 0) {
                    levelSubList.addFirst(node.val);
                } else {
                    // Even level: Insert normally
                    levelSubList.add(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

                size--;
            }
            level++;
            linkedList.add(levelSubList); // Add the current level list
        }
        return linkedList;
    }
}
