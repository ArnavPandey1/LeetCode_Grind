class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>>l1=new ArrayList<>();
        List<Integer>l2=new ArrayList<>();
        int visited[]=new int[nums.length];
        helper(nums,target,l1,l2,visited,0,0);
        return l1;
    }
    public void helper(int []nums,int target,List<List<Integer>>l1,List<Integer>l2,int []visited,int s,int idx){
        if(s>target){
            return;
        }
        if(s==target){
            l1.add(new ArrayList<>(l2));
            return;
        }
        for(int i=idx;i<nums.length;i++){
            if(visited[i]==1 || (i>0 && nums[i]==nums[i-1] && visited[i-1]==0))
            continue;
            visited[i]=1;
            l2.add(nums[i]);
            helper(nums,target,l1,l2,visited,s+nums[i],i+1);
            visited[i]=0;
            l2.remove(l2.size()-1);
        }
    }
}