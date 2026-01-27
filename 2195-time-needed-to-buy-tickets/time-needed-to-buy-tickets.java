class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
         Queue<Pair>q=new LinkedList<>();
         for(int i=0;i<tickets.length;i++){
            q.add(new Pair(i,tickets[i]));
         }
         int c=0;
         while(!q.isEmpty()){
            Pair p=q.poll();
            p.ticket--;
            c++;
            if(p.ticket==0 && p.idx==k){
                return c;
            }
            else if(p.ticket!=0){
               q.add(new Pair(p.idx,p.ticket));
            }
         }
         return c;
    }
    class Pair{
        int idx;
        int ticket;
        Pair(int idx,int ticket){
            this.idx=idx;
            this.ticket=ticket;
        }
    }
}