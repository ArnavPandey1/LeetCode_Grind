class Solution {
    public int minPairSum(int[] nums) {
       Arrays.sort(nums);
       int s=0;
       for(int i=0;i<nums.length-1;i++){
           s=Math.max(s,nums[i]+nums[nums.length-i-1]);
       }
       return s;
    }
}