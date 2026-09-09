class Solution {
    public int countRotations(String s, int k) {
        StringBuilder sb=new StringBuilder(s);
        int count=0;
        int i=0;
        while(i<sb.length()){
              if(score(sb.toString())==k){
                count++;
              }
              char ch=sb.charAt(0);
              sb.deleteCharAt(0);
              sb.append(ch);
              i++;
        }
        return count;
    }
    public int score(String st){
        int c=0;
        for(int i=0;i<st.length()-1;i++){
            if(st.charAt(i)==st.charAt(i+1)){
                c++;
            }
        }
        return c;
    }
}