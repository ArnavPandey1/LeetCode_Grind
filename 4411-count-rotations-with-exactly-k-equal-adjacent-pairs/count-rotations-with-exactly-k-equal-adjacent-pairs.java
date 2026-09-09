class Solution {
    public int countRotations(String s, int k) {
        int count=0;
        int i=0;
        while(i<s.length()){
              if(score(s)==k){
                count++;
              }
              s=s.substring(1)+s.charAt(0);
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