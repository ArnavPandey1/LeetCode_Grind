class Solution {
    class Pair{
        int idx;
        int dist;
        Pair(int idx,int dist){
            this.idx=idx;
            this.dist=dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.dist-b.dist);
        for(int i=0;i<points.length;i++){
            int x=points[i][0];
            int y=points[i][1];
            pq.add(new Pair(i,x*x+y*y));
        }
        int ans[][]=new int[k][2];int c=0;
        while(k>0){
            ans[c++]=points[pq.remove().idx];
            k--;
        }
        return ans;
    }
}