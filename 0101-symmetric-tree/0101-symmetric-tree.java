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
    public boolean isSymmetric(TreeNode root) {
        // Edge case: if the tree is empty, it's symmetric
        if (root == null) {
            return true;
        }
        
        // Call helper function to check symmetry between left and right subtree
        return isMirror(root.left, root.right);
    }
    
    // Helper function to check if two trees are mirrors of each other
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        // If both nodes are null, it's symmetric
        if (t1 == null && t2 == null) {
            return true;
        }
        // If only one is null, it's not symmetric
        if (t1 == null || t2 == null) {
            return false;
        }
        // Check if the current nodes have the same value, and then check if
        // t1's left subtree is the mirror of t2's right subtree and
        // t1's right subtree is the mirror of t2's left subtree
        return (t1.val == t2.val) 
                && isMirror(t1.left, t2.right) 
                && isMirror(t1.right, t2.left);
    }
}
