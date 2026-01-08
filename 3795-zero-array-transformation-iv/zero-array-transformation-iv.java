class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                c = 1;
                break;
            }
        }
        if (c == 0) {
            return 0;
        }
        int lb = 1;
        int ub = queries.length;
        int ans = -1;
        while (lb <= ub) {
            int mid = lb + (ub - lb) / 2;
            if (can_make_zero(nums, queries, mid)) {
                ans = mid;
                ub = mid - 1;
            } else {
                lb = mid + 1;
            }
        }
        return ans;
    }

    public boolean can_make_zero(int[] nums, int[][] queries, int mid) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            boolean[] dp = new boolean[1001];
            dp[0] = true;

            for (int q = 0; q < mid; q++) {
                int l = queries[q][0];
                int r = queries[q][1];
                int v = queries[q][2];

                if (l <= i && i <= r) {
                    for (int s = nums[i]; s >= v; s--) {
                        dp[s] |= dp[s - v];
                    }
                }
            }

            if (!dp[nums[i]])
                return false;
        }
        return true;
    }
}