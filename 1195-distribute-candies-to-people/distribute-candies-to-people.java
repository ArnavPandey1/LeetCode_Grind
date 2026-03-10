class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int ans[]=new int[num_people];
        int total=candies;
        int t=1;int idx=0;
        while(total>0){
            int give =Math.min(t,total);
            ans[idx%ans.length]=ans[idx%ans.length]+give;
            total-=give;
            t++;
            idx++;
        }
        return ans;
    }
}