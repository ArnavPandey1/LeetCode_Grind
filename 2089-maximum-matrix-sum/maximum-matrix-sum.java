class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum=0;long count_neg=0;int smallest_neg=Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]<=0){
                    //smallest_neg=Math.max(smallest_neg,matrix[i][j]);
                    count_neg++;
                }
                smallest_neg=Math.min(smallest_neg,Math.abs(matrix[i][j]));
                sum=sum+Math.abs(matrix[i][j]);
            }
        }
        if(count_neg%2!=0){
           sum=sum-2*smallest_neg;
        }
        return sum;
    }
}