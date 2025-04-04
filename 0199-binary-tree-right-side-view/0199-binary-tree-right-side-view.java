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
    class Pair {
        TreeNode node;
        int level;

        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Map<Integer, Integer> mpp = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int level = pair.level;
            mpp.put(level, node.val);
            if (node.left != null)
                queue.offer(new Pair(node.left, level + 1));
            if (node.right != null)
                queue.offer(new Pair(node.right, level + 1));
        }

        return new ArrayList<>(mpp.values());

    }
}