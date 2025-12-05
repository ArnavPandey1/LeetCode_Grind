class Solution {
    public int countPartitions(int[] nums) {
        int s=0;
        for(int i=0;i<nums.length;i++){
            s+=nums[i];
        }
        int c=0;int count=0;
        for(int i=0;i<nums.length;i++){
            c+=nums[i];
            if(Math.abs(c-(s-c))%2==0)
            count++;
        }
        return count==0?0:count-1;
    }
}