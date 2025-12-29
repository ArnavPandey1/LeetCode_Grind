class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(color==image[sr][sc]){
            return image;
        }
        traverse(image,image[sr][sc],sr,sc,color);
        return image;
    }
    public void traverse(int [][]image,int og_color,int i,int j,int color){
        if(i<0 ||i>=image.length || j<0|| j>=image[0].length ||image[i][j]!=og_color){
            return;
        }
        image[i][j]=color;
        traverse(image,og_color,i+1,j,color);
        traverse(image,og_color,i-1,j,color);
        traverse(image,og_color,i,j+1,color);
        traverse(image,og_color,i,j-1,color);
    }
}