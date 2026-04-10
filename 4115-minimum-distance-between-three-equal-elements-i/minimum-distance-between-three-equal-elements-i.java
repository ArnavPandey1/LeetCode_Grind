class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int minDistance = Integer.MAX_VALUE;
        boolean found = false;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] == nums[j] && nums[j] == nums[k]) {
                        // Using the simplified formula: 2 * (max_idx - min_idx)
                        int dist = 2 * (k - i);
                        minDistance = Math.min(minDistance, dist);
                        found = true;
                    }
                }
            }
        }

        return found ? minDistance : -1;
    }
}