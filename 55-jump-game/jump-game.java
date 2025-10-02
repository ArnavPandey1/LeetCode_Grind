class Solution {
    public boolean canJump(int[] nums) {
        int maxidx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxidx < i)
                return false;
            maxidx = Math.max(maxidx, i + nums[i]);
        }
        return true;
    }
}