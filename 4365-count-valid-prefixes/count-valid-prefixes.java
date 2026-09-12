class Solution {
    public int countValidPrefixes(String s) {
        int z=0;int o=0;int c=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='0')z++;
            else o++;
            if(Math.abs(z-o)<=1)c++;
        }
        return c;
    }
}