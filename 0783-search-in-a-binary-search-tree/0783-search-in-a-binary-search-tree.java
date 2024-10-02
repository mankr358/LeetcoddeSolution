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
   public TreeNode searchBST(TreeNode root, int val) {
    while (root != null && root.val != val) {
        // If the target value is less than the current node's value, go to the left subtree
        if (val < root.val) {
            root = root.left;
        } 
        // If the target value is greater, go to the right subtree
        else {
            root = root.right;
        }
    }
    // If the value is found, return the node, otherwise return null
    return root;
}
}