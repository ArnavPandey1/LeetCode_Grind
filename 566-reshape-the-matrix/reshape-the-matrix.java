class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(r*c!=mat.length*mat[0].length)
        return mat;
        int arr[]=new int[r*c];//1D array bna lo 
        int ans[][]=new int[r][c];int k=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                arr[k++]=mat[i][j];
            }
        }
         k=0;
         for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
               ans[i][j]=arr[k++];
            }
         }
         return ans;
    }
}