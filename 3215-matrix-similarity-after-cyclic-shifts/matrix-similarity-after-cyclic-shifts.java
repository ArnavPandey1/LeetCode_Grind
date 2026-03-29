class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int k1=k%mat[0].length;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                if(i%2==0){
                    int idx=(j-k1)<0?(mat[i].length+(j-k1)):(j-k1);
                    if(mat[i][idx]!=mat[i][j]) return false;
                }else{
                    int idx=(j+k1)%mat[i].length;
                    if(mat[i][idx]!=mat[i][j]) return false;
                }
            }
        }
        return true;
    }
}