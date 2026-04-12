class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int nodes = 2; nodes <= n; nodes++) {
            for (int i = 1; i <= nodes; i++) {
                dp[nodes] += dp[i - 1] * dp[nodes - i];
            }
        }
        return dp[n];
    }
}