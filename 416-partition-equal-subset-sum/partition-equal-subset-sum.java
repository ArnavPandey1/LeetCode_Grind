class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        Boolean [][]dp=new Boolean[nums.length][sum+1];
        return helper(0,sum,nums,0,dp);
    }
    public boolean helper(int idx,int sum,int []nums,int c,Boolean dp[][]){
        if(idx>=nums.length){
            return false;
        }
        if(dp[idx][c]!=null)
        return dp[idx][c];
        if(sum/2==c){
            return true;
        }
       return dp[idx][c]=helper(idx+1,sum,nums,c+nums[idx],dp)||
        helper(idx+1,sum,nums,c,dp);

    }
}