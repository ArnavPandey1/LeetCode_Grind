class Solution {
    public List<String> summaryRanges(int[] nums) {
        TreeMap<Integer,Integer>map=new TreeMap<>();
        List<String>l1=new ArrayList<>();
        if(nums.length==0)
        return l1;
        int val=nums[0];
        map.put(val,val);
        for(int i=1;i<nums.length;i++){
            if(nums[i]-1==nums[i-1]){
                map.put(val,nums[i]);
            }else{
                val=nums[i];
                map.put(val,val);
            }
        }
        for(int i:map.keySet()){
            if(map.get(i)==i){
               l1.add(""+i);
            }else{
                l1.add(i+"->"+map.get(i));
            }
        }
        return l1;
    }
}