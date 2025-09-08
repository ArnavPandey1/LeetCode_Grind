class Solution {
    class Pair {
        int end;
        int idx;

        Pair(int end, int idx) {
            this.end = end;
            this.idx = idx;
        }
    }

    public int mostBooked(int n, int[][] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++)
            map.put(i, 0);

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.end == b.end) {
                return a.idx - b.idx;
            } else {
                return a.end - b.end;
            }
        });

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            q.add(i);
        }

        for (int i = 0; i < arr.length; i++) {
            int start = arr[i][0], end = arr[i][1];
            int duration = end - start;

            // ✅ FIX: free all rooms that have ended before current meeting
            while (!pq.isEmpty() && pq.peek().end <= start) {
                q.add(pq.poll().idx);
            }

            if (!q.isEmpty()) {
                int room = q.poll();
                pq.add(new Pair(end, room));
                map.put(room, map.get(room) + 1);
            } else {
                Pair p = pq.poll(); // earliest finishing room
                int newEnd = p.end + duration;
                pq.add(new Pair(newEnd, p.idx));
                map.put(p.idx, map.get(p.idx) + 1);
            }
            
        }

        // ✅ simplified: find room with max usage
        int ans = 0, maxUse = 0;
        for (int i : map.keySet()) {
            if (map.get(i) > maxUse) {
                maxUse = map.get(i);
                ans = i;
            }
        }
        return ans;
    }
}
