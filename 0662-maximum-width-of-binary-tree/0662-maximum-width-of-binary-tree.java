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
class Pair {
    TreeNode node;
    int index;
    public Pair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while(!queue.isEmpty()) {
            int size = queue.size();
            int minPerLevel = queue.peek().index;
            int leftExt = 0, rightExt = 0;
            for(int i = 0; i < size; i ++) {
                int modifiedIndex = queue.peek().index - minPerLevel;
                TreeNode node = queue.peek().node;
                queue.poll();
                if(i == 0) leftExt = modifiedIndex;
                if(i == size - 1) rightExt = modifiedIndex;
                if(node.left != null) 
                    queue.offer(new Pair(node.left, 2 * modifiedIndex + 1));
                if(node.right != null) 
                    queue.offer(new Pair(node.right, 2 * modifiedIndex + 2));
            }
            ans = Math.max(ans, rightExt - leftExt + 1);
        }
        return ans;
    }
}