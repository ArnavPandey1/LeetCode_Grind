class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
        return false;
        char c1[]=s.toCharArray();
        char c2[]=t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        int i=0;
        while(i<c1.length && c1[i]==c2[i]){
            i++;
        }
        if(i==c1.length)
        return true;
        return false;
    }
}