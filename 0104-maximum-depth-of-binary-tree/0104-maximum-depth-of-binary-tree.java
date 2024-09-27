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
    public int maxDepth(TreeNode root) {
        if (root == null) { // Edge case: if the tree is empty
            return 0;
        }
        
        Queue<TreeNode> elementQueue = new LinkedList<>(); // Use TreeNode instead of Integer
        elementQueue.add(root); // Add the root node to the queue
        int numberOfLevels = 0; // Start counting from level 0
        
        // Perform BFS level by level
        while (!elementQueue.isEmpty()) {
            int nodeCountAtLevel = elementQueue.size(); // Number of nodes at current level
            
            // Process each node at the current level
            for (int i = 0; i < nodeCountAtLevel; i++) {
                TreeNode element = elementQueue.poll(); // Dequeue a node
                
                // Enqueue left child if it exists
                if (element.left != null) {
                    elementQueue.add(element.left);
                }
                
                // Enqueue right child if it exists
                if (element.right != null) {
                    elementQueue.add(element.right);
                }
            }
            
            // Increment the level count after processing all nodes at the current level
            numberOfLevels++;
        }
        
        return numberOfLevels; // Return the total number of levels (depth)
    }
}
