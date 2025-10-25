class Solution {
    public boolean hasSameDigits(String s) {
        while(s.length()>2){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<s.length()-1;i++){
                int ch1=s.charAt(i)-'0';
                int ch2=s.charAt(i+1)-'0';
                sb.append((ch1+ch2)%10);
            }
            s=sb.toString();
        }
        if(s.charAt(0)==s.charAt(1)){
            return true;
        }
        return false;
    }
}