class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>l1=new ArrayList<>();
        List<Integer>l2=new ArrayList<>();
        int []visited=new int[nums.length];
        helper(nums,l1,l2,visited);
        return l1;
    }
    public void helper(int[] nums,List<List<Integer>>l1,List<Integer>l2,int[] visited){
        if(l2.size()==nums.length){
            l1.add(new ArrayList<>(l2));
            return;
        }
        for(int i=0;i<nums.length;i++)
        { 
           if(visited[i]==1)
           continue;
           visited[i]=1;
           l2.add(nums[i]);
           helper(nums,l1,l2,visited);
           l2.remove(l2.size()-1);
           visited[i]=0;
        }
    }
}