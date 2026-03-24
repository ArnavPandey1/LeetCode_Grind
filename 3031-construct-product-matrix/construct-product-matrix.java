class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int pre[]=new int[n*m];
        int suf[]=new int[n*m];
        int org[]=new int[n*m]; int k=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                org[k++]=grid[i][j]%12345;
            }
        }
        pre[0]=1;suf[suf.length-1]=1;
        for(int i=1;i<pre.length;i++){
            pre[i]=(pre[i-1]*org[i-1])%12345;
        }
        for(int i=suf.length-2;i>=0;i--){
            suf[i]=(suf[i+1]*org[i+1])%12345;
        }
        int ans[][]=new int[grid.length][grid[0].length];
        k=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                ans[i][j]=(pre[k]*suf[k])%12345;
                k++;
            }
        }
        return ans;
    }
}