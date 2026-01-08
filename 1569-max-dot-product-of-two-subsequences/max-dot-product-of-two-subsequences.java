class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int dp[][]=new int[nums1.length][nums2.length];
        for(int i[]:dp){
            Arrays.fill(i,(int)-1e9);
        }
        return helper(nums1,nums2,0,0,dp);
    }
    public int helper(int [] nums1,int []nums2,int i,int j,int [][]dp){
        if(i==nums1.length||j==nums2.length)
        return (int)-1e9;
        if(dp[i][j]!=(int)-1e9){
            return dp[i][j];
        }
        int p1=nums1[i]*nums2[j];
        int p2=helper(nums1,nums2,i,j+1,dp);
        int p3=helper(nums1,nums2,i+1,j,dp);
        int p4=nums1[i]*nums2[j]+helper(nums1,nums2,i+1,j+1,dp);
        return dp[i][j]=Math.max(Math.max(p1,p2),Math.max(p3,p4));
    }
}
