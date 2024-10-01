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
    public boolean isBalanced(TreeNode root) {
        // If getHeight returns -1, the tree is not balanced
        return getHeight(root) != -1;
    }

    // This method returns the height of the tree if balanced, and -1 if it's not balanced
    public int getHeight(TreeNode root) {
        // Base case: If the node is null, its height is 0
        if (root == null) {
            return 0;
        }

        // Recursively get the height of the left and right subtrees
        int leftSubTree = getHeight(root.left);
        int rightSubTree = getHeight(root.right);

        // If any subtree is unbalanced, propagate the failure (-1) upwards
        if (leftSubTree == -1 || rightSubTree == -1) {
            return -1;
        }

        // Check if the current node is unbalanced
        if (Math.abs(leftSubTree - rightSubTree) > 1) {
            return -1;
        }

        // If balanced, return the height of this node, which is 1 + max(leftHeight, rightHeight)
        return 1 + Math.max(leftSubTree, rightSubTree);
    }
}
