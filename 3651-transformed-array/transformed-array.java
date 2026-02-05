class Solution {
    public int[] constructTransformedArray(int[] arr) {
        int result[]=new int[arr.length];
        int n=arr.length;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=0)
            result[i]=arr[(i+arr[i])%n];    
            else
            {
                int val=Math.abs(arr[i]);
                val=val%n;
                result[i]=arr[(i-val+n)%n];
            }       
        }
        return result;
    }
}