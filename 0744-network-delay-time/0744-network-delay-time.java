class Solution {

    class Pair {
        int node, time;

        public Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] visited = new int[n];
        List<List<Pair>> adj = new ArrayList<>();
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> a.time - b.time);
        queue.offer(new Pair(k - 1, 0));
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[k - 1] = 0;

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int u = time[0] - 1;//convert 1-based indexing to 0-based indexxing
            int v = time[1] - 1;
            int w = time[2];
            adj.get(u).add(new Pair(v, w));
        }

        while (!queue.isEmpty()) {
            int node = queue.peek().node;
            int time = queue.peek().time;
            queue.poll();

            for (Pair pair : adj.get(node)) {
                int v = pair.node;
                int w = pair.time;

                if (visited[v] > w + time) {
                    visited[v] = w + time;
                    queue.offer(new Pair(v, visited[v]));
                }
            }
        }
        int result = 0;
        for (int time : visited) {
            if (time == Integer.MAX_VALUE)
                return -1;
            result = Math.max(result, time);
        }
        return result;

    }
}