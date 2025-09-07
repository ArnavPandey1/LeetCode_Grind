class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        int temp[]=arr[0];
        List<int[]>l1=new ArrayList<>();
        for(int i=1;i<arr.length;i++){
            if(arr[i][0]<=temp[1])
            {
                temp[1]=Math.max(temp[1],arr[i][1]);
            }
            else{
                l1.add(temp);
                temp=arr[i];
            }
        }
        l1.add(temp);
        int ans[][]=new int[l1.size()][2];
        for(int i=0;i<l1.size();i++){
            ans[i]=l1.get(i);
        }
        return ans;
    }
}