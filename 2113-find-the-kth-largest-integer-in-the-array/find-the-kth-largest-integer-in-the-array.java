class Solution {
    public String kthLargestNumber(String[] nums, int k) {
       PriorityQueue<String>pq=new PriorityQueue<>((a,b)->{
          if(a.length()>b.length())
          return -1;
          if(b.length()>a.length()){
            return 1;
          }
          return b.compareTo(a);
       });
       for(int i=0;i<nums.length;i++){
        pq.add(nums[i]);
       }
       String s="";
       while(k-->0){
        s=pq.remove();
       }
       return s;
    }
}