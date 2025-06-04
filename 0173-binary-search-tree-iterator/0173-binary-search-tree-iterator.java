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
class BSTIterator {

    Stack<TreeNode> stk = new Stack<>();

    public BSTIterator(TreeNode root) {
        TreeNode cur = root;

        while (cur != null) {
            stk.push(cur);
            cur = cur.left;
        }

    }

    public int next() {
        TreeNode node = stk.pop();
        TreeNode temp = node.right;
        while (temp != null) {
            stk.push(temp);
            temp = temp.left;
        }

        return node.val;
    }

    public boolean hasNext() {
        return !stk.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */