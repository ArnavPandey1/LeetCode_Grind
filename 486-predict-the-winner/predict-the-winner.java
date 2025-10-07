class Solution {
    public boolean predictTheWinner(int[] nums) {
        return traverse(nums,0,nums.length-1)>=0;
    }
    public int traverse(int nums[],int i,int j){
        if(i==j)
        return nums[i];
        int max=Integer.MIN_VALUE;
        int first_pick=nums[i]-traverse(nums,i+1,j);
        int second_pick=nums[j]-traverse(nums,i,j-1);
        max=Math.max(first_pick,second_pick);
        return max;
    }
}