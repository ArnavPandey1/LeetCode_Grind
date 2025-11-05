class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>l1=new ArrayList<>();
        List<String>l2=new ArrayList<>();
        helper(s,l1,l2);
        return l1;
    }
    public void helper(String s,List<List<String>>l1,List<String>l2){
        if(s.length()==0){
            l1.add(new ArrayList<>(l2));
            return;
        }
        for(int i=0;i<s.length();i++){
            String str=s.substring(0,i+1);
            if(isPalin(str)){
                l2.add(str);
                helper(s.substring(i+1),l1,l2);
                l2.remove(l2.size()-1);
            }
        }
    }
    public boolean isPalin(String str){
         int l=0;int r=str.length()-1;
         while(l<r){
            if(str.charAt(r)!=str.charAt(l)){
                return false;
            }
            l++;
            r--;
         }
         return true;
    }
}