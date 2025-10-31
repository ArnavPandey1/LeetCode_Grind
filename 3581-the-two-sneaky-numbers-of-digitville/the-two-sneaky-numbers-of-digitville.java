class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
               map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
        }
        List<Integer>l1=new ArrayList<>();
        for(int i:map.keySet()){
            if(map.get(i)==2){
                l1.add(i);
            }
        }
        int a[]=new int[l1.size()];
        for(int i=0;i<l1.size();i++){
            a[i]=l1.get(i);
        }
        return a;
    }
}