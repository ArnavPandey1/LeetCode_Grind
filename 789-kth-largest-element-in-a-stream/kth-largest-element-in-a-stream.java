class KthLargest {
    PriorityQueue<Integer>pq=new PriorityQueue<>();
    int k1=0;
    public KthLargest(int k, int[] nums) {
        k1=k;
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        while(pq.size()>k1){
            pq.remove();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */