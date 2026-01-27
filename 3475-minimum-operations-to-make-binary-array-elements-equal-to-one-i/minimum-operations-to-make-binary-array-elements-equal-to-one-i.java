class Solution {
    public int minOperations(int[] nums) {
        int c=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0 && i+1<nums.length && i+2<nums.length){
                c++;
                nums[i]=nums[i]==0?1:0;
                nums[i+1]=nums[i+1]==0?1:0;
                nums[i+2]=nums[i+2]==0?1:0;
            }
            else if(nums[i]==0)
            return -1;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
            return -1;
        }
        return c;
    }
}