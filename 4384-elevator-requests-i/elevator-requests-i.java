class Solution {
    public int elevatorRequests(int n, int[] nums) {
        int curr = 0;
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == curr) {
                continue;
            }
            s += Math.abs(nums[i] - curr);
            curr=nums[i];
        }
        return s;
    }
}