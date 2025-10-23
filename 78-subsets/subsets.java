class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>l1=new ArrayList<>();
        List<Integer>l2=new ArrayList<>();
        helper(l1,l2,nums,0);
        return l1;
    }
    public void helper(List<List<Integer>>l1,List<Integer>l2,int nums[],int idx){
        if(idx>nums.length){
            return ;
        }
        l1.add(new ArrayList<>(l2));
        for(int i=idx;i<nums.length;i++){
            l2.add(nums[i]);
            helper(l1,l2,nums,i+1);
            l2.remove(l2.size()-1);
        }
    }
}