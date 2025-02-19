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
    public boolean isSameTree(TreeNode p, TreeNode q) {
          
        // If both nodes are null, trees are the same at this point
        if (p == null && q == null) {
            return true;
        }
        // If one node is null and the other is not, trees are not the same
        if (p == null || q == null) {
            return false;
        }
        
        // Check if the current nodes have the same value and
        // recursively check left and right subtrees
        return (p.val == q.val) 
                && isSameTree(p.left, q.left) 
                && isSameTree(p.right, q.right);
    }
}
