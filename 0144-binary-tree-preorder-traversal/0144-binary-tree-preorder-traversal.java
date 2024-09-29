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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();  // To store the preorder traversal result
        preorder(root, result);  // Helper function to perform the traversal
        return result;  // Return the result
    }

    // Helper method to perform preorder traversal recursively
    private void preorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;  // Base case: if the node is null, do nothing
        }
        result.add(node.val);  // Add the current node's value to the result
        preorder(node.left, result);  // Recur on the left child
        preorder(node.right, result);  // Recur on the right child
    }
}