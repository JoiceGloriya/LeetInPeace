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
        Stack<TreeNode> stk1 = new Stack<>();
        // Stack<TreeNode> stk2 = new Stack<>();
        List<Integer> temp = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        stk1.push(root);
        while(!stk1.isEmpty()) {
            TreeNode curr = stk1.pop();
            temp.add(curr.val);
            if(curr != null && curr.left != null) stk1.push(curr.left);
            if(curr != null && curr.right != null) stk1.push(curr.right);
        }
        while(!temp.isEmpty())
            list.add(temp.remove(temp.size() - 1));
        return list;
    }
}