class Solution {
    public int[] findErrorNums(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        int arr[]=new int[2];int k=0;
        for(int i=1;i<=n;i++){
            if(!map.containsKey(i)){
                arr[1]=i;
                k++;
            }
            if(map.getOrDefault(i,0)==2){
                arr[0]=i;
                k++;
            }
            if(k==2)
            break;
        }
        return arr;
    }
}