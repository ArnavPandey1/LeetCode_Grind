class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
        }
        for(int i=0;i<nums.length;i++){
            int k=map.get(nums[i]);int l=0;int c=0;
            for(int j=i;j<nums.length && j<i+k;j++){
                if(nums[j]!=nums[i]){
                   l=1;
                   break;
                }else{
                    c++;
                }
            }
            if(l==0 && c==k){
                set.add(nums[i]);
            }
        }
        System.out.println(set);
        return set.size();
    }
}