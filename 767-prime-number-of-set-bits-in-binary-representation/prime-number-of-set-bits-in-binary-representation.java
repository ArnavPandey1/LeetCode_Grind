class Solution {
    public int countPrimeSetBits(int left, int right) {
        int c=0;
        int arr[]=new int[100001];
        Arrays.fill(arr,1);
        arr[0]=0;arr[1]=0;
        for(int i=2;i<arr.length;i++){
            if(arr[i]==1){
                for(int j=i*2;j<arr.length;j+=i){
                    arr[j]=0;
                }
            }
        }
        for(int i=left;i<=right;i++){
            int n=Integer.bitCount(i);
            if(arr[n]==1)
            c++;
        }
        return c;
    }
}