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
            }else if(map.get(i).size()>3){
                int a=map.get(i).get(0);
                int b=map.get(i).get(1);
                int d=b-a;int k=0;
                for(int j=2;j<map.get(i).size();j++){
                    if(map.get(i).get(j)-map.get(i).get(j-1)!=d){
                        k=-1;
                        break;
                    }
                }
                if(k==0)c++;
            }
        }
        return c;
    }
}