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
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;  // If the tree is empty, return an empty list
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);  // Start with the root node in the stack

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();  // Pop the top node from the stack
            result.add(node.val);  // Visit the node (add its value to the result)

            // Push right child first so that left child is processed next
            if (node.right != null) {
                stack.push(node.right);
            }

            // Push left child onto the stack
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;  // Return the preorder traversal result
    }
}