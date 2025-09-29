class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
         for(int i=0;i<matrix.length;i++){
             boolean flag=binarysearch(matrix[i],target);
             if(flag==true)
             return true;
         }    
         return false;
    }
    public boolean binarysearch(int[] arr,int target){
        int lb=0;int ub=arr.length-1;
        while(lb<=ub){
            int mid=lb+(ub-lb)/2;
            if(arr[mid]==target){
                return true;
            }
            else if(arr[mid]<target){
                lb=mid+1;
            }
            else{
                ub=mid-1;
            }
        }
        return false;
    }
}