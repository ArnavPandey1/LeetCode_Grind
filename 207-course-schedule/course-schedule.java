class Solution {
    List<List<Integer>>l1;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int inDgree[]=new int [numCourses];
        l1=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            l1.add(new ArrayList<>());
        }
        for(int i[]:prerequisites){
            inDgree[i[0]]++;
            l1.get(i[1]).add(i[0]);
        }
        Queue<Integer>pq=new LinkedList<>();
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<inDgree.length;i++){
            if(inDgree[i]==0){
                ans.add(i);
                pq.add(i);
            }
        }
        while(!pq.isEmpty()){
            int a=pq.remove();
            for(int i:l1.get(a)){
                inDgree[i]--;
                if(inDgree[i]==0){
                    ans.add(i);
                    pq.add(i);
                }
            }            
        }
        return ans.size()==numCourses?true:false;
    }
}