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
//  class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         Stack<TreeNode> stk = new Stack<>();
// List<Integer> list = new ArrayList<>();
//         if(root == null) return list;
//         stk.push(root);
//         while(!stk.isEmpty()) {
//             root = stk.pop();
//             list.add(root.val);
//             if(root.right != null)
//                 stk.push(root.right);
//             if(root.left != null)
//                 stk.push(root.left);
//         }
//         return list;
//     }
// }
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                list.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    list.add(curr.val);
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return list;
    }
}