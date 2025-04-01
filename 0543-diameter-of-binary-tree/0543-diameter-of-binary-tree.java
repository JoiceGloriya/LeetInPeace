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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        findMax(root, diameter);
        return diameter[0];
    }

    int findMax(TreeNode root, int[] diameter) {
        if (root == null)
            return 0;
        int leftHeight = findMax(root.left, diameter);
        int rightHeight = findMax(root.right, diameter);
        diameter[0] = Math.max(diameter[0], rightHeight + leftHeight);
        return (1 + Math.max(rightHeight, leftHeight));
    }
}