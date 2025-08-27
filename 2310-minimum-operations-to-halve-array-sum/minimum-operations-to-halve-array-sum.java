class Solution {
    public int halveArray(int[] nums) {
        int n=nums.length;
        double sum=0;
        PriorityQueue<Double> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            sum+=nums[i];
            pq.add((double)nums[i]);
        }
        double temp=sum;
        int opr=0;
        while(temp>sum/2){
            double val=pq.poll()/2;
            temp-=val;
            pq.add(val);
            opr++;
        }
        return opr;
    }
}