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
        int d[] = new int[nums.length];
        d[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            d[i] = nums[i] - nums[i - 1];
        }
        for (int i = 0; i < mid; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int val = -1 * queries[i][2];
            d[l] = d[l] + val;
            if (r + 1 < nums.length) {
                d[r + 1] = d[r + 1] - val;
            }
        }
        if (check(d)) {
            return true;
        }
        return false;
    }

    public boolean check(int d[]) {
        int s = 0;
        for (int i = 0; i < d.length; i++) {
            s = s + d[i];
            if (s > 0)
                return false;
        }
        return true;
    }
}