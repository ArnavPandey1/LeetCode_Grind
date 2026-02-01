class Solution {
    public int minimumCost(int[] nums) {
        List<Integer>l1=new ArrayList<>();
        for(int i=1;i<nums.length;i++){
            l1.add(nums[i]);
        }
        Collections.sort(l1);
        return nums[0]+l1.get(0)+l1.get(1);
    }
}