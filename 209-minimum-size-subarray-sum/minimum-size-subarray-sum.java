class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0;int j=0;int min=Integer.MAX_VALUE;
        int s=0;
        while(j<nums.length){
            s=s+nums[j];
            while(s>=target){
                min=Math.min(min,j-i+1);
                s=s-nums[i];
                i++;
            }
            j++;
        }
        if(min==Integer.MAX_VALUE)
        return 0;
        return min;
    }
}