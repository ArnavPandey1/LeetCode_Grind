class Solution {
    static List<List<Pair>> list;
    public int minCost(int n, int[][] edges) {
        list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int [] edge:edges){
            list.get(edge[0]).add(new Pair(edge[1],edge[2]));
            list.get(edge[1]).add(new Pair(edge[0],2*edge[2]));
        }
        return dijkstra(n);
    }
    public static int dijkstra(int n){
        int [] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair e=pq.poll();
            if(e.vtx==n-1){
                break;
            }
            for(Pair p:list.get(e.vtx)){
                int d=p.cost+dist[e.vtx];
                if(dist[p.vtx]>d){
                    dist[p.vtx]=d;
                    pq.add(new Pair(p.vtx,d));
                }
            }
        }
        return (dist[n-1]==Integer.MAX_VALUE)?-1:dist[n-1];
    }
    static class Pair{
        int vtx;
        int cost;
        Pair(int vtx,int cost){
            this.vtx=vtx;
            this.cost=cost;
        }
    }
}