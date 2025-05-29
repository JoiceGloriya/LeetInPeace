/*
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
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] index = new int[1]; // for tracking indices across the recursive calls 
        return bstFromPreorder(preorder, Integer.MAX_VALUE, index);
    }

    public TreeNode bstFromPreorder(int[] preorder, int ub, int[] index) {
        if(index[0] == preorder.length || preorder[index[0]] > ub)
            return null;

        TreeNode root = new TreeNode(preorder[index[0]]);
        index[0]++;
        root.left = bstFromPreorder(preorder, root.val, index);
        root.right = bstFromPreorder(preorder, ub, index);

        return root;
    }
}