class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int start[]=new int [flowers.length];
        int end[]=new int[flowers.length];
        for(int i=0;i<flowers.length;i++){
            start[i]=flowers[i][0];
            end[i]=flowers[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int ans[]=new int[people.length];
        for(int i=0;i<people.length;i++){
            int val=people[i];
            int ans1=-1;
            int lb=0;int ub=start.length-1;
            while(lb<=ub){
                int mid=lb+(ub-lb)/2;
                if(start[mid]<=val){
                    ans1=mid;
                    lb=mid+1;
                }
                else{
                    ub=mid-1;
                }
            }
            int ans2=-1;
            lb=0;ub=end.length-1;
            while(lb<=ub){
                 int mid=lb+(ub-lb)/2;
                if(end[mid]<val){
                    ans2=mid;
                    lb=mid+1;
                }
                else{
                    ub=mid-1;
                }
            }
            ans[i]=(ans1+1)-(ans2+1);
        }
        return ans;
    }
}