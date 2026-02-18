class Solution {
    public boolean hasAlternatingBits(int n) {
        int c=n&1;
        while(n>0){
            n=n>>1;
            int a=n&1;
            if(a==c)
            return false;
            c=a;
        }
        return true;
    }
}