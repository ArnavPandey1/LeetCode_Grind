class Solution {
    public int maxRepeating(String seq, String word) {
        int c=0;
        String s1=word;
        while(seq.indexOf(s1)!=-1){
             c++;
             s1+=word;
        }
        return c;
    }
}