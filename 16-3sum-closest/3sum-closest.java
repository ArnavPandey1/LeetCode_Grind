class Solution {
    public int threeSumClosest(int[] nums, int target) {
       Arrays.sort(nums);int closestSum=Integer.MAX_VALUE;
       for(int i=0;i<nums.length-2;i++){
          int k=i+1;int j=nums.length-1;
          while(k<j){
            int sum=nums[i]+nums[k]+nums[j];
            if(Math.abs(target-sum)<Math.abs(target-closestSum)){
                closestSum=sum;
            }
            if(sum<target){
                k++;
            }
            else{
                j--;
            }
          }
       }  
       return closestSum; 
    }
}