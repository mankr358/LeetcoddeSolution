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
    public TreeNode insertIntoBST(TreeNode root, int val) {
         // Base case: if the root is null, return a new node with the value
        if (root == null) {
            return new TreeNode(val);
        }
        
        // If the value is smaller, insert in the left subtree
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } 
        // If the value is larger, insert in the right subtree
        else if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }
        
        // Return the root of the tree after insertion
        return root;
    }
}