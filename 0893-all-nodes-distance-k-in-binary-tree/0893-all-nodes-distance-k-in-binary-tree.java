/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    void mapParents(TreeNode root, Map<TreeNode, TreeNode> parentTrack) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i ++) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.offer(node.left);
                    parentTrack.put(node.left, node);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                    parentTrack.put(node.right, node);
                }
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentTrack = new HashMap<>();
        mapParents(root, parentTrack);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int currDistance = 0;
        queue.offer(target);
        visited.put(target, true);
        while(!queue.isEmpty()) {
            int size = queue.size();
            if(currDistance == k) break;
            currDistance++;
            for(int i = 0; i < size; i ++) {
                TreeNode node = queue.poll();
                if(node.left != null && !visited.containsKey(node.left)) {
                    queue.offer(node.left);
                    visited.put(node.left, true);
                }
                if(node.right != null && !visited.containsKey(node.right)) {
                    queue.offer(node.right);
                    visited.put(node.right, true);
                }
                TreeNode parentNode = parentTrack.get(node);
                if(parentNode != null && !visited.containsKey(parentNode)) {
                    queue.offer(parentNode);
                    visited.put(parentNode, true);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty())
            list.add(queue.poll().val);
        return list;
    }
}