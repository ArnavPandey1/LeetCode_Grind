class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int l[]=new int[nums.length];
        int s[]=new int[nums.length];
        l[0]=nums[0];
        for(int i=1;i<l.length;i++){
            l[i]=Math.max(l[i-1],nums[i]);
        }
        s[s.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            s[i]=Math.min(nums[i],s[i+1]);
        }
        for(int i=0;i<nums.length;i++){
            if(l[i]-s[i]<=k)return i;
        }
        return -1;
    }
}