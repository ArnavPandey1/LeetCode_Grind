class Solution {
    class triple{
        int cap;
        int have;
        int remain;
        triple(int cap,int have,int remain){
            this.cap=cap;
            this.have=have;
            this.remain=remain;
        }
    }
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        PriorityQueue<triple>pq=new PriorityQueue<>((a,b)->a.remain-b.remain);
        for(int i=0;i<capacity.length;i++){
            pq.add(new triple(capacity[i],rocks[i],capacity[i]-rocks[i]));
        }
        int c=0;
        while(!pq.isEmpty()){
            if(pq.peek().remain==0||pq.peek().remain<=additionalRocks){
                c++;
                additionalRocks-=pq.remove().remain;
            }
            else{
                break;
            }
        }
        return c;
    }
}