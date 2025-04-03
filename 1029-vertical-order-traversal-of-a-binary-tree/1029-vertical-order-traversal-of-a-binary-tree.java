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

    class Triplet {
        TreeNode node = new TreeNode();
        int vertical, level;

        public Triplet(TreeNode node, int vertical, int level) {
            this.node = node;
            this.vertical = vertical;
            this.level = level;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Triplet> queue = new LinkedList<>();
        queue.offer(new Triplet(root, 0, 0));
        while(!queue.isEmpty()) {
            Triplet triplet = queue.poll();
            TreeNode node = triplet.node;
            int x = triplet.vertical;
            int y = triplet.level;
            // if(!map.containsKey(x)) 
            //     map.put(x, new TreeMap<>()); 
            map.putIfAbsent(x, new TreeMap<>());
            // if(!map.get(x).containsKey(y))
            //     map.get(x).put(y, new PriorityQueue<>());
            map.get(x).putIfAbsent(y, new PriorityQueue<>());
            map.get(x).get(y).offer(node.val);

            if(node.left != null)
                queue.offer(new Triplet(node.left, x - 1, y + 1));
            if(node.right != null)
                queue.offer(new Triplet(node.right, x + 1, y + 1));
        }

        for(TreeMap<Integer, PriorityQueue<Integer>> mpp: map.values()) {
            List<Integer> arr = new ArrayList<>();
            for(PriorityQueue<Integer> pq: mpp.values()) {
                 while (!pq.isEmpty()) {
                    arr.add(pq.poll());
                }
            }
    list.add(arr);
        }
        return list;
    }
}