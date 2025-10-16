class Solution {
    class BipartitePair{
        int vtx;
        int dis;
        public BipartitePair(int vtx,int dis){
            this.vtx=vtx;
            this.dis=dis;
        }
    }
    public boolean isBipartite(int[][] graph) {
        Queue<BipartitePair>q=new LinkedList<>();
        HashMap<Integer,Integer>visited=new HashMap<>();
        for(int i=0;i<graph.length;i++){
            if(visited.containsKey(i)){
                continue;
            }
            q.add(new BipartitePair(i,0));
            while(!q.isEmpty()){
                BipartitePair rp=q.poll();
                if(visited.containsKey(rp.vtx)){
                    if(visited.get(rp.vtx)!=rp.dis){
                        return false;
                    }
                    continue;
                }
                visited.put(rp.vtx,rp.dis);
                for(int nbrs:graph[rp.vtx]){
                    if(!visited.containsKey(nbrs)){
                        q.add(new BipartitePair(nbrs,rp.dis+1));
                    }
                }
            }
        }
        return true;
    }
}