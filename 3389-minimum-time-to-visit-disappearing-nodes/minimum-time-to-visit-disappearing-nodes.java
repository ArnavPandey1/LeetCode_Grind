class Solution {

    static class Pair {
        int node;
        int time;

        Pair(int n, int t) {
            node = n;
            time = t;
        }
    }

    public int[] minimumTime(int n, int[][] edges, int[] disappear) {

        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.time - b.time);

        if (0 >= disappear[0]) return new int[n];
        dist[0] = 0;
        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int u = cur.node;
            int time = cur.time;

            if (time > dist[u]) continue;

            for (Pair nei : graph.get(u)) {
                int v = nei.node;
                int newTime = time + nei.time;

                if (newTime < disappear[v] && newTime < dist[v]) {
                    dist[v] = newTime;
                    pq.offer(new Pair(v, newTime));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}
