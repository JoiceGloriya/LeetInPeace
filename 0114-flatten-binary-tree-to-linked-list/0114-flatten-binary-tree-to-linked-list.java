/**
 * Definition for a binary tree root.
 * public class Treeroot {
 *     int val;
 *     Treeroot left;
 *     Treeroot right;
 *     Treeroot() {}
 *     Treeroot(int val) { this.val = val; }
 *     Treeroot(int val, Treeroot left, Treeroot right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // private TreeNode prev = null;
    // public void flatten(TreeNode root) {
    //     if(root == null) return;
    //     flatten(root.right);
    //     flatten(root.left);
    //     root.right = prev;
    //     root.left = null;
    //     prev = root;
    // }
    // public void flatten(TreeNode root) {
    //     if(root == null) return;
    //     Stack<TreeNode> stk = new Stack<>();
    //     stk.push(root);
    //     while(!stk.isEmpty()) {
    //         TreeNode curr = stk.pop();
    //         if(curr.right != null)
    //             stk.push(curr.right);
    //         if(curr.left != null) //pop left lastly, so that u' ll get it as first as stk is LIFO structure
    //             stk.push(curr.left);
    //         if(!stk.isEmpty())
    //             curr.right = stk.peek();
    //         curr.left = null;
    //     }
    // }
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode prev = curr.left;
                while (prev.right != null)
                    prev = prev.right;
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}