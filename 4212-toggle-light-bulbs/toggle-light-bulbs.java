class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        TreeMap<Integer,Integer>map=new TreeMap<>();
        for(int i=0;i<bulbs.size();i++){
            if(map.containsKey(bulbs.get(i))){
               map.put(bulbs.get(i),map.get(bulbs.get(i))==0?1:0);
            }
            else{
                map.put(bulbs.get(i),0);
            }
        }
        List<Integer>l1=new ArrayList<>();
        for(int i:map.keySet()){
            if(map.get(i)!=1)
            l1.add(i);
        }
        return l1;
    }
}      