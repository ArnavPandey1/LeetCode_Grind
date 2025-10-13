class Solution {
    public boolean predictTheWinner(int[] nums) {
        return findWinner(nums,0,nums.length-1)>=0;
    }
    public int findWinner(int []nums,int i,int j){
        if(i==j)
        return nums[i];
        int chance1=nums[i]-findWinner(nums,i+1,j);
        int chance2=nums[j]-findWinner(nums,i,j-1);
        return Math.max(chance1,chance2);
    }
}