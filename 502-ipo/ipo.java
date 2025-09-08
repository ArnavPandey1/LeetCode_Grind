class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int arr[][]=new int[profits.length][2];
        for(int i=0;i<profits.length;i++){
            arr[i][0]=profits[i];
            arr[i][1]=capital[i];
        }
        Arrays.sort(arr,(a,b)->a[1]-b[1]);int i=0;
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b-a);
        while(k-->0){
             while(i<arr.length&& arr[i][1]<=w){
                pq.add(arr[i][0]);
                i++;
             }
             if(!pq.isEmpty())
             w=w+pq.remove();
        }
        return w;
    }
}