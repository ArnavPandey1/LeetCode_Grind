class Solution {
    public int numSubarraysWithSum(int[] arr, int k) {
        int ps[] = new int[arr.length];
        ps[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            ps[i] = ps[i - 1] + arr[i];
        }
        Map<Integer, Integer> map = new HashMap<>();
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            if (ps[i] == k)
                c++;
            int v = ps[i] - k;
            if (map.containsKey(v)) {
                c = c + map.get(v);
            }
            if (map.containsKey(ps[i])) {
                map.put(ps[i], map.get(ps[i]) + 1);
            } else {
                map.put(ps[i], 1);
            }
        }
        return c;
    }
}
