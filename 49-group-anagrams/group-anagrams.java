class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String str=strs[i];
            int arr[]=new int[26];
            for(int j=0;j<str.length();j++){
                arr[str.charAt(j)-'a']++;
            }
            String s=Arrays.toString(arr);
            if(!map.containsKey(s)){
                map.put(s,new ArrayList<>());
            }
            map.get(s).add(str);
        }
        return new ArrayList<>(map.values());
    }
}