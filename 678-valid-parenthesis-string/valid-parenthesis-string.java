class Solution {
    public boolean checkValidString(String s) {
      Boolean dp[][]=new Boolean[s.length()][s.length()];
       return helper(s,0,0,dp);
    }
    public boolean helper(String s,int idx,int countOpen,Boolean dp[][]){
        if(idx>=s.length()){
            if(countOpen!=0)
            return false;
            else
            return true;
        }
        if(countOpen<0)
        return false;
        if(dp[idx][countOpen]!=null){
            return dp[idx][countOpen];
        }
        boolean t1=false;
        boolean t2=false;
        boolean t3=false;
        if(s.charAt(idx)=='('){
           t1=helper(s,idx+1,countOpen+1,dp);
        }
        else if(s.charAt(idx)==')'){
           t2=helper(s,idx+1,countOpen-1,dp);
        }
        else{
           t3=helper(s,idx+1,countOpen,dp)||helper(s,idx+1,countOpen+1,dp)||helper(s,idx+1,countOpen-1,dp);
        }
        return dp[idx][countOpen]=t1||t2||t3;
    }
}