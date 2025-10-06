class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][]=new int[word1.length()][word2.length()];
        return function(word1,word2,0,0,dp);
    }
    public int function(String str1,String str2,int i,int j,int dp[][]){
        if(i==str1.length()){
           return str2.length()-j;
        }
        if(j==str2.length()){
           return str1.length()-i;
        }
         if(dp[i][j]!=0){
            return dp[i][j];
         }
        int ans=0;
        if(str1.charAt(i)==str2.charAt(j)){
            ans=function(str1,str2,i+1,j+1,dp);
        }
        else{
            int insert=function(str1,str2,i,j+1,dp);
            int del=function(str1,str2,i+1,j,dp);
            int repl=function(str1,str2,i+1,j+1,dp);
            ans=1+Math.min(insert,Math.min(del,repl));
        }
        return dp[i][j]=ans;
    }
}