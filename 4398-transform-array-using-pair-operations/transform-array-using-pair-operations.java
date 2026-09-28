class Solution {
    public boolean canTransform(int[] source, int[] target) {
        long s=0;long t=0;
        for(int i=0;i<source.length;i++){
            s+=source[i];
            t+=target[i];
        }
        if(s==t)return true;
        return false;
    }
}