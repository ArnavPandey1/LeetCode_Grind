import java.util.*;

class Solution {

    static class Event {
        long y;
        int type; // +1 = add, -1 = remove
        long x1, x2;

        Event(long y, int type, long x1, long x2) {
            this.y = y;
            this.type = type;
            this.x1 = x1;
            this.x2 = x2;
        }
    }

    public double separateSquares(int[][] squares) {

        List<Event> events = new ArrayList<>();

        for (int[] s : squares) {
            long x = s[0], y = s[1], l = s[2];
            events.add(new Event(y, +1, x, x + l));
            events.add(new Event(y + l, -1, x, x + l));
        }

        events.sort(Comparator.comparingLong(e -> e.y));

        TreeMap<Long, Integer> active = new TreeMap<>();
        List<long[]> slabs = new ArrayList<>();

        long prevY = events.get(0).y;
        int i = 0;

        while (i < events.size()) {
            long curY = events.get(i).y;

            long height = curY - prevY;
            if (height > 0 && !active.isEmpty()) {
                long width = unionWidth(active);
                slabs.add(new long[]{prevY, curY, width});
            }

            while (i < events.size() && events.get(i).y == curY) {
                Event e = events.get(i);
                active.put(e.x1, active.getOrDefault(e.x1, 0) + e.type);
                active.put(e.x2, active.getOrDefault(e.x2, 0) - e.type);

                if (active.get(e.x1) == 0) active.remove(e.x1);
                if (active.get(e.x2) == 0) active.remove(e.x2);
                i++;
            }

            prevY = curY;
        }

        double totalArea = 0;
        for (long[] s : slabs) {
            totalArea += (double)(s[1] - s[0]) * s[2];
        }

        double target = totalArea / 2.0;
        double acc = 0;

        for (long[] s : slabs) {
            double slabArea = (double)(s[1] - s[0]) * s[2];
            if (acc + slabArea >= target) {
                double need = target - acc;
                return s[0] + need / s[2];
            }
            acc += slabArea;
        }

        return slabs.get(slabs.size() - 1)[1];
    }

    private long unionWidth(TreeMap<Long, Integer> map) {
        long res = 0;
        int count = 0;
        long prev = 0;

        for (Map.Entry<Long, Integer> e : map.entrySet()) {
            if (count > 0) res += e.getKey() - prev;
            count += e.getValue();
            prev = e.getKey();
        }
        return res;
    }
}
