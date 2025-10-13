class Solution {
    int c;
    public int countArrangement(int n) {
        c=0;
       int nums[]=new int[n];
       for(int i=0;i<nums.length;i++){
        nums[i]=i+1;
       }
       int visited[]=new int[n];
       List<Integer>l1=new ArrayList<>();
       permute(nums,visited,l1);
       return c;
    }
    public void permute(int nums[],int []visited,List<Integer>l1){
           if(l1.size()==nums.length){
            //   if(isValid(l1))
              c++;
              return ;
           }
           for(int i=0;i<nums.length;i++){
               if(visited[i]!=0||((l1.size()+1)%nums[i]!=0&&nums[i]%(l1.size()+1)!=0))
               continue;
               visited[i]=1;
               l1.add(nums[i]);
               permute(nums,visited,l1);
               l1.remove(l1.size()-1);
               visited[i]=0;
           }
    } 
    // public boolean isValid(List<Integer>l1){
    //     for(int i=0;i<l1.size();i++){
    //         if((i+1)%l1.get(i)!=0&&l1.get(i)%(i+1)!=0)
    //         return false;
    //     }
    //     return true;
    // }
}