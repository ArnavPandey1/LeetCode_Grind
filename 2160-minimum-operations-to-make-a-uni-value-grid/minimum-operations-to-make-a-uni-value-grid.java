class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer>l1=new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                l1.add(grid[i][j]);
            }
        }
        Collections.sort(l1);
        int n=l1.size();int t=n/2;
        if(n%2!=0){
           t=(n+1)/2;
        } 
        int mid=l1.get(t-1);
        int s=0;
        for(int i=0;i<l1.size();i++){
            if(l1.get(i)==mid){
                continue;
            }
            int a=Math.abs((l1.get(i)-mid))/x;
            if(a==0)return -1;
            s+=a;
        }
        return s;
    }
}