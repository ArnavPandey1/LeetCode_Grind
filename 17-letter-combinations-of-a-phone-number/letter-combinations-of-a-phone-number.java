class Solution {
    String arr[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String>l1=new ArrayList<>();
        helper("",l1,digits);
        return l1;
    }
    public void helper(String s,List<String>l1,String digits){
        if(digits.length()==0){
            l1.add(s);
            return;
        }
        char ch =digits.charAt(0);
        String str=arr[ch-'0'];
        for(int i=0;i<str.length();i++){
            helper(s+str.charAt(i),l1,digits.substring(1));
        }
    }
}