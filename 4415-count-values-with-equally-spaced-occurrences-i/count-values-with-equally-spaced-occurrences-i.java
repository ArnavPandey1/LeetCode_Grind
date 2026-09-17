class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer,ArrayList<Integer>>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i]).add(i);
            }else{
                ArrayList<Integer>l1=new ArrayList<>();
                l1.add(i);
                map.put(nums[i],l1);
            }
        }
        int c=0;
        for(int i:map.keySet()){
            if(map.get(i).size()==3){
                int i1=map.get(i).get(0);
                int i2=map.get(i).get(1);
                int i3=map.get(i).get(2);
                if(i2-i1==i3-i2){
                    c++;
                }
            }
        }
        return c;
    }
}