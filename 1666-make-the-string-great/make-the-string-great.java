class Solution {
    public String makeGood(String s) {
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(st.isEmpty()){
                st.push(ch);
            }
           else if(Character.isUpperCase(ch)&&Character.isLowerCase(st.peek())&&Character.toLowerCase(ch)==st.peek()){
                st.pop();
            }
           else if(Character.isUpperCase(st.peek())&&Character.isLowerCase(ch)&&Character.toLowerCase(st.peek())==ch){
                st.pop();
            }
            else{
                st.push(ch);
            }
    }
    StringBuilder sb=new StringBuilder();
    while(!st.isEmpty()){
          sb.append(st.pop());
    }
    return sb.reverse().toString();
}
}