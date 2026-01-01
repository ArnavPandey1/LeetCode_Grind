class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i[]:edges){
            if(map.containsKey(i[0])){
              map.put(i[0],map.get(i[0])+1);
            }
            else{
               map.put(i[0],1);
            if(map.containsKey(i[1])){
              map.put(i[1],map.get(i[1])+1);
            }
            else{
               map.put(i[1],1);
            }
        }
        }
        int max=Integer.MIN_VALUE;
        int ans=1;
        for(int i:map.keySet()){
            if(map.get(i)>max){
                max=map.get(i);
                ans=i;
            }
        }
        return ans;
    }
}