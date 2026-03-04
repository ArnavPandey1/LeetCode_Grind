class Solution {
    public int numSpecial(int[][] mat) {
        int c=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]==1 && row(i,mat[i].length,mat)==1 && column(j,mat.length,mat)==1){
                    c++;
                }
            }
        }
        return c;
    }
    public int row(int i,int n,int [][]mat){
        int t=0;
        for(int k=0;k<n;k++){
            if(mat[i][k]==1)
            t++;
        }
        return t;
    }
    public int column(int i,int n,int [][]mat){
        int t=0;
        for(int k=0;k<n;k++){
            if(mat[k][i]==1)
            t++;
        }
        return t;
    }
}