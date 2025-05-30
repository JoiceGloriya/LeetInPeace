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
    Stack<TreeNode> leftStack = new Stack<>();
    Stack<TreeNode> rightStack = new Stack<>();
    int next = 0, prev = 0;

    void buildLeft(TreeNode root) {
        TreeNode cur = root;
        while(cur != null) {
            leftStack.push(cur);
            cur = cur.left;
        }
    }
    void buildRight(TreeNode root) {
        TreeNode cur = root;
        while(cur != null) {
            rightStack.push(cur);
            cur = cur.right;
        }
    }
    int next() {
        TreeNode node = leftStack.pop();
        int value = node.val;
        if(node.right != null) {
            TreeNode temp = node.right;
            while(temp != null) {
                leftStack.push(temp);
                temp = temp.left;
            }
        }
        return value;
    }
    int prev() {
        TreeNode node = rightStack.pop();
        int value = node.val;
        if(node.left != null) {
            TreeNode temp = node.left;
            while(temp != null) {
                rightStack.push(temp);
                temp = temp.right;
            }
        }
        return value;
    }
    public boolean findTarget(TreeNode root, int k) {
        buildLeft(root);
        buildRight(root);
        int left = next();
        int right = prev();
        while(left < right) {
        if(left + right == k) return true;
        else if(left + right < k)
            left = next();
        else right = prev();            
        }
        return false;
    }
}