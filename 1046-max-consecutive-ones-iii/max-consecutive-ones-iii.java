class Solution {
    public int longestOnes(int[] nums, int k) {
        int lb=0;int ub=0;int max=0;
        while(ub<nums.length){
            if(nums[ub]==0){
                k--;
            }
            while(k<0){
                if(nums[lb]==0)k++;
                lb++;
            }
            max=Math.max(max,ub-lb+1);
            ub++;
        }
        return max;
    }
}