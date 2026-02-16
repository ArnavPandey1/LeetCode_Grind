class Solution {
    public int firstUniqueFreq(int[] nums) {
        LinkedHashMap<Integer,Integer>map1=new LinkedHashMap<>();
        LinkedHashMap<Integer,Integer>map2=new LinkedHashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map1.containsKey(nums[i])){
               map1.put(nums[i],map1.get(nums[i])+1);
            }
            else{
                map1.put(nums[i],1);
            }
        }
        for(int i:map1.keySet()){
            int val=map1.get(i);
            if(map2.containsKey(val)){
               map2.put(val,map2.get(val)+1);
            }
            else{
                map2.put(val,1);
            }
        }
        int flag=1;
        int ans=0;
        for(int i:map2.keySet()){
            if(map2.get(i)!=1){
                flag=0;
            }
            if(map2.get(i)==1)
            {
                ans=i;
                break;
            }
        }
        for(int i:map1.keySet()){
            if(map1.get(i)==ans){
                return i;
            }
        }
        return -1;
    }
}