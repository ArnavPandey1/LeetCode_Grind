class Solution {
    public int numSubarrayProductLessThanK(int[] arr, int k) {
        int i=0;int j=0;
        int p=1;int c=0;
        while(j<arr.length){
            p=p*arr[j];
            while(i<=j&&p>=k){
                p=p/arr[i];
                i++;
            }
            c+=j-i+1;
            j++;
        }
        return c;
    }
}