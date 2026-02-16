class Solution {
    public int reverseBits(int n) {
        int ans=0;
        for(int i=1;i<=32;i++){
           /* int a=n&1;
            ans=ans<<1;
            ans=ans|a;
            n=n>>1;*/
            ans=(ans<<1)|(n&1);
            n=n>>1;
        }
        return ans;
    }
}