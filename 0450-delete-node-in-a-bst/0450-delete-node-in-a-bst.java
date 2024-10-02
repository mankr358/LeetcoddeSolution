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
    public TreeNode deleteNode(TreeNode root, int key) {
         // Step 1: Search for the node to delete
        if (root == null) return null;

        // If the key to be deleted is smaller than the root's key, go to the left subtree
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        // If the key to be deleted is greater than the root's key, go to the right subtree
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        // If key is same as root's key, this is the node to be deleted
        else {
            // Step 2: Handle deletion based on the node's children
            // Case 1: No children (leaf node)
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: One child
            else if (root.left == null) {
                return root.right;  // Return the right child if left is null
            } else if (root.right == null) {
                return root.left;  // Return the left child if right is null
            }
            // Case 3: Two children
            else {
                // Find the inorder successor (smallest node in the right subtree)
                TreeNode minNode = findMin(root.right);
                // Replace the node's value with the successor's value
                root.val = minNode.val;
                // Delete the inorder successor
                root.right = deleteNode(root.right, minNode.val);
            }
        }
        return root;
    }
     // Helper function to find the smallest node in a subtree
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}