class Solution {
    public int countPrimes(int n) {
        if(n<2){
            return 0;
        }
        if(n==2)
        return 0;
        int arr[]=new int[n];
        Arrays.fill(arr,1);
        for(int i=2;i<arr.length;i++){
            if(arr[i]==1){
                for(int j=i+i;j<arr.length;j+=i){
                    arr[j]=0;
                }
            }
        }
        int c=0;
        for(int i=2;i<arr.length;i++){
            if(arr[i]==1)
            c++;
        }
        return c;
    }
}