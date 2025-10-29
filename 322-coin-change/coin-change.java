class Solution {
    int min;

    public int coinChange(int[] coins, int amt) {
        min = Integer.MAX_VALUE;
        if (amt == 0)
            return 0;

        // Use DP array instead of recursive helper search
        int[] dp = new int[amt + 1];
        Arrays.fill(dp, amt + 1);
        dp[0] = 0;

        helper(coins, amt, dp); // <--- still calling helper()

        min = dp[amt] > amt ? -1 : dp[amt];
        return min;
    }

    // Helper now performs the DP filling (no recursion)
    public void helper(int[] coins, int amt, int[] dp) {
        for (int i = 1; i <= amt; i++) {
            for (int c : coins) {
                if (i - c >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
        }
    }
}
