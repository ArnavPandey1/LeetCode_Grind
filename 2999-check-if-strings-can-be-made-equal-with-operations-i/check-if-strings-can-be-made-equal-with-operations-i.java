class Solution {
    public boolean canBeEqual(String s1, String s2) {
        if(s1.equals(s2)) return true;
        char as1[]=s1.toCharArray();
        char as2[]=s2.toCharArray();
        char c1=as1[0];
        char c2=as1[1];
        char c3=as1[2];
        char c4=as1[3];
        as1[0]=as1[2];
        as1[2]=c1;
        if(Arrays.equals(as1,as2)) return true;
        char t1=as1[0];
        as1[0]=as1[2];
        as1[2]=t1;
        as1[1]=as1[3];
        as1[3]=c2;
        if(Arrays.equals(as1,as2)) return true;
        t1=as1[1];
        as1[1]=as1[3];
        as1[3]=t1;
        c1=as1[0];
        c2=as1[1];
        c3=as1[2];
        c4=as1[3];
        t1=as1[0];
        as1[0]=as1[2];
        as1[2]=t1;
        t1=as1[1];
        as1[1]=as1[3];
        as1[3]=t1;
        if(Arrays.equals(as1,as2)) return true;
        return false;
    }
}