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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result; // Return empty list if root is null
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);  // Push root node to the stack

        // Traverse the tree using a stack
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.addFirst(node.val);  // Add the current node's value to the front of the result list

            // Push left and right children to the stack
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return result;  // Return the list of node values in postorder
    }
}