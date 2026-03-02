class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b-a);
        for(int i:stones){
            pq.add(i);
        }
        while(pq.size()>1){
            int x=pq.poll();
            int y=pq.poll();
            if(x!=y){
                if(x<y){
                  pq.add(y-x);
                }
                else{
                  pq.add(x-y);
                }
            }
        }
        return pq.isEmpty()?0:pq.poll();
    }
}