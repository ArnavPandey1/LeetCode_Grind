class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        //create diff array
        int d[]=new int [nums.length];
        d[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            d[i]=nums[i]-nums[i-1];
        }
        //go through all queries add do three steps
        int val=-1;
        for(int i[]:queries){
            int l=i[0];
            int r=i[1];
            //add val to the left
            d[l]=d[l]+val;
            //sub val to r+1 if exists
            if(r+1<d.length){
                d[r+1]=d[r+1]-val;
            }
        }
        //take prefix sum of d that will be the ans for array after all updates;
        for(int i=1;i<d.length;i++){
            d[i]=d[i]+d[i-1];
            if(d[i]>0)
            return false;
        }
        return d[0]<=0?true:false;
    }
}