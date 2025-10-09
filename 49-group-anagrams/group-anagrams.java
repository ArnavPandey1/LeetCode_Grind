class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String str=strs[i];
            int arr[]=new int[26];
            for(int j=0;j<str.length();j++){
                arr[str.charAt(j)-'a']++;
            }
            if(!map.containsKey(Arrays.toString(arr))){
                map.put(Arrays.toString(arr),new ArrayList<>());
            }
            map.get(Arrays.toString(arr)).add(str);
        }
        return new ArrayList<>(map.values());
    }
}