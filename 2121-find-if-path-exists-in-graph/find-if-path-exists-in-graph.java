class Solution {
    List<List<Integer>>l1;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        l1=new ArrayList<>();
        for(int i=0;i<n;i++){
            l1.add(new ArrayList<>());
        }
        for(int i[]:edges){
            l1.get(i[0]).add(i[1]);
            l1.get(i[1]).add(i[0]);
        }
        int visited[]=new int[n];
        Queue<Integer>pq=new LinkedList<>();
        pq.add(source);boolean flag=false;
        while(!pq.isEmpty()){
             int a=pq.remove();
             if(a==destination){
                 flag=true;
                 break;
            }
            if(visited[a]==1)
               continue;
            visited[a]=1;
            for(int i:l1.get(a)){
                if(visited[i]==0)
                pq.add(i);
            }
        }
        return flag;
    }
}