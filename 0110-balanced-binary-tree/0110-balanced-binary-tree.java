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
        if (root == null)
            return true;
        return getHeight(root) != -1;
    }

    int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        int leftTree = getHeight(root.left);
        int rightTree = getHeight(root.right);
        if (leftTree == -1 || rightTree == -1)
            return -1;
        if (Math.abs(leftTree - rightTree) > 1)
            return -1;
        return (1 + Math.max(leftTree, rightTree));
    }
}