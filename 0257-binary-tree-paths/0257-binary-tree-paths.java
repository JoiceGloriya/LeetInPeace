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
    void getPaths(TreeNode root, String str, List<String> list) {
        if(root.left == null && root.right == null) {
            str = str+root.val;
            list.add(str);
            return ;
        }
        if(root.left  != null ) getPaths(root.left, str + root.val + "->", list);
        if(root.right  != null ) getPaths(root.right, str + root.val + "->", list);


    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        getPaths(root, "", list);
        return list;
    }
}