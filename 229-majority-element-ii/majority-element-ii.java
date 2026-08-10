class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer>l1=new ArrayList<>();
        int can1=Integer.MIN_VALUE;int c1=0;
        int can2=Integer.MIN_VALUE;int c2=0;
        for(int i=0;i<nums.length;i++){
            if(can1==nums[i]){
                c1++;
            }
            else if(can2==nums[i]){
                c2++;
            }
            else if(c1==0){
                can1=nums[i];
                c1=1;
            }
            else if(c2==0){
                can2=nums[i];
                c2=1;
            }
            else{
                c1--;
                c2--;
            }
        }
        c1=0;c2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==can1)c1++;
            if(nums[i]==can2)c2++;
        }
        if(c1>nums.length/3) l1.add(can1);
        if(c2>nums.length/3) l1.add(can2);
        return l1;
    }
}