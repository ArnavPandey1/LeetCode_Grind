class Solution {
    List<String> l1;

    public List<String> generateParenthesis(int n) {
        l1=new ArrayList<>();
        generate("",n,0,0);
        return l1;
    }
    public void generate(String ans,int n,int o,int c){
        if(o==n&&c==n){
           l1.add(ans);
           return;
        }
        if(c>o||c>n||o>n){
            return;
        }
        generate(ans+'(',n,o+1,c);
        generate(ans+')',n,o,c+1);
    }
}