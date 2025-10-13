class Solution {
    public int getMaximumGold(int[][] grid) {
        int max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0)
                max=Math.max(max,find(grid,i,j));
            }
        }
        return max;
    }
    public int find(int[][]grid,int i,int j){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]==0)
        return 0;
        int temp=grid[i][j];
        grid[i][j]=0;
        int raah1=find(grid,i,j+1);
        int raah2=find(grid,i+1,j);
        int raah3=find(grid,i,j-1);
        int raah4=find(grid,i-1,j);
        grid[i][j]=temp;
        return grid[i][j]+Math.max(Math.max(raah1,raah2),Math.max(raah3,raah4));
    }
}