class Solution {
    public int maxProfit(int[] nums) {
        int arr[]=new int[nums.length];
        arr[arr.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            arr[i]=Math.max(nums[i],arr[i+1]);
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]-nums[i]);
        }
        return max;
    }
}