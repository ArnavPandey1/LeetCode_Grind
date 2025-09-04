class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        int ans[]=new int[queries.length];
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b-a);
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<queries.length;i++){
            int val=Math.abs(queries[i][0])+Math.abs(queries[i][1]);
            pq.add(val);
            while(pq.size()>k){
                pq.remove();
            }
            if(pq.size()<k){
                ans[i]=-1;
            }
            else{
                ans[i]=pq.peek();
            }
        }
        return ans;
    }
}