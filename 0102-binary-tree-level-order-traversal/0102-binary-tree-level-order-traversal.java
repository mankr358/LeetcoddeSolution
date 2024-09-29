/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;l
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
    public List<List<Integer>> levelOrder(TreeNode root) {
         List<List<Integer>> result = new ArrayList<>();
        
        // Edge case: if the root is null, return an empty list
        if (root == null) {
            return result;
        }
        
         // Queue for BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); // Add the root to start the BFS
        
        // Traverse the tree level by level
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at the current level
            List<Integer> currentLevel = new ArrayList<>(); // List to store nodes at the current level
            
            // Iterate over all nodes at this level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll(); // Get the node from the front of the queue
                currentLevel.add(node.val);   // Add the node's value to the current level list
                
                // Add the left child to the queue if it exists
                if (node.left != null) {
                    queue.add(node.left);
                }
                
                // Add the right child to the queue if it exists
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            
            // Add the current level list to the result
            result.add(currentLevel);
        }
        
        return result;
    }
}