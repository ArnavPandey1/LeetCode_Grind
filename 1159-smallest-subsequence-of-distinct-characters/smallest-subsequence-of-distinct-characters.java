class Solution {
    public String smallestSubsequence(String s) {
        int[] lastIdx=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            lastIdx[ch-'a']=i;
        }
        boolean taken[]=new boolean[26];
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(taken[ch-'a']){
                continue;
            }
            while(!st.isEmpty() && ch<st.peek() && lastIdx[st.peek()-'a']>i){
                  char c=st.pop();
                  taken[c-'a']=false;
            }
            st.push(ch);
            taken[ch-'a']=true;
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}