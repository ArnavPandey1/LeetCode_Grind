class Solution {
    public int minOperations(String s) {
        String s1="";int c1=0;int c2=0;int k=0;
        String s2="";
        for(int i=0;i<s.length();i++){
            s1=s1+k;
            k=k==0?1:0;
        }
        k=1;
        for(int i=0;i<s.length();i++){
            s2=s2+k;
            k=k==0?1:0;
        }
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            char chs1=s1.charAt(i);
            char chs2=s2.charAt(i);
            if(ch!=chs1)
            c1++;
            if(ch!=chs2)
            c2++;
        }
        
        return Math.min(c1,c2);
    }
}