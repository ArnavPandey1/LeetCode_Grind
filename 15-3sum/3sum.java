class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>l1=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j=i+1;j<nums.length;j++){
                if (j > i+1 && nums[j] == nums[j - 1]) continue;
                int lb=j+1;int ub=nums.length-1;
                while(lb<=ub){
                    int mid=lb+(ub-lb)/2;
                    if(nums[i]+nums[j]+nums[mid]==0){
                        List<Integer>l2=new ArrayList<>();
                        l2.add(nums[i]);
                        l2.add(nums[j]);
                        l2.add(nums[mid]);
                        l1.add(l2);
                        break;
                    }
                    else if(nums[i]+nums[j]+nums[mid]>0){
                        ub=mid-1;
                    }
                    else{
                       lb=mid+1;
                    }
                }
            }
        }
        return l1;
    }
}