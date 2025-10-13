class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>l1=new ArrayList<>();
        List<String>l2=new ArrayList<>();
        partition(s,l1,l2);
        return l1;
    }
    public void partition(String s,List<List<String>>l1,List<String>l2){
        if(s.length()==0){
            l1.add(new ArrayList<>(l2));
            return;
        }
        for(int i=0;i<s.length();i++){
            if(isPalin(s.substring(0,i+1))){
                l2.add(s.substring(0,i+1));
                partition(s.substring(i+1),l1,l2);
                l2.remove(l2.size()-1);
            }
        }
    }
    public boolean isPalin(String str){
        int i=0;int j=str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }
}