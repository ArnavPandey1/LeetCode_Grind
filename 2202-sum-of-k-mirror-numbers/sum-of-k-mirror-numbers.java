class Solution {
    public long kMirror(int k, int n) {
        int l=1;
        long sum=0;
        while(n>0){
            int half=(l+1)/2;
            long min=(long)Math.pow(10,half-1);
            long max=(long)Math.pow(10,half)-1;
            for(long j=min;j<=max;j++){
                String s=String.valueOf(j);
                long num;
                if(l%2==0){
                   num=Long.parseLong(s+new StringBuilder(s).reverse());
                }
                else{
                   num=Long.parseLong(s+new StringBuilder(s).reverse().substring(1));
                }
                if(isPalin(base(num,k))){
                    sum=sum+num;
                    n--;
                    if(n==0)
                    return sum;
                }
            }
            l++;
        }
        return sum;
    }
    public static boolean isPalin(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
    public static String base(long num, int k) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % k);
            num /= k;
        }
        return sb.reverse().toString();
    }
}
