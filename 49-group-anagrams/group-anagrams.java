class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String s=strs[i];
            int arr[]=new int[26];
            for(int j=0;j<s.length();j++){
                arr[s.charAt(j)-'a']=arr[s.charAt(j)-'a']+1;
            }
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<26;j++){
                sb.append(arr[j]).append("*");
            }
            String key=sb.toString();
            if(!map.containsKey(key))
            map.put(key,new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}