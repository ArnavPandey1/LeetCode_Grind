class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n=nums.length;
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        List<Integer>l1=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(!set.contains(i))
            l1.add(i);
        }
        return l1;
    }
}