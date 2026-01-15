class Solution {
    public int[] shuffle(int[] nums, int n) {
        int arr[]=new int[nums.length];int idx1=0;int idx2=n;
        for(int i=0;i<arr.length;i++){
            if(i%2==0){
                arr[i]=nums[idx1++];
            }
            else{
                arr[i]=nums[idx2++];
            }
        }
        return arr;
    }
}