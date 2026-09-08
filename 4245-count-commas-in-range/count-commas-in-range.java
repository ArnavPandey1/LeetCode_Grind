class Solution {
    public int countCommas(int n) {
       int c=0;
        int s=1000;
        while(s<=n){
            c+=n-s+1;
            s*=1000;
        }
        return c;
    }
}