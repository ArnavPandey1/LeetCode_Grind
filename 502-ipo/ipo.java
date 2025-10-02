class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int arr[][] = new int[profits.length][2];
        for (int i = 0; i < profits.length; i++) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b-a);
        int i = 0;
        while (k-- > 0) {
            while (i < arr.length && w >= arr[i][0]) {
                pq.add(arr[i][1]);
                i++;
            }
            if (pq.isEmpty())
                return w;
            w = w + pq.remove();
        }
        return w;
    }
}