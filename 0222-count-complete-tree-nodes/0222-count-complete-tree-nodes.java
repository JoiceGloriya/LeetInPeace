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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int left = getLeftHeight(root);
        int right = getRightHeight(root);
        if(left != right) return 1 + countNodes(root.left) + countNodes(root.right);
        else return (int)(Math.pow(2, left) - 1);
    }
    int getLeftHeight(TreeNode root) {
        int ct = 0 ;
        while(root != null) {
            ct++;
            root = root.left;
        }
        return ct;
    }
    int getRightHeight(TreeNode root) {
        int ct = 0 ;
        while(root != null) {
            ct++;
            root = root.right;
        }
        return ct;
    }
}