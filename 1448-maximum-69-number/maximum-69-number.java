class Solution {
    public int maximum69Number (int num) {
        char ch[]=String.valueOf(num).toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i]!='9'){
            ch[i]='9';
            break;
            }
        }
        String s="";
        for(int i=0;i<ch.length;i++){
            s=s+ch[i];
        }
        return Integer.parseInt(s);
    }
}